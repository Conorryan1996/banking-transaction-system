package com.pm.fraudservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "fraud_alerts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudAlert {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    @Column(nullable = false)
    private UUID customerId;
    
    @Column(nullable = false)
    private UUID accountId;
    
    private UUID transactionId;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FraudType fraudType;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AlertStatus status = AlertStatus.ACTIVE;
    
    @Column(nullable = false)
    private LocalDateTime detectedAt = LocalDateTime.now();
    
    private LocalDateTime resolvedAt;
    
    private String resolution;
}