package com.pm.accountservice.grpc;

import com.pm.accountservice.dto.AccountRequestDTO;
import com.pm.accountservice.dto.AccountResponseDTO;
import com.pm.accountservice.model.AccountStatus;
import com.pm.accountservice.model.AccountType;
import com.pm.accountservice.service.AccountService;
import com.pm.grpc.account.*;
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
public class AccountGrpcService extends AccountServiceGrpc.AccountServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(AccountGrpcService.class);

    @Autowired
    private AccountService accountService;

    @Override
    public void createAccount(CreateAccountRequest request,
                              StreamObserver<CreateAccountResponse> responseObserver) {
        try {
            logger.info("Creating account for customer: {}", request.getCustomerId());

            AccountRequestDTO accountRequest = new AccountRequestDTO();
            accountRequest.setCustomerId(UUID.fromString(request.getCustomerId()));
            accountRequest.setAccountType(mapFromGrpcAccountType(request.getAccountType()));
            accountRequest.setInitialDeposit(new BigDecimal(request.getInitialDeposit()));

            AccountResponseDTO createdAccount = accountService.createAccount(accountRequest);

            CreateAccountResponse response = CreateAccountResponse.newBuilder()
                    .setAccountId(createdAccount.getId())
                    .setAccountNumber(createdAccount.getAccountNumber())
                    .setCustomerId(createdAccount.getCustomerId())
                    .setAccountType(request.getAccountType())
                    .setBalance(createdAccount.getBalance())
                    .setStatus(mapToGrpcAccountStatus(AccountStatus.valueOf(createdAccount.getStatus())))
                    .setCreatedDate(createdAccount.getCreatedDate())
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Account created successfully")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error creating account", e);
            CreateAccountResponse response = CreateAccountResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to create account: " + e.getMessage())
                            .setErrorCode("ACCOUNT_CREATION_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAccount(GetAccountRequest request,
                           StreamObserver<GetAccountResponse> responseObserver) {
        try {
            logger.info("Getting account: {}", request.getAccountId());

            UUID accountId = UUID.fromString(request.getAccountId());
            AccountResponseDTO account = accountService.getAccount(accountId);

            GetAccountResponse response = GetAccountResponse.newBuilder()
                    .setAccountId(account.getId())
                    .setAccountNumber(account.getAccountNumber())
                    .setCustomerId(account.getCustomerId())
                    .setAccountType(mapToGrpcAccountType(AccountType.valueOf(account.getAccountType())))
                    .setBalance(account.getBalance())
                    .setStatus(mapToGrpcAccountStatus(AccountStatus.valueOf(account.getStatus())))
                    .setCreatedDate(account.getCreatedDate())
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Account retrieved successfully")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error getting account", e);
            GetAccountResponse response = GetAccountResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to get account: " + e.getMessage())
                            .setErrorCode("ACCOUNT_NOT_FOUND")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAccountsByCustomer(GetAccountsByCustomerRequest request,
                                      StreamObserver<GetAccountsByCustomerResponse> responseObserver) {
        try {
            logger.info("Getting accounts for customer: {}", request.getCustomerId());

            UUID customerId = UUID.fromString(request.getCustomerId());
            List<AccountResponseDTO> accounts = accountService.getAccountsByCustomer(customerId);

            GetAccountsByCustomerResponse.Builder responseBuilder = GetAccountsByCustomerResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Accounts retrieved successfully")
                            .build());

            for (AccountResponseDTO account : accounts) {
                GetAccountResponse accountResponse = GetAccountResponse.newBuilder()
                        .setAccountId(account.getId())
                        .setAccountNumber(account.getAccountNumber())
                        .setCustomerId(account.getCustomerId())
                        .setAccountType(mapToGrpcAccountType(AccountType.valueOf(account.getAccountType())))
                        .setBalance(account.getBalance())
                        .setStatus(mapToGrpcAccountStatus(AccountStatus.valueOf(account.getStatus())))
                        .setCreatedDate(account.getCreatedDate())
                        .build();
                responseBuilder.addAccounts(accountResponse);
            }

            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error getting accounts by customer", e);
            GetAccountsByCustomerResponse response = GetAccountsByCustomerResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to get accounts: " + e.getMessage())
                            .setErrorCode("ACCOUNTS_RETRIEVAL_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateAccountStatus(UpdateAccountStatusRequest request,
                                    StreamObserver<UpdateAccountStatusResponse> responseObserver) {
        try {
            logger.info("Updating account status: {} to {}", request.getAccountId(), request.getNewStatus());

            UUID accountId = UUID.fromString(request.getAccountId());
            AccountStatus newStatus = mapFromGrpcAccountStatus(request.getNewStatus());
            AccountResponseDTO updatedAccount = accountService.updateAccountStatus(accountId, newStatus);

            UpdateAccountStatusResponse response = UpdateAccountStatusResponse.newBuilder()
                    .setAccountId(updatedAccount.getId())
                    .setStatus(mapToGrpcAccountStatus(AccountStatus.valueOf(updatedAccount.getStatus())))
                    .setLastModifiedDate(updatedAccount.getCreatedDate()) // Using createdDate as lastModified isn't in DTO
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Account status updated successfully")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error updating account status", e);
            UpdateAccountStatusResponse response = UpdateAccountStatusResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to update account status: " + e.getMessage())
                            .setErrorCode("STATUS_UPDATE_ERROR")
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
            BigDecimal balance = accountService.getBalance(accountId);

            GetAccountBalanceResponse response = GetAccountBalanceResponse.newBuilder()
                    .setAccountId(request.getAccountId())
                    .setBalance(balance.toString())
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

    @Override
    public void validateCustomer(ValidateCustomerRequest request,
                                 StreamObserver<ValidateCustomerResponse> responseObserver) {
        try {
            logger.info("Validating customer: {}", request.getCustomerId());

            // This is a placeholder - in a real implementation, you would call the Customer Service
            // For now, we'll assume all customers are valid if they have accounts
            UUID customerId = UUID.fromString(request.getCustomerId());
            List<AccountResponseDTO> accounts = accountService.getAccountsByCustomer(customerId);

            boolean exists = !accounts.isEmpty();
            String customerName = exists ? "Customer with accounts" : "";

            ValidateCustomerResponse response = ValidateCustomerResponse.newBuilder()
                    .setExists(exists)
                    .setCustomerName(customerName)
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("Customer validation completed")
                            .build())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (Exception e) {
            logger.error("Error validating customer", e);
            ValidateCustomerResponse response = ValidateCustomerResponse.newBuilder()
                    .setExists(false)
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Error validating customer: " + e.getMessage())
                            .setErrorCode("VALIDATION_ERROR")
                            .build())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    // Utility methods for mapping between gRPC and internal enums
    private com.pm.grpc.common.AccountType mapToGrpcAccountType(AccountType accountType) {
        return switch (accountType) {
            case CHECKING -> com.pm.grpc.common.AccountType.ACCOUNT_TYPE_CHECKING;
            case SAVINGS -> com.pm.grpc.common.AccountType.ACCOUNT_TYPE_SAVINGS;
            case BUSINESS_CHECKING -> com.pm.grpc.common.AccountType.ACCOUNT_TYPE_BUSINESS_CHECKING;
            case BUSINESS_SAVINGS -> com.pm.grpc.common.AccountType.ACCOUNT_TYPE_BUSINESS_SAVINGS;
        };
    }

    private AccountType mapFromGrpcAccountType(com.pm.grpc.common.AccountType grpcType) {
        return switch (grpcType) {
            case ACCOUNT_TYPE_CHECKING -> AccountType.CHECKING;
            case ACCOUNT_TYPE_SAVINGS -> AccountType.SAVINGS;
            case ACCOUNT_TYPE_BUSINESS_CHECKING -> AccountType.BUSINESS_CHECKING;
            case ACCOUNT_TYPE_BUSINESS_SAVINGS -> AccountType.BUSINESS_SAVINGS;
            default -> throw new IllegalArgumentException("Unknown account type: " + grpcType);
        };
    }

    private com.pm.grpc.common.AccountStatus mapToGrpcAccountStatus(AccountStatus status) {
        return switch (status) {
            case ACTIVE -> com.pm.grpc.common.AccountStatus.ACCOUNT_STATUS_ACTIVE;
            case INACTIVE -> com.pm.grpc.common.AccountStatus.ACCOUNT_STATUS_INACTIVE;
            case FROZEN -> com.pm.grpc.common.AccountStatus.ACCOUNT_STATUS_FROZEN;
            case CLOSED -> com.pm.grpc.common.AccountStatus.ACCOUNT_STATUS_CLOSED;
        };
    }

    private AccountStatus mapFromGrpcAccountStatus(com.pm.grpc.common.AccountStatus grpcStatus) {
        return switch (grpcStatus) {
            case ACCOUNT_STATUS_ACTIVE -> AccountStatus.ACTIVE;
            case ACCOUNT_STATUS_INACTIVE -> AccountStatus.INACTIVE;
            case ACCOUNT_STATUS_FROZEN -> AccountStatus.FROZEN;
            case ACCOUNT_STATUS_CLOSED -> AccountStatus.CLOSED;
            default -> throw new IllegalArgumentException("Unknown account status: " + grpcStatus);
        };
    }
}