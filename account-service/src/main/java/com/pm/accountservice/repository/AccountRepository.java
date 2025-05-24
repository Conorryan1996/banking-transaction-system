package com.pm.accountservice.repository;

import com.pm.accountservice.model.Account;
import com.pm.accountservice.model.AccountStatus;
import com.pm.accountservice.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    List<Account> findByCustomerId(UUID customerId);
    List<Account> findByAccountType(AccountType accountType);
    List<Account> findByStatus(AccountStatus status);
    Optional<Account> findByAccountNumber(String accountNumber);
    boolean existsByAccountNumber(String accountNumber);
}
