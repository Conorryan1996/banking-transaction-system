package com.pm.transactionservice.service;

import com.pm.transactionservice.dto.TransactionRequestDTO;
import com.pm.transactionservice.dto.TransactionResponseDTO;
import com.pm.transactionservice.exception.InsufficientFundsException;
import com.pm.transactionservice.exception.TransactionNotFoundException;
import com.pm.transactionservice.grpc.AccountServiceClient;
import com.pm.transactionservice.mapper.TransactionMapper;
import com.pm.transactionservice.model.Transaction;
import com.pm.transactionservice.model.TransactionStatus;
import com.pm.transactionservice.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final TransactionRepository transactionRepository;
    private final AccountServiceClient accountServiceClient;

    public TransactionService(TransactionRepository transactionRepository, AccountServiceClient accountServiceClient) {
        this.transactionRepository = transactionRepository;
        this.accountServiceClient = accountServiceClient;
    }

    @Transactional
    public TransactionResponseDTO processTransaction(TransactionRequestDTO request) {
        logger.info("Processing {} transaction for account {} with amount {}",
                request.getTransactionType(), request.getAccountId(), request.getAmount());

        // Get current account balance and details
        var accountInfo = accountServiceClient.getAccountDetails(request.getAccountId().toString());
        if (!accountInfo.getServiceResponse().getSuccess()) {
            throw new RuntimeException("Account not found: " + request.getAccountId());
        }

        BigDecimal currentBalance = new BigDecimal(accountInfo.getBalance());
        BigDecimal transactionAmount = request.getAmount();
        BigDecimal newBalance;

        // Calculate new balance based on transaction type
        switch (request.getTransactionType()) {
            case DEPOSIT:
                newBalance = currentBalance.add(transactionAmount);
                break;
            case WITHDRAWAL:
                newBalance = currentBalance.subtract(transactionAmount);
                if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
                    throw new InsufficientFundsException(
                            "Insufficient funds. Current balance: " + currentBalance +
                                    ", Requested withdrawal: " + transactionAmount);
                }
                break;
            case TRANSFER:
                // For now, treat transfer as withdrawal from source account
                newBalance = currentBalance.subtract(transactionAmount);
                if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
                    throw new InsufficientFundsException(
                            "Insufficient funds for transfer. Current balance: " + currentBalance +
                                    ", Requested transfer: " + transactionAmount);
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported transaction type: " + request.getTransactionType());
        }

        // Create transaction record
        Transaction transaction = new Transaction();
        transaction.setAccountId(request.getAccountId());
        transaction.setCustomerId(UUID.fromString(accountInfo.getCustomerId()));
        transaction.setTransactionType(request.getTransactionType());
        transaction.setAmount(transactionAmount);
        transaction.setDescription(request.getDescription());
        transaction.setReferenceNumber(request.getReferenceNumber());
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setPreviousBalance(currentBalance);
        transaction.setNewBalance(newBalance);
        transaction.setProcessedDate(LocalDateTime.now());

        // Save transaction
        Transaction savedTransaction = transactionRepository.save(transaction);

        try {
            // Update account balance via gRPC
            var updateResult = accountServiceClient.updateAccountBalance(
                    request.getAccountId().toString(),
                    newBalance.toString(),
                    savedTransaction.getId().toString(),
                    request.getDescription());

            if (updateResult.getServiceResponse().getSuccess()) {
                // Mark transaction as completed
                savedTransaction.setStatus(TransactionStatus.COMPLETED);
                savedTransaction.setLastModifiedDate(LocalDateTime.now());
                savedTransaction = transactionRepository.save(savedTransaction);

                logger.info("Transaction {} completed successfully. New balance: {}",
                        savedTransaction.getId(), newBalance);
            } else {
                // Mark transaction as failed
                savedTransaction.setStatus(TransactionStatus.FAILED);
                savedTransaction.setLastModifiedDate(LocalDateTime.now());
                transactionRepository.save(savedTransaction);

                throw new RuntimeException("Failed to update account balance: " +
                        updateResult.getServiceResponse().getMessage());
            }
        } catch (Exception e) {
            // Mark transaction as failed
            savedTransaction.setStatus(TransactionStatus.FAILED);
            savedTransaction.setLastModifiedDate(LocalDateTime.now());
            transactionRepository.save(savedTransaction);

            logger.error("Failed to process transaction {}: {}", savedTransaction.getId(), e.getMessage());
            throw new RuntimeException("Transaction failed: " + e.getMessage(), e);
        }

        return TransactionMapper.toDTO(savedTransaction);
    }

    public TransactionResponseDTO getTransaction(UUID transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found: " + transactionId));
        return TransactionMapper.toDTO(transaction);
    }

    public List<TransactionResponseDTO> getTransactionsByAccount(UUID accountId, int limit, int offset) {
        List<Transaction> transactions;
        if (limit > 0) {
            transactions = transactionRepository.findByAccountIdOrderByProcessedDateDesc(accountId)
                    .stream().skip(offset).limit(limit).toList();
        } else {
            transactions = transactionRepository.findByAccountIdOrderByProcessedDateDesc(accountId);
        }

        return transactions.stream()
                .map(TransactionMapper::toDTO)
                .toList();
    }

    public List<TransactionResponseDTO> getTransactionsByCustomer(UUID customerId, int limit, int offset) {
        List<Transaction> transactions;
        if (limit > 0) {
            transactions = transactionRepository.findByCustomerIdOrderByProcessedDateDesc(customerId)
                    .stream().skip(offset).limit(limit).toList();
        } else {
            transactions = transactionRepository.findByCustomerIdOrderByProcessedDateDesc(customerId);
        }

        return transactions.stream()
                .map(TransactionMapper::toDTO)
                .toList();
    }

    public BigDecimal getAccountBalance(UUID accountId) {
        var accountInfo = accountServiceClient.getAccountDetails(accountId.toString());
        if (!accountInfo.getServiceResponse().getSuccess()) {
            throw new RuntimeException("Account not found: " + accountId);
        }
        return new BigDecimal(accountInfo.getBalance());
    }

    public long getTransactionCountByAccount(UUID accountId) {
        return transactionRepository.countByAccountId(accountId);
    }

    public long getTransactionCountByCustomer(UUID customerId) {
        return transactionRepository.countByCustomerId(customerId);
    }
}