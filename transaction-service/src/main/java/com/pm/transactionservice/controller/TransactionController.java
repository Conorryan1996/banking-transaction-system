// transaction-service/src/main/java/com/pm/transactionservice/controller/TransactionController.java
package com.pm.transactionservice.controller;

import com.pm.transactionservice.dto.TransactionRequestDTO;
import com.pm.transactionservice.dto.TransactionResponseDTO;
import com.pm.transactionservice.service.TransactionService;
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
@RequestMapping("/transactions")
@Tag(name = "Transaction", description = "API for managing Bank Transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @Operation(summary = "Process a new transaction")
    public ResponseEntity<TransactionResponseDTO> processTransaction(@Valid @RequestBody TransactionRequestDTO request) {
        TransactionResponseDTO transaction = transactionService.processTransaction(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }

    @PostMapping("/schedule")
    @Operation(summary = "Schedule a transaction for future processing")
    public ResponseEntity<TransactionResponseDTO> scheduleTransaction(@Valid @RequestBody TransactionRequestDTO request) {
        TransactionResponseDTO transaction = transactionService.scheduleTransaction(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get transaction by ID")
    public ResponseEntity<TransactionResponseDTO> getTransaction(@PathVariable UUID id) {
        TransactionResponseDTO transaction = transactionService.getTransaction(id);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/account/{accountId}")
    @Operation(summary = "Get transactions by account ID")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionsByAccount(
            @PathVariable UUID accountId,
            @RequestParam(defaultValue = "50") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        List<TransactionResponseDTO> transactions = transactionService.getTransactionsByAccount(accountId, limit, offset);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Get transactions by customer ID")
    public ResponseEntity<List<TransactionResponseDTO>> getTransactionsByCustomer(
            @PathVariable UUID customerId,
            @RequestParam(defaultValue = "50") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        List<TransactionResponseDTO> transactions = transactionService.getTransactionsByCustomer(customerId, limit, offset);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/account/{accountId}/balance")
    @Operation(summary = "Get current account balance")
    public ResponseEntity<Map<String, String>> getAccountBalance(@PathVariable UUID accountId) {
        BigDecimal balance = transactionService.getAccountBalance(accountId);
        Map<String, String> response = Map.of(
                "accountId", accountId.toString(),
                "balance", balance.toString()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/account/{accountId}/count")
    @Operation(summary = "Get transaction count for account")
    public ResponseEntity<Map<String, Long>> getTransactionCountByAccount(@PathVariable UUID accountId) {
        long count = transactionService.getTransactionCountByAccount(accountId);
        Map<String, Long> response = Map.of("count", count);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/customer/{customerId}/count")
    @Operation(summary = "Get transaction count for customer")
    public ResponseEntity<Map<String, Long>> getTransactionCountByCustomer(@PathVariable UUID customerId) {
        long count = transactionService.getTransactionCountByCustomer(customerId);
        Map<String, Long> response = Map.of("count", count);
        return ResponseEntity.ok(response);
    }
}