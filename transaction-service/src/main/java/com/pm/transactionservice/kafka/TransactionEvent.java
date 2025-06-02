package com.pm.transactionservice.kafka;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {
    
    private UUID transactionId;
    private UUID accountId;
    private UUID targetAccountId; // For transfers
    private UUID customerId;
    private String transactionType; // DEPOSIT, WITHDRAWAL, TRANSFER
    private BigDecimal amount;
    private String currency = "USD";
    private String description;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;
    
    private String status; // PENDING, COMPLETED, FAILED
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;
    
    // Additional metadata for fraud detection
    private String ipAddress;
    private String deviceId;
    private String location;
}