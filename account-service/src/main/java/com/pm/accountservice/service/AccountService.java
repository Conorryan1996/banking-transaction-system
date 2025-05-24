package com.pm.accountservice.service;

import com.pm.accountservice.dto.AccountRequestDTO;
import com.pm.accountservice.dto.AccountResponseDTO;
import com.pm.accountservice.exception.AccountNotFoundException;
import com.pm.accountservice.mapper.AccountMapper;
import com.pm.accountservice.model.Account;
import com.pm.accountservice.model.AccountStatus;
import com.pm.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountResponseDTO> getAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(AccountMapper::toDTO)
                .toList();
    }

    public AccountResponseDTO getAccount(UUID id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " + id));
        return AccountMapper.toDTO(account);
    }

    public List<AccountResponseDTO> getAccountsByCustomer(UUID customerId) {
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        return accounts.stream()
                .map(AccountMapper::toDTO)
                .toList();
    }

    public AccountResponseDTO createAccount(AccountRequestDTO request) {
        Account account = new Account();
        account.setCustomerId(request.getCustomerId());
        account.setAccountType(request.getAccountType());
        account.setBalance(request.getInitialDeposit());
        account.setAccountNumber(generateAccountNumber());
        account.setStatus(AccountStatus.ACTIVE);
        account.setCreatedDate(LocalDateTime.now());

        Account savedAccount = accountRepository.save(account);
        return AccountMapper.toDTO(savedAccount);
    }

    public AccountResponseDTO updateAccountStatus(UUID id, AccountStatus status) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " + id));

        account.setStatus(status);
        account.setLastModifiedDate(LocalDateTime.now());

        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.toDTO(updatedAccount);
    }

    public BigDecimal getBalance(UUID id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " + id));
        return account.getBalance();
    }

    private String generateAccountNumber() {
        String accountNumber;
        do {
            accountNumber = "ACC" + System.currentTimeMillis();
        } while (accountRepository.existsByAccountNumber(accountNumber));

        return accountNumber;
    }
}