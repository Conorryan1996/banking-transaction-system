package com.pm.customerservice.grpc;

import com.pm.grpc.auth.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceClient {
    
    @GrpcClient("auth-service")
    private AuthServiceGrpc.AuthServiceBlockingStub authServiceStub;
    
    public boolean registerUser(String username, String password, String email, UUID customerId) {
        try {
            RegisterUserRequest request = RegisterUserRequest.newBuilder()
                    .setUsername(username)
                    .setPassword(password)
                    .setEmail(email)
                    .setCustomerId(customerId.toString())
                    .build();
            
            RegisterUserResponse response = authServiceStub.registerUser(request);
            
            if (response.getSuccess()) {
                log.info("User registered successfully with ID: {}", response.getUserId());
                return true;
            } else {
                log.error("Failed to register user: {}", response.getMessage());
                return false;
            }
        } catch (Exception e) {
            log.error("Error calling auth service to register user: {}", e.getMessage());
            return false;
        }
    }
}