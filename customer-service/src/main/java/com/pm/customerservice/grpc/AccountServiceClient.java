package com.pm.customerservice.grpc;

import com.pm.grpc.account.*;
import com.pm.grpc.customer.DefaultAccountInfo;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import io.grpc.StatusRuntimeException;

@Service
public class AccountServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceClient.class);

    @GrpcClient("account-service")
    private AccountServiceGrpc.AccountServiceBlockingStub accountServiceStub;

    @PostConstruct
    public void init() {
        logger.info("AccountServiceClient initialized");
        if (accountServiceStub == null) {
            logger.error("CRITICAL: accountServiceStub is NULL! gRPC client injection failed!");
        } else {
            logger.info("SUCCESS: accountServiceStub injected successfully");

            // Test connection
            try {
                logger.info("Testing gRPC connection to account-service...");
                // We'll test connection when actually making calls rather than here
                // since the service might not be ready during startup
            } catch (Exception e) {
                logger.warn("Could not test gRPC connection during startup: {}", e.getMessage());
            }
        }
    }

    public DefaultAccountInfo createDefaultAccount(String customerId,
                                                   com.pm.grpc.common.AccountType accountType,
                                                   String initialDeposit) {
        try {
            logger.info("Creating default account for customer: {}", customerId);

            if (accountServiceStub == null) {
                logger.error("accountServiceStub is null - gRPC client not properly injected");
                throw new RuntimeException("gRPC client not initialized - accountServiceStub is null");
            }

            CreateAccountRequest request = CreateAccountRequest.newBuilder()
                    .setCustomerId(customerId)
                    .setAccountType(accountType)
                    .setInitialDeposit(initialDeposit != null && !initialDeposit.isEmpty() ? initialDeposit : "100.00")
                    .build();

            logger.debug("Sending CreateAccount request: customerId={}, accountType={}, initialDeposit={}",
                    customerId, accountType, initialDeposit);

            CreateAccountResponse response = accountServiceStub.createAccount(request);

            if (response.getServiceResponse().getSuccess()) {
                logger.info("Successfully created account {} for customer {}", response.getAccountNumber(), customerId);
                return DefaultAccountInfo.newBuilder()
                        .setAccountId(response.getAccountId())
                        .setAccountNumber(response.getAccountNumber())
                        .setAccountType(response.getAccountType())
                        .setBalance(response.getBalance())
                        .build();
            } else {
                String errorMsg = "Failed to create account: " + response.getServiceResponse().getMessage();
                logger.error(errorMsg);
                throw new RuntimeException(errorMsg);
            }

        } catch (StatusRuntimeException e) {
            logger.error("gRPC call failed for createDefaultAccount - Status: {} - Description: {}",
                    e.getStatus().getCode(), e.getStatus().getDescription(), e);
            throw new RuntimeException("Failed to create default account - gRPC service unavailable", e);
        } catch (Exception e) {
            logger.error("Error creating default account for customer {}", customerId, e);
            throw new RuntimeException("Failed to create default account", e);
        }
    }

    public GetAccountsByCustomerResponse getAccountsByCustomer(String customerId) {
        try {
            logger.info("Getting accounts for customer: {}", customerId);

            if (accountServiceStub == null) {
                logger.error("accountServiceStub is null - gRPC client not properly injected");
                throw new RuntimeException("gRPC client not initialized - accountServiceStub is null");
            }

            GetAccountsByCustomerRequest request = GetAccountsByCustomerRequest.newBuilder()
                    .setCustomerId(customerId)
                    .build();

            logger.debug("Sending GetAccountsByCustomer request for customerId: {}", customerId);

            GetAccountsByCustomerResponse response = accountServiceStub.getAccountsByCustomer(request);

            logger.info("Retrieved {} accounts for customer {}",
                    response.getAccountsList().size(), customerId);

            return response;

        } catch (StatusRuntimeException e) {
            logger.error("gRPC call failed for getAccountsByCustomer - Status: {} - Description: {}",
                    e.getStatus().getCode(), e.getStatus().getDescription(), e);
            throw new RuntimeException("Failed to get customer accounts - gRPC service unavailable", e);
        } catch (Exception e) {
            logger.error("Error getting accounts for customer {}", customerId, e);
            throw new RuntimeException("Failed to get customer accounts", e);
        }
    }

    public ValidateCustomerResponse validateCustomer(String customerId) {
        try {
            logger.info("Validating customer via Account Service: {}", customerId);

            if (accountServiceStub == null) {
                logger.error("accountServiceStub is null - gRPC client not properly injected");
                throw new RuntimeException("gRPC client not initialized - accountServiceStub is null");
            }

            ValidateCustomerRequest request = ValidateCustomerRequest.newBuilder()
                    .setCustomerId(customerId)
                    .build();

            return accountServiceStub.validateCustomer(request);

        } catch (StatusRuntimeException e) {
            logger.error("gRPC call failed for validateCustomer - Status: {} - Description: {}",
                    e.getStatus().getCode(), e.getStatus().getDescription(), e);
            throw new RuntimeException("Failed to validate customer - gRPC service unavailable", e);
        } catch (Exception e) {
            logger.error("Error validating customer {}", customerId, e);
            throw new RuntimeException("Failed to validate customer", e);
        }
    }

    public GetAccountBalanceResponse getAccountBalance(String accountId) {
        try {
            logger.info("Getting balance for account: {}", accountId);

            if (accountServiceStub == null) {
                logger.error("accountServiceStub is null - gRPC client not properly injected");
                throw new RuntimeException("gRPC client not initialized - accountServiceStub is null");
            }

            GetAccountBalanceRequest request = GetAccountBalanceRequest.newBuilder()
                    .setAccountId(accountId)
                    .build();

            return accountServiceStub.getAccountBalance(request);

        } catch (StatusRuntimeException e) {
            logger.error("gRPC call failed for getAccountBalance - Status: {} - Description: {}",
                    e.getStatus().getCode(), e.getStatus().getDescription(), e);
            throw new RuntimeException("Failed to get account balance - gRPC service unavailable", e);
        } catch (Exception e) {
            logger.error("Error getting balance for account {}", accountId, e);
            throw new RuntimeException("Failed to get account balance", e);
        }
    }
}