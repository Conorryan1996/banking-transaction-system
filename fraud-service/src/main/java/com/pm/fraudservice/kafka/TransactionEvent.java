package com.pm.fraudservice.kafka;

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
    private UUID targetAccountId;
    private UUID customerId;
    private String transactionType;
    private BigDecimal amount;
    private String currency;
    private String description;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;
    
    private String status;
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;
    
    // Additional metadata for fraud detection
    private String ipAddress;
    private String deviceId;
    private String location;
}