package com.pm.fraudservice.controller;

import com.pm.fraudservice.model.FraudAlert;
import com.pm.fraudservice.repository.FraudAlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fraud")
@RequiredArgsConstructor
public class FraudController {
    
    private final FraudAlertRepository fraudAlertRepository;
    
    @GetMapping("/alerts")
    public ResponseEntity<List<FraudAlert>> getAllAlerts() {
        return ResponseEntity.ok(fraudAlertRepository.findAll());
    }
    
    @GetMapping("/alerts/customer/{customerId}")
    public ResponseEntity<List<FraudAlert>> getCustomerAlerts(@PathVariable UUID customerId) {
        return ResponseEntity.ok(fraudAlertRepository.findByCustomerId(customerId));
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Fraud service is running");
    }
}