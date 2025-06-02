package com.pm.transactionservice.service;

import com.pm.transactionservice.dto.TransactionRequestDTO;
import com.pm.transactionservice.dto.TransactionResponseDTO;
import com.pm.transactionservice.exception.FraudDetectedException;
import com.pm.transactionservice.exception.InsufficientFundsException;
import com.pm.transactionservice.exception.TransactionNotFoundException;
import com.pm.transactionservice.grpc.AccountServiceClient;
import com.pm.transactionservice.grpc.FraudServiceClient;
import com.pm.transactionservice.kafka.TransactionEvent;
import com.pm.transactionservice.kafka.TransactionEventProducer;
import com.pm.transactionservice.mapper.TransactionMapper;
import com.pm.transactionservice.model.Transaction;
import com.pm.transactionservice.model.TransactionStatus;
import com.pm.transactionservice.model.TransactionType;
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
    private final TransactionEventProducer transactionEventProducer;
    private final FraudServiceClient fraudServiceClient;

    public TransactionService(TransactionRepository transactionRepository, 
                            AccountServiceClient accountServiceClient,
                            TransactionEventProducer transactionEventProducer,
                            FraudServiceClient fraudServiceClient) {
        this.transactionRepository = transactionRepository;
        this.accountServiceClient = accountServiceClient;
        this.transactionEventProducer = transactionEventProducer;
        this.fraudServiceClient = fraudServiceClient;
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
        UUID customerId = UUID.fromString(accountInfo.getCustomerId());
        
        // Check for fraud before processing (only for withdrawals and transfers)
        if (request.getTransactionType() == TransactionType.WITHDRAWAL || 
            request.getTransactionType() == TransactionType.TRANSFER) {
            
            var fraudCheckResponse = fraudServiceClient.checkTransaction(
                    customerId, request.getAccountId(), 
                    request.getTransactionType().toString(), transactionAmount);
            
            if (fraudCheckResponse.getIsFraudulent()) {
                logger.warn("Fraud detected for transaction: customerId={}, type={}, amount={}, reason={}",
                        customerId, request.getTransactionType(), transactionAmount, 
                        fraudCheckResponse.getReason());
                throw new FraudDetectedException("Transaction blocked due to fraud detection: " + 
                        fraudCheckResponse.getReason());
            }
        }
        
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
                // Validate target account exists
                if (request.getTargetAccountId() == null) {
                    throw new IllegalArgumentException("Target account ID is required for transfers");
                }
                
                var targetAccountInfo = accountServiceClient.getAccountDetails(request.getTargetAccountId().toString());
                if (!targetAccountInfo.getServiceResponse().getSuccess()) {
                    throw new RuntimeException("Target account not found: " + request.getTargetAccountId());
                }
                
                // Check if source has sufficient funds
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
        
        // Set target account for transfers
        if (request.getTransactionType() == TransactionType.TRANSFER) {
            transaction.setTargetAccountId(request.getTargetAccountId());
        }

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
                // For transfers, also update the target account
                if (request.getTransactionType() == TransactionType.TRANSFER) {
                    var targetAccountInfo = accountServiceClient.getAccountDetails(request.getTargetAccountId().toString());
                    BigDecimal targetCurrentBalance = new BigDecimal(targetAccountInfo.getBalance());
                    BigDecimal targetNewBalance = targetCurrentBalance.add(transactionAmount);
                    
                    var targetUpdateResult = accountServiceClient.updateAccountBalance(
                            request.getTargetAccountId().toString(),
                            targetNewBalance.toString(),
                            savedTransaction.getId().toString(),
                            "Transfer from account " + request.getAccountId());
                    
                    if (!targetUpdateResult.getServiceResponse().getSuccess()) {
                        // Rollback source account
                        accountServiceClient.updateAccountBalance(
                                request.getAccountId().toString(),
                                currentBalance.toString(),
                                savedTransaction.getId().toString(),
                                "Rollback - transfer failed");
                        
                        throw new RuntimeException("Failed to credit target account: " +
                                targetUpdateResult.getServiceResponse().getMessage());
                    }
                    
                    // Create a deposit transaction for the target account
                    Transaction targetTransaction = new Transaction();
                    targetTransaction.setAccountId(request.getTargetAccountId());
                    targetTransaction.setCustomerId(UUID.fromString(targetAccountInfo.getCustomerId()));
                    targetTransaction.setTransactionType(TransactionType.DEPOSIT);
                    targetTransaction.setAmount(transactionAmount);
                    targetTransaction.setDescription("Transfer from account " + request.getAccountId());
                    targetTransaction.setReferenceNumber(savedTransaction.getId().toString());
                    targetTransaction.setStatus(TransactionStatus.COMPLETED);
                    targetTransaction.setPreviousBalance(targetCurrentBalance);
                    targetTransaction.setNewBalance(targetNewBalance);
                    targetTransaction.setProcessedDate(LocalDateTime.now());
                    transactionRepository.save(targetTransaction);
                    
                    // Publish event for target account transaction
                    publishTransactionEvent(targetTransaction, targetAccountInfo.getCustomerId());
                }
                
                // Mark transaction as completed
                savedTransaction.setStatus(TransactionStatus.COMPLETED);
                savedTransaction.setLastModifiedDate(LocalDateTime.now());
                savedTransaction = transactionRepository.save(savedTransaction);

                logger.info("Transaction {} completed successfully. New balance: {}",
                        savedTransaction.getId(), newBalance);
                
                // Send transaction event to Kafka
                publishTransactionEvent(savedTransaction, accountInfo.getCustomerId());
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
    
    @Transactional
    public TransactionResponseDTO scheduleTransaction(TransactionRequestDTO request) {
        logger.info("Scheduling {} transaction for account {} with amount {} for date {}",
                request.getTransactionType(), request.getAccountId(), request.getAmount(), request.getScheduledDate());

        // Validate scheduled date is in the future
        if (request.getScheduledDate() == null || request.getScheduledDate().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Scheduled date must be in the future");
        }

        // Get current account balance and details
        var accountInfo = accountServiceClient.getAccountDetails(request.getAccountId().toString());
        if (!accountInfo.getServiceResponse().getSuccess()) {
            throw new RuntimeException("Account not found: " + request.getAccountId());
        }

        BigDecimal currentBalance = new BigDecimal(accountInfo.getBalance());
        BigDecimal transactionAmount = request.getAmount();
        UUID customerId = UUID.fromString(accountInfo.getCustomerId());
        
        // For transfers, validate target account exists
        if (request.getTransactionType() == TransactionType.TRANSFER) {
            if (request.getTargetAccountId() == null) {
                throw new IllegalArgumentException("Target account ID is required for transfers");
            }
            
            var targetAccountInfo = accountServiceClient.getAccountDetails(request.getTargetAccountId().toString());
            if (!targetAccountInfo.getServiceResponse().getSuccess()) {
                throw new RuntimeException("Target account not found: " + request.getTargetAccountId());
            }
        }

        // Create scheduled transaction record
        Transaction transaction = new Transaction();
        transaction.setAccountId(request.getAccountId());
        transaction.setCustomerId(customerId);
        transaction.setTransactionType(request.getTransactionType());
        transaction.setAmount(transactionAmount);
        transaction.setDescription(request.getDescription());
        transaction.setReferenceNumber(request.getReferenceNumber());
        transaction.setStatus(TransactionStatus.SCHEDULED);
        transaction.setPreviousBalance(currentBalance);
        transaction.setNewBalance(currentBalance); // Will be updated when processed
        transaction.setScheduledDate(request.getScheduledDate());
        transaction.setProcessedDate(request.getScheduledDate()); // Will be the actual date when processed
        
        // Set target account for transfers
        if (request.getTransactionType() == TransactionType.TRANSFER) {
            transaction.setTargetAccountId(request.getTargetAccountId());
        }

        // Save scheduled transaction
        Transaction savedTransaction = transactionRepository.save(transaction);

        logger.info("Transaction {} scheduled successfully for {}", 
                savedTransaction.getId(), savedTransaction.getScheduledDate());

        return TransactionMapper.toDTO(savedTransaction);
    }
    
    private void publishTransactionEvent(Transaction transaction, String customerId) {
        try {
            TransactionEvent event = TransactionEvent.builder()
                    .transactionId(transaction.getId())
                    .accountId(transaction.getAccountId())
                    .targetAccountId(transaction.getTargetAccountId())
                    .customerId(UUID.fromString(customerId))
                    .transactionType(transaction.getTransactionType().toString())
                    .amount(transaction.getAmount())
                    .currency("USD")
                    .description(transaction.getDescription())
                    .timestamp(transaction.getProcessedDate())
                    .status(transaction.getStatus().toString())
                    .balanceBefore(transaction.getPreviousBalance())
                    .balanceAfter(transaction.getNewBalance())
                    .build();
            
            transactionEventProducer.sendTransactionEvent(event);
        } catch (Exception e) {
            // Log error but don't fail transaction
            logger.error("Failed to publish transaction event for transaction: {}", 
                    transaction.getId(), e);
        }
    }
}