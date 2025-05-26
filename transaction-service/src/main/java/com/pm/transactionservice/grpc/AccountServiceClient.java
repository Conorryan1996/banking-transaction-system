package com.pm.transactionservice.grpc;

import com.pm.grpc.account.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.grpc.StatusRuntimeException;
import jakarta.annotation.PostConstruct;

@Service
public class AccountServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceClient.class);

    @GrpcClient("account-service")
    private AccountServiceGrpc.AccountServiceBlockingStub accountServiceStub;

    @PostConstruct
    public void init() {
        logger.info("AccountServiceClient initialized for Transaction Service");
        if (accountServiceStub == null) {
            logger.error("CRITICAL: accountServiceStub is NULL! gRPC client injection failed!");
        } else {
            logger.info("SUCCESS: accountServiceStub injected successfully");
        }
    }

    public GetAccountResponse getAccountDetails(String accountId) {
        try {
            logger.info("Getting account details for account: {}", accountId);

            if (accountServiceStub == null) {
                logger.error("accountServiceStub is null - gRPC client not properly injected");
                throw new RuntimeException("gRPC client not initialized - accountServiceStub is null");
            }

            GetAccountRequest request = GetAccountRequest.newBuilder()
                    .setAccountId(accountId)
                    .build();

            logger.debug("Sending GetAccount request for accountId: {}", accountId);

            GetAccountResponse response = accountServiceStub.getAccount(request);

            logger.info("Successfully retrieved account details for account {}", accountId);
            return response;

        } catch (StatusRuntimeException e) {
            logger.error("gRPC call failed for getAccountDetails - Status: {} - Description: {}",
                    e.getStatus().getCode(), e.getStatus().getDescription(), e);
            throw new RuntimeException("Failed to get account details - gRPC service unavailable", e);
        } catch (Exception e) {
            logger.error("Error getting account details for account {}", accountId, e);
            throw new RuntimeException("Failed to get account details", e);
        }
    }

    public UpdateAccountBalanceResponse updateAccountBalance(String accountId, String newBalance, String transactionId, String description) {
        try {
            logger.info("Updating balance for account {} to {} (transaction: {})", accountId, newBalance, transactionId);

            if (accountServiceStub == null) {
                logger.error("accountServiceStub is null - gRPC client not properly injected");
                throw new RuntimeException("gRPC client not initialized - accountServiceStub is null");
            }

            UpdateAccountBalanceRequest request = UpdateAccountBalanceRequest.newBuilder()
                    .setAccountId(accountId)
                    .setNewBalance(newBalance)
                    .setTransactionId(transactionId != null ? transactionId : "")
                    .setDescription(description != null ? description : "Balance update")
                    .build();

            logger.debug("Sending UpdateAccountBalance request: accountId={}, newBalance={}, transactionId={}",
                    accountId, newBalance, transactionId);

            UpdateAccountBalanceResponse response = accountServiceStub.updateAccountBalance(request);

            if (response.getServiceResponse().getSuccess()) {
                logger.info("Successfully updated balance for account {} from {} to {}",
                        accountId, response.getPreviousBalance(), response.getNewBalance());
            } else {
                logger.error("Failed to update account balance: {}", response.getServiceResponse().getMessage());
            }

            return response;

        } catch (StatusRuntimeException e) {
            logger.error("gRPC call failed for updateAccountBalance - Status: {} - Description: {}",
                    e.getStatus().getCode(), e.getStatus().getDescription(), e);
            throw new RuntimeException("Failed to update account balance - gRPC service unavailable", e);
        } catch (Exception e) {
            logger.error("Error updating balance for account {}", accountId, e);
            throw new RuntimeException("Failed to update account balance", e);
        }
    }
}