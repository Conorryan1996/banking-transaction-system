package com.pm.fraudservice.grpc;

import com.pm.fraudservice.service.FraudDetectionService;
import com.pm.grpc.common.ServiceResponse;
import com.pm.grpc.fraud.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class FraudGrpcService extends FraudServiceGrpc.FraudServiceImplBase {
    
    private final FraudDetectionService fraudDetectionService;
    
    @Override
    public void checkTransaction(CheckTransactionRequest request, 
                               StreamObserver<CheckTransactionResponse> responseObserver) {
        log.info("Checking transaction for fraud: customerId={}, transactionType={}, amount={}",
                request.getCustomerId(), request.getTransactionType(), request.getAmount());
        
        try {
            UUID customerId = UUID.fromString(request.getCustomerId());
            BigDecimal amount = new BigDecimal(request.getAmount());
            
            boolean isFraudulent = fraudDetectionService.checkTransactionForFraud(
                    customerId, request.getTransactionType(), amount);
            
            CheckTransactionResponse.Builder responseBuilder = CheckTransactionResponse.newBuilder()
                    .setIsFraudulent(isFraudulent);
            
            if (isFraudulent) {
                responseBuilder.setReason("Transaction violates fraud detection rules");
                
                // Add triggered rules information
                if ("WITHDRAWAL".equals(request.getTransactionType())) {
                    responseBuilder.addTriggeredRules(FraudRule.newBuilder()
                            .setRuleName("DAILY_WITHDRAWAL_LIMIT")
                            .setDescription("Daily withdrawal limit exceeded")
                            .setThreshold("Configurable via environment")
                            .build());
                }
            }
            
            responseBuilder.setServiceResponse(ServiceResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage(isFraudulent ? "Fraud detected" : "Transaction approved")
                    .build());
            
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            log.error("Error checking transaction for fraud", e);
            
            CheckTransactionResponse errorResponse = CheckTransactionResponse.newBuilder()
                    .setIsFraudulent(false) // Default to allowing transaction on error
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Error checking fraud: " + e.getMessage())
                            .setErrorCode("FRAUD_CHECK_ERROR")
                            .build())
                    .build();
            
            responseObserver.onNext(errorResponse);
            responseObserver.onCompleted();
        }
    }
    
    @Override
    public void getCustomerAlerts(GetCustomerAlertsRequest request,
                                StreamObserver<GetCustomerAlertsResponse> responseObserver) {
        // Implementation for getting customer alerts
        // This is a placeholder - implement based on requirements
        
        GetCustomerAlertsResponse response = GetCustomerAlertsResponse.newBuilder()
                .setServiceResponse(ServiceResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Customer alerts retrieved")
                        .build())
                .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}