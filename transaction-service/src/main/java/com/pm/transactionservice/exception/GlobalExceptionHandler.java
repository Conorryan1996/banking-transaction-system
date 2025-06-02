package com.pm.transactionservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleTransactionNotFoundException(TransactionNotFoundException ex) {
        log.warn("Transaction not found: " + ex.getMessage());
        Map<String, String> error = Map.of("message", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<Map<String, String>> handleInsufficientFundsException(InsufficientFundsException ex) {
        log.warn("Insufficient funds: " + ex.getMessage());
        Map<String, String> error = Map.of("message", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
    
    @ExceptionHandler(FraudDetectedException.class)
    public ResponseEntity<Map<String, String>> handleFraudDetectedException(FraudDetectedException ex) {
        log.warn("Fraud detected: " + ex.getMessage());
        Map<String, String> error = Map.of(
            "message", ex.getMessage(),
            "error", "FRAUD_DETECTED"
        );
        return ResponseEntity.status(403).body(error); // 403 Forbidden
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        log.error("Runtime error: " + ex.getMessage());
        Map<String, String> error = Map.of("message", "Transaction failed: " + ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}