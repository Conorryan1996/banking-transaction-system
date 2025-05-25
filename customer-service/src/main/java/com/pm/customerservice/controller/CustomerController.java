package com.pm.customerservice.controller;

import com.pm.customerservice.dto.CustomerRequestDTO;
import com.pm.customerservice.dto.CustomerResponseDTO;
import com.pm.customerservice.model.CustomerStatus;
import com.pm.customerservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer", description = "API for managing Bank Customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
    @Operation(summary = "Create new customer")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO request) {
        CustomerResponseDTO customer = customerService.createCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
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
}

