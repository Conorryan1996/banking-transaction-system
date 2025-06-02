package com.pm.fraudservice.service;

import com.pm.fraudservice.kafka.TransactionEvent;
import com.pm.fraudservice.model.*;
import com.pm.fraudservice.repository.FraudAlertRepository;
import com.pm.fraudservice.repository.TransactionHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class FraudDetectionService {
    
    private final TransactionHistoryRepository transactionHistoryRepository;
    private final FraudAlertRepository fraudAlertRepository;
    
    @Value("${fraud.detection.daily.withdrawal.amount.limit:1000}")
    private BigDecimal dailyWithdrawalAmountLimit;
    
    @Value("${fraud.detection.daily.withdrawal.count.limit:5}")
    private int dailyWithdrawalCountLimit;
    
    @Transactional
    public void processTransactionEvent(TransactionEvent event) {
        // Save transaction history
        TransactionHistory history = saveTransactionHistory(event);
        
        // Only check fraud for withdrawals and transfers
        if ("WITHDRAWAL".equals(event.getTransactionType()) || 
            "TRANSFER".equals(event.getTransactionType())) {
            
            checkFraudRules(event, history);
        }
    }
    
    private TransactionHistory saveTransactionHistory(TransactionEvent event) {
        TransactionHistory history = TransactionHistory.builder()
                .transactionId(event.getTransactionId())
                .accountId(event.getAccountId())
                .customerId(event.getCustomerId())
                .transactionType(event.getTransactionType())
                .amount(event.getAmount())
                .timestamp(event.getTimestamp())
                .status(event.getStatus())
                .balanceBefore(event.getBalanceBefore())
                .balanceAfter(event.getBalanceAfter())
                .ipAddress(event.getIpAddress())
                .deviceId(event.getDeviceId())
                .location(event.getLocation())
                .build();
        
        return transactionHistoryRepository.save(history);
    }
    
    private void checkFraudRules(TransactionEvent event, TransactionHistory history) {
        LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
        
        // Rule 1: Check daily withdrawal amount
        BigDecimal dailyWithdrawalAmount = transactionHistoryRepository
                .sumAmountByCustomerIdAndTransactionTypeAndTimestampAfter(
                        event.getCustomerId(), "WITHDRAWAL", startOfDay);
        
        if (dailyWithdrawalAmount.compareTo(dailyWithdrawalAmountLimit) > 0) {
            createFraudAlert(event, FraudType.EXCESSIVE_WITHDRAWAL_AMOUNT,
                    String.format("Daily withdrawal amount of %s exceeds limit of %s",
                            dailyWithdrawalAmount, dailyWithdrawalAmountLimit));
        }
        
        // Rule 2: Check daily withdrawal count
        long dailyWithdrawalCount = transactionHistoryRepository
                .countByCustomerIdAndTransactionTypeAndTimestampAfter(
                        event.getCustomerId(), "WITHDRAWAL", startOfDay);
        
        if (dailyWithdrawalCount > dailyWithdrawalCountLimit) {
            createFraudAlert(event, FraudType.EXCESSIVE_WITHDRAWAL_FREQUENCY,
                    String.format("Daily withdrawal count of %d exceeds limit of %d",
                            dailyWithdrawalCount, dailyWithdrawalCountLimit));
        }
    }
    
    private void createFraudAlert(TransactionEvent event, FraudType fraudType, String description) {
        // Check if alert already exists for this customer today
        boolean alertExists = fraudAlertRepository.existsByCustomerIdAndStatusAndDetectedAtAfter(
                event.getCustomerId(), AlertStatus.ACTIVE, 
                LocalDateTime.now().toLocalDate().atStartOfDay());
        
        if (!alertExists) {
            FraudAlert alert = FraudAlert.builder()
                    .customerId(event.getCustomerId())
                    .accountId(event.getAccountId())
                    .transactionId(event.getTransactionId())
                    .fraudType(fraudType)
                    .description(description)
                    .status(AlertStatus.ACTIVE)
                    .build();
            
            fraudAlertRepository.save(alert);
            log.warn("Fraud alert created for customer {}: {}", event.getCustomerId(), description);
        }
    }
    
    public boolean checkTransactionForFraud(UUID customerId, String transactionType, BigDecimal amount) {
        LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
        
        // For real-time fraud check before transaction processing
        if ("WITHDRAWAL".equals(transactionType)) {
            // Check if adding this amount would exceed daily limit
            BigDecimal currentDailyAmount = transactionHistoryRepository
                    .sumAmountByCustomerIdAndTransactionTypeAndTimestampAfter(
                            customerId, "WITHDRAWAL", startOfDay);
            
            if (currentDailyAmount.add(amount).compareTo(dailyWithdrawalAmountLimit) > 0) {
                log.warn("Transaction would exceed daily withdrawal limit for customer {}", customerId);
                return true; // Fraud detected
            }
            
            // Check withdrawal count
            long currentCount = transactionHistoryRepository
                    .countByCustomerIdAndTransactionTypeAndTimestampAfter(
                            customerId, "WITHDRAWAL", startOfDay);
            
            if (currentCount >= dailyWithdrawalCountLimit) {
                log.warn("Transaction would exceed daily withdrawal count for customer {}", customerId);
                return true; // Fraud detected
            }
        }
        
        return false; // No fraud detected
    }
}