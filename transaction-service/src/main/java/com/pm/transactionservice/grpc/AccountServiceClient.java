package com.pm.transactionservice.grpc;

import com.pm.grpc.account.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.grpc.StatusRuntimeException;

@Service
public class AccountServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceClient.class);

    @GrpcClient("account-service")
    private AccountServiceGrpc.AccountServiceBlockingStub accountServiceStub;

    public GetAccountResponse getAccountDetails(String accountId) {
        try {
            logger.info("Getting account details for account: {}", accountId);

            GetAccountRequest request = GetAccountRequest.newBuilder()
                    .setAccountId(accountId)
                    .build();

            return accountServiceStub.getAccount(request);

        } catch (StatusRuntimeException e) {
            logger.error("gRPC call failed for getAccountDetails - Status: {} - Description: {}",
                    e.getStatus().getCode(), e.getStatus().getDescription());
            throw new RuntimeException("Failed to get account details - gRPC service unavailable", e);
        } catch (Exception e) {
            logger.error("Error getting account details for account {}", accountId, e);
            throw new RuntimeException("Failed to get account details", e);
        }
    }

    public UpdateAccountBalanceResponse updateAccountBalance(String accountId, String newBalance) {
        try {
            logger.info("Updating balance for account {} to {}", accountId, newBalance);

            // Create a custom request for balance update
            // Note: We need to add this to the proto definition
            UpdateAccountBalanceRequest request = UpdateAccountBalanceRequest.newBuilder()
                    .setAccountId(accountId)
                    .setNewBalance(newBalance)
                    .build();

            return accountServiceStub.updateAccountBalance(request);

        } catch (StatusRuntimeException e) {
            logger.error("gRPC call failed for updateAccountBalance - Status: {} - Description: {}",
                    e.getStatus().getCode(), e.getStatus().getDescription());
            throw new RuntimeException("Failed to update account balance - gRPC service unavailable", e);
        } catch (Exception e) {
            logger.error("Error updating balance for account {}", accountId, e);
            throw new RuntimeException("Failed to update account balance", e);
        }
    }
}