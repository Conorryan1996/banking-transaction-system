package com.pm.fraudservice.repository;

import com.pm.fraudservice.model.AlertStatus;
import com.pm.fraudservice.model.FraudAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface FraudAlertRepository extends JpaRepository<FraudAlert, UUID> {
    
    List<FraudAlert> findByCustomerId(UUID customerId);
    
    List<FraudAlert> findByAccountId(UUID accountId);
    
    List<FraudAlert> findByStatus(AlertStatus status);
    
    List<FraudAlert> findByCustomerIdAndStatus(UUID customerId, AlertStatus status);
    
    List<FraudAlert> findByDetectedAtBetween(LocalDateTime start, LocalDateTime end);
    
    boolean existsByCustomerIdAndStatusAndDetectedAtAfter(
            UUID customerId, AlertStatus status, LocalDateTime after);
}