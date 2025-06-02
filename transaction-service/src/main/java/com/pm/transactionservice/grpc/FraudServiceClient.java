package com.pm.transactionservice.grpc;

import com.pm.grpc.fraud.*;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Service
public class FraudServiceClient {
    
    @GrpcClient("fraud-service")
    private FraudServiceGrpc.FraudServiceBlockingStub fraudServiceStub;
    
    public CheckTransactionResponse checkTransaction(UUID customerId, UUID accountId, 
                                                   String transactionType, BigDecimal amount) {
        try {
            CheckTransactionRequest request = CheckTransactionRequest.newBuilder()
                    .setCustomerId(customerId.toString())
                    .setAccountId(accountId.toString())
                    .setTransactionType(transactionType)
                    .setAmount(amount.toString())
                    .build();
            
            CheckTransactionResponse response = fraudServiceStub.checkTransaction(request);
            log.info("Fraud check response for customer {}: isFraudulent={}", 
                    customerId, response.getIsFraudulent());
            
            return response;
            
        } catch (StatusRuntimeException e) {
            log.error("Failed to check transaction for fraud", e);
            // In case of error, default to allowing the transaction
            // In production, you might want to be more conservative
            return CheckTransactionResponse.newBuilder()
                    .setIsFraudulent(false)
                    .setServiceResponse(com.pm.grpc.common.ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Fraud service unavailable")
                            .build())
                    .build();
        }
    }
}