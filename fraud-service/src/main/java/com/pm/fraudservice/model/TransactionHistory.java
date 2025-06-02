package com.pm.fraudservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction_history", indexes = {
    @Index(name = "idx_customer_id", columnList = "customerId"),
    @Index(name = "idx_account_id", columnList = "accountId"),
    @Index(name = "idx_timestamp", columnList = "timestamp"),
    @Index(name = "idx_customer_timestamp", columnList = "customerId,timestamp")
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistory {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    @Column(nullable = false)
    private UUID transactionId;
    
    @Column(nullable = false)
    private UUID accountId;
    
    @Column(nullable = false)
    private UUID customerId;
    
    @Column(nullable = false)
    private String transactionType; // DEPOSIT, WITHDRAWAL, TRANSFER
    
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
    
    private String status;
    
    @Column(precision = 19, scale = 2)
    private BigDecimal balanceBefore;
    
    @Column(precision = 19, scale = 2)
    private BigDecimal balanceAfter;
    
    // Metadata for fraud detection
    private String ipAddress;
    private String deviceId;
    private String location;
    
    @Column(nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();
}