package com.pm.fraudservice.repository;

import com.pm.fraudservice.model.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, UUID> {
    
    List<TransactionHistory> findByCustomerId(UUID customerId);
    
    List<TransactionHistory> findByAccountId(UUID accountId);
    
    @Query("SELECT th FROM TransactionHistory th WHERE th.customerId = :customerId " +
           "AND th.timestamp >= :startTime AND th.timestamp <= :endTime " +
           "ORDER BY th.timestamp DESC")
    List<TransactionHistory> findByCustomerIdAndTimestampBetween(
            @Param("customerId") UUID customerId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);
    
    @Query("SELECT COUNT(th) FROM TransactionHistory th WHERE th.customerId = :customerId " +
           "AND th.transactionType = :transactionType " +
           "AND th.timestamp >= :startTime")
    long countByCustomerIdAndTransactionTypeAndTimestampAfter(
            @Param("customerId") UUID customerId,
            @Param("transactionType") String transactionType,
            @Param("startTime") LocalDateTime startTime);
    
    @Query("SELECT COALESCE(SUM(th.amount), 0) FROM TransactionHistory th " +
           "WHERE th.customerId = :customerId " +
           "AND th.transactionType = :transactionType " +
           "AND th.timestamp >= :startTime")
    BigDecimal sumAmountByCustomerIdAndTransactionTypeAndTimestampAfter(
            @Param("customerId") UUID customerId,
            @Param("transactionType") String transactionType,
            @Param("startTime") LocalDateTime startTime);
}