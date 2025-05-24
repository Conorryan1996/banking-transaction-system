package com.pm.accountservice.controller;

import com.pm.accountservice.dto.AccountRequestDTO;
import com.pm.accountservice.dto.AccountResponseDTO;
import com.pm.accountservice.model.AccountStatus;
import com.pm.accountservice.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Account", description = "API for managing Bank Accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    @Operation(summary = "Get all accounts")
    public ResponseEntity<List<AccountResponseDTO>> getAccounts() {
        List<AccountResponseDTO> accounts = accountService.getAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get account by ID")
    public ResponseEntity<AccountResponseDTO> getAccount(@PathVariable UUID id) {
        AccountResponseDTO account = accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Get accounts by customer ID")
    public ResponseEntity<List<AccountResponseDTO>> getAccountsByCustomer(@PathVariable UUID customerId) {
        List<AccountResponseDTO> accounts = accountService.getAccountsByCustomer(customerId);
        return ResponseEntity.ok(accounts);
    }

    @PostMapping
    @Operation(summary = "Create new account")
    public ResponseEntity<AccountResponseDTO> createAccount(@Valid @RequestBody AccountRequestDTO request) {
        AccountResponseDTO account = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update account status")
    public ResponseEntity<AccountResponseDTO> updateAccountStatus(
            @PathVariable UUID id,
            @RequestParam AccountStatus status) {
        AccountResponseDTO account = accountService.updateAccountStatus(id, status);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{id}/balance")
    @Operation(summary = "Get account balance")
    public ResponseEntity<Map<String, String>> getBalance(@PathVariable UUID id) {
        BigDecimal balance = accountService.getBalance(id);
        Map<String, String> response = Map.of(
                "accountId", id.toString(),
                "balance", balance.toString()
        );
        return ResponseEntity.ok(response);
    }
}