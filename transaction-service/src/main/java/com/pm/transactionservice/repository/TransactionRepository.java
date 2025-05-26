package com.pm.transactionservice.repository;

import com.pm.transactionservice.model.Transaction;
import com.pm.transactionservice.model.TransactionStatus;
import com.pm.transactionservice.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findByAccountIdOrderByProcessedDateDesc(UUID accountId);

    List<Transaction> findByCustomerIdOrderByProcessedDateDesc(UUID customerId);

    List<Transaction> findByAccountIdAndStatusOrderByProcessedDateDesc(UUID accountId, TransactionStatus status);

    List<Transaction> findByTransactionTypeOrderByProcessedDateDesc(TransactionType transactionType);

    List<Transaction> findByReferenceNumber(String referenceNumber);

    long countByAccountId(UUID accountId);

    long countByCustomerId(UUID customerId);

    long countByStatus(TransactionStatus status);
}