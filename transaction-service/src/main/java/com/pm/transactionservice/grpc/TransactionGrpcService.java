package com.pm.transactionservice.grpc;

import com.pm.transactionservice.dto.TransactionRequestDTO;
import com.pm.transactionservice.dto.TransactionResponseDTO;
import com.pm.transactionservice.model.TransactionStatus;
import com.pm.transactionservice.model.TransactionType;
import com.pm.transactionservice.service.TransactionService;
import com.pm.grpc.transaction.*;
import com.pm.grpc.common.ServiceResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@GrpcService
public class TransactionGrpcService extends TransactionServiceGrpc.TransactionServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(TransactionGrpcService.class);

    @Autowired
    private TransactionService transactionService;

    @Override
    public void processTransaction(ProcessTransactionRequest request,
                                   StreamObserver<ProcessTransactionResponse> responseObserver) {
        try {
            logger.info("Processing transaction: {} for account {} with amount {}",
                    request.getTransactionType(), request.getAccountId(), request.getAmount());

            TransactionRequestDTO transactionRequest = new TransactionRequestDTO();
            transactionRequest.setAccountId(UUID.fromString(request.getAccountId()));
            transactionRequest.setTransactionType(mapFromGrpcTransactionType(request.getTransactionType()));
            transactionRequest.setAmount(new BigDecimal(request.getAmount()));
            transactionRequest.setDescription(request.getDescription());
            transactionRequest.setReferenceNumber(request.getReferenceNumber());

            TransactionResponseDTO processedTransaction = transactionService.processTransaction(transactionRequest);

            ProcessTransactionResponse response = ProcessTransactionResponse.newBuilder()
                    .setTransactionId(processedTransaction.getId())
                    .setAccountId(processedTransaction.getAccountId())
                    .setTransactionType(request.getTransactionType())
                    .setAmount(processedTransaction.getAmount())
                    .setDescription(processedTransaction.getDescription())
                    .setReferenceNumber(processedTransaction.getReferenceNumber() != null ? processedTransaction.getReferenceNumber() : "")
                    .setStatus(mapToGrpcTransactionStatus(TransactionStatus.valueOf(processedTransaction.getStatus())))
                    .setPreviousBalance(processedTransaction.getPreviousBalance())
                    .setNewBalance(processedTransaction.getNewBalance())
                    .setProcessedDate(processedTransaction.getProcessedDate())
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Transaction processed successfully")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error processing transaction", e);
            ProcessTransactionResponse response = ProcessTransactionResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to process transaction: " + e.getMessage())
                            .setErrorCode("TRANSACTION_PROCESSING_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getTransaction(GetTransactionRequest request,
                               StreamObserver<GetTransactionResponse> responseObserver) {
        try {
            logger.info("Getting transaction: {}", request.getTransactionId());

            UUID transactionId = UUID.fromString(request.getTransactionId());
            TransactionResponseDTO transaction = transactionService.getTransaction(transactionId);

            GetTransactionResponse response = GetTransactionResponse.newBuilder()
                    .setTransactionId(transaction.getId())
                    .setAccountId(transaction.getAccountId())
                    .setCustomerId(transaction.getCustomerId())
                    .setTransactionType(mapToGrpcTransactionType(TransactionType.valueOf(transaction.getTransactionType())))
                    .setAmount(transaction.getAmount())
                    .setDescription(transaction.getDescription())
                    .setReferenceNumber(transaction.getReferenceNumber() != null ? transaction.getReferenceNumber() : "")
                    .setStatus(mapToGrpcTransactionStatus(TransactionStatus.valueOf(transaction.getStatus())))
                    .setPreviousBalance(transaction.getPreviousBalance())
                    .setNewBalance(transaction.getNewBalance())
                    .setProcessedDate(transaction.getProcessedDate())
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Transaction retrieved successfully")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error getting transaction", e);
            GetTransactionResponse response = GetTransactionResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to get transaction: " + e.getMessage())
                            .setErrorCode("TRANSACTION_NOT_FOUND")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getTransactionsByAccount(GetTransactionsByAccountRequest request,
                                         StreamObserver<GetTransactionsByAccountResponse> responseObserver) {
        try {
            logger.info("Getting transactions for account: {}", request.getAccountId());

            UUID accountId = UUID.fromString(request.getAccountId());
            List<TransactionResponseDTO> transactions = transactionService.getTransactionsByAccount(
                    accountId, request.getLimit(), request.getOffset());
            
            long totalCount = transactionService.getTransactionCountByAccount(accountId);

            GetTransactionsByAccountResponse.Builder responseBuilder = GetTransactionsByAccountResponse.newBuilder()
                    .setTotalCount((int) totalCount)
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Transactions retrieved successfully")
                            .build());

            for (TransactionResponseDTO transaction : transactions) {
                GetTransactionResponse transactionResponse = GetTransactionResponse.newBuilder()
                        .setTransactionId(transaction.getId())
                        .setAccountId(transaction.getAccountId())
                        .setCustomerId(transaction.getCustomerId())
                        .setTransactionType(mapToGrpcTransactionType(TransactionType.valueOf(transaction.getTransactionType())))
                        .setAmount(transaction.getAmount())
                        .setDescription(transaction.getDescription())
                        .setReferenceNumber(transaction.getReferenceNumber() != null ? transaction.getReferenceNumber() : "")
                        .setStatus(mapToGrpcTransactionStatus(TransactionStatus.valueOf(transaction.getStatus())))
                        .setPreviousBalance(transaction.getPreviousBalance())
                        .setNewBalance(transaction.getNewBalance())
                        .setProcessedDate(transaction.getProcessedDate())
                        .build();
                responseBuilder.addTransactions(transactionResponse);
            }

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error getting transactions by account", e);
            GetTransactionsByAccountResponse response = GetTransactionsByAccountResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to get transactions: " + e.getMessage())
                            .setErrorCode("TRANSACTIONS_RETRIEVAL_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getTransactionsByCustomer(GetTransactionsByCustomerRequest request,
                                          StreamObserver<GetTransactionsByCustomerResponse> responseObserver) {
        try {
            logger.info("Getting transactions for customer: {}", request.getCustomerId());

            UUID customerId = UUID.fromString(request.getCustomerId());
            List<TransactionResponseDTO> transactions = transactionService.getTransactionsByCustomer(
                    customerId, request.getLimit(), request.getOffset());
            
            long totalCount = transactionService.getTransactionCountByCustomer(customerId);

            GetTransactionsByCustomerResponse.Builder responseBuilder = GetTransactionsByCustomerResponse.newBuilder()
                    .setTotalCount((int) totalCount)
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Transactions retrieved successfully")
                            .build());

            for (TransactionResponseDTO transaction : transactions) {
                GetTransactionResponse transactionResponse = GetTransactionResponse.newBuilder()
                        .setTransactionId(transaction.getId())
                        .setAccountId(transaction.getAccountId())
                        .setCustomerId(transaction.getCustomerId())
                        .setTransactionType(mapToGrpcTransactionType(TransactionType.valueOf(transaction.getTransactionType())))
                        .setAmount(transaction.getAmount())
                        .setDescription(transaction.getDescription())
                        .setReferenceNumber(transaction.getReferenceNumber() != null ? transaction.getReferenceNumber() : "")
                        .setStatus(mapToGrpcTransactionStatus(TransactionStatus.valueOf(transaction.getStatus())))
                        .setPreviousBalance(transaction.getPreviousBalance())
                        .setNewBalance(transaction.getNewBalance())
                        .setProcessedDate(transaction.getProcessedDate())
                        .build();
                responseBuilder.addTransactions(transactionResponse);
            }

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error getting transactions by customer", e);
            GetTransactionsByCustomerResponse response = GetTransactionsByCustomerResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to get transactions: " + e.getMessage())
                            .setErrorCode("TRANSACTIONS_RETRIEVAL_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAccountBalance(GetAccountBalanceRequest request,
                                  StreamObserver<GetAccountBalanceResponse> responseObserver) {
        try {
            logger.info("Getting balance for account: {}", request.getAccountId());

            UUID accountId = UUID.fromString(request.getAccountId());
            BigDecimal balance = transactionService.getAccountBalance(accountId);

            GetAccountBalanceResponse response = GetAccountBalanceResponse.newBuilder()
                    .setAccountId(request.getAccountId())
                    .setCurrentBalance(balance.toString())
                    .setLastUpdated(java.time.LocalDateTime.now().toString())
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Balance retrieved successfully")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error getting account balance", e);
            GetAccountBalanceResponse response = GetAccountBalanceResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to get balance: " + e.getMessage())
                            .setErrorCode("BALANCE_RETRIEVAL_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    // Utility methods for mapping between gRPC and internal enums
    private com.pm.grpc.transaction.TransactionType mapToGrpcTransactionType(TransactionType transactionType) {
        return switch (transactionType) {
            case DEPOSIT -> com.pm.grpc.transaction.TransactionType.TRANSACTION_TYPE_DEPOSIT;
            case WITHDRAWAL -> com.pm.grpc.transaction.TransactionType.TRANSACTION_TYPE_WITHDRAWAL;
            case TRANSFER -> com.pm.grpc.transaction.TransactionType.TRANSACTION_TYPE_TRANSFER;
        };
    }

    private TransactionType mapFromGrpcTransactionType(com.pm.grpc.transaction.TransactionType grpcType) {
        return switch (grpcType) {
            case TRANSACTION_TYPE_DEPOSIT -> TransactionType.DEPOSIT;
            case TRANSACTION_TYPE_WITHDRAWAL -> TransactionType.WITHDRAWAL;
            case TRANSACTION_TYPE_TRANSFER -> TransactionType.TRANSFER;
            default -> throw new IllegalArgumentException("Unknown transaction type: " + grpcType);
        };
    }

    private com.pm.grpc.transaction.TransactionStatus mapToGrpcTransactionStatus(TransactionStatus status) {
        return switch (status) {
            case PENDING -> com.pm.grpc.transaction.TransactionStatus.TRANSACTION_STATUS_PENDING;
            case SCHEDULED -> com.pm.grpc.transaction.TransactionStatus.TRANSACTION_STATUS_PENDING; // Map SCHEDULED to PENDING for gRPC
            case COMPLETED -> com.pm.grpc.transaction.TransactionStatus.TRANSACTION_STATUS_COMPLETED;
            case FAILED -> com.pm.grpc.transaction.TransactionStatus.TRANSACTION_STATUS_FAILED;
            case CANCELLED -> com.pm.grpc.transaction.TransactionStatus.TRANSACTION_STATUS_CANCELLED;
        };
    }
}