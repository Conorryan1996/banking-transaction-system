package com.pm.customerservice.controller;

import com.pm.customerservice.dto.CustomerRequestDTO;
import com.pm.customerservice.dto.CustomerResponseDTO;
import com.pm.customerservice.model.CustomerStatus;
import com.pm.customerservice.service.CustomerService;
import com.pm.customerservice.grpc.AccountServiceClient;
import com.pm.grpc.account.GetAccountsByCustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer", description = "API for managing Bank Customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final AccountServiceClient accountServiceClient;

    public CustomerController(CustomerService customerService, AccountServiceClient accountServiceClient) {
        this.customerService = customerService;
        this.accountServiceClient = accountServiceClient;
    }

    @GetMapping
    @Operation(summary = "Get all customers")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        List<CustomerResponseDTO> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get customer by ID")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable UUID id) {
        CustomerResponseDTO customer = customerService.getCustomer(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get customer by email")
    public ResponseEntity<CustomerResponseDTO> getCustomerByEmail(@PathVariable String email) {
        CustomerResponseDTO customer = customerService.getCustomerByEmail(email);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/search")
    @Operation(summary = "Search customers by name")
    public ResponseEntity<List<CustomerResponseDTO>> searchCustomers(@RequestParam String query) {
        List<CustomerResponseDTO> customers = customerService.searchCustomers(query);
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    @Operation(summary = "Create new customer with default account")
    public ResponseEntity<Map<String, Object>> createCustomer(@Valid @RequestBody CustomerRequestDTO request) {
        CustomerResponseDTO customer = customerService.createCustomer(request);

        // Get the customer's accounts to show the created account
        List<Map<String, String>> accounts = new ArrayList<>();
        try {
            // Use gRPC to get accounts for this customer
            GetAccountsByCustomerResponse accountsResponse = accountServiceClient.getAccountsByCustomer(customer.getId());
            if (accountsResponse.getServiceResponse().getSuccess()) {
                accounts = accountsResponse.getAccountsList().stream()
                        .map(grpcAccount -> {
                            Map<String, String> accountMap = new HashMap<>();
                            accountMap.put("id", grpcAccount.getAccountId());
                            accountMap.put("accountNumber", grpcAccount.getAccountNumber());
                            accountMap.put("customerId", grpcAccount.getCustomerId());
                            accountMap.put("accountType", grpcAccount.getAccountType().name().replace("ACCOUNT_TYPE_", ""));
                            accountMap.put("balance", grpcAccount.getBalance());
                            accountMap.put("status", grpcAccount.getStatus().name().replace("ACCOUNT_STATUS_", ""));
                            accountMap.put("createdDate", grpcAccount.getCreatedDate());
                            return accountMap;
                        })
                        .toList();
            }
        } catch (Exception e) {
            logger.warn("Could not retrieve accounts for customer {}: {}", customer.getId(), e.getMessage());
        }

        Map<String, Object> response = new HashMap<>();
        response.put("customer", customer);
        response.put("accounts", accounts);
        response.put("message", "Customer created successfully with default account");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update customer")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable UUID id,
            @Valid @RequestBody CustomerRequestDTO request) {
        CustomerResponseDTO customer = customerService.updateCustomer(id, request);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update customer status")
    public ResponseEntity<CustomerResponseDTO> updateCustomerStatus(
            @PathVariable UUID id,
            @RequestParam CustomerStatus status) {
        CustomerResponseDTO customer = customerService.updateCustomerStatus(id, status);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{id}/exists")
    @Operation(summary = "Check if customer exists")
    public ResponseEntity<Boolean> customerExists(@PathVariable UUID id) {
        boolean exists = customerService.customerExists(id);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/{id}/accounts")
    @Operation(summary = "Get all accounts for a customer")
    public ResponseEntity<List<Map<String, String>>> getCustomerAccounts(@PathVariable UUID id) {
        try {
            GetAccountsByCustomerResponse accountsResponse = accountServiceClient.getAccountsByCustomer(id.toString());

            if (accountsResponse.getServiceResponse().getSuccess()) {
                List<Map<String, String>> accounts = accountsResponse.getAccountsList().stream()
                        .map(grpcAccount -> {
                            Map<String, String> accountMap = new HashMap<>();
                            accountMap.put("id", grpcAccount.getAccountId());
                            accountMap.put("accountNumber", grpcAccount.getAccountNumber());
                            accountMap.put("customerId", grpcAccount.getCustomerId());
                            accountMap.put("accountType", grpcAccount.getAccountType().name().replace("ACCOUNT_TYPE_", ""));
                            accountMap.put("balance", grpcAccount.getBalance());
                            accountMap.put("status", grpcAccount.getStatus().name().replace("ACCOUNT_STATUS_", ""));
                            accountMap.put("createdDate", grpcAccount.getCreatedDate());
                            return accountMap;
                        })
                        .toList();
                return ResponseEntity.ok(accounts);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            logger.error("Error getting accounts for customer {}: {}", id, e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}