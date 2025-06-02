package com.pm.authservice.grpc;

import com.pm.authservice.model.User;
import com.pm.authservice.repository.UserRepository;
import com.pm.authservice.service.AuthService;
import com.pm.grpc.auth.*;
import com.pm.grpc.common.ServiceResponse;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class AuthGrpcService extends AuthServiceGrpc.AuthServiceImplBase {
    
    private final AuthService authService;
    private final UserRepository userRepository;
    
    @Override
    @Transactional
    public void registerUser(com.pm.grpc.auth.RegisterUserRequest request, StreamObserver<RegisterUserResponse> responseObserver) {
        try {
            log.info("gRPC: Registering user with username: {}", request.getUsername());
            
            com.pm.authservice.dto.RegisterUserRequest registerRequest = com.pm.authservice.dto.RegisterUserRequest.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .email(request.getEmail())
                    .customerId(UUID.fromString(request.getCustomerId()))
                    .build();
            
            User user = authService.registerUser(registerRequest);
            
            RegisterUserResponse response = RegisterUserResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("User registered successfully")
                    .setUserId(user.getId().toString())
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(true)
                            .setMessage("User registration completed")
                            .build())
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            log.error("Error registering user: {}", e.getMessage());
            
            RegisterUserResponse response = RegisterUserResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage(e.getMessage())
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Failed to register user: " + e.getMessage())
                            .build())
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    
    @Override
    public void validateToken(ValidateTokenRequest request, StreamObserver<ValidateTokenResponse> responseObserver) {
        try {
            boolean isValid = authService.validateToken(request.getToken());
            
            ValidateTokenResponse.Builder responseBuilder = ValidateTokenResponse.newBuilder()
                    .setIsValid(isValid);
            
            if (isValid) {
                UUID userId = authService.getUserIdFromToken(request.getToken());
                UUID customerId = authService.getCustomerIdFromToken(request.getToken());
                
                userRepository.findById(userId).ifPresent(user -> {
                    responseBuilder
                            .setUserId(user.getId().toString())
                            .setCustomerId(user.getCustomerId().toString())
                            .setUsername(user.getUsername());
                });
            }
            
            responseBuilder.setServiceResponse(ServiceResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage(isValid ? "Token is valid" : "Token is invalid")
                    .build());
            
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
            
        } catch (Exception e) {
            log.error("Error validating token: {}", e.getMessage());
            
            ValidateTokenResponse response = ValidateTokenResponse.newBuilder()
                    .setIsValid(false)
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Error validating token: " + e.getMessage())
                            .build())
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    
    @Override
    @Transactional(readOnly = true)
    public void getUserInfo(GetUserInfoRequest request, StreamObserver<GetUserInfoResponse> responseObserver) {
        try {
            UUID userId = UUID.fromString(request.getUserId());
            
            userRepository.findById(userId).ifPresentOrElse(user -> {
                GetUserInfoResponse response = GetUserInfoResponse.newBuilder()
                        .setUserId(user.getId().toString())
                        .setUsername(user.getUsername())
                        .setEmail(user.getEmail())
                        .setCustomerId(user.getCustomerId().toString())
                        .addAllRoles(user.getRoles().stream()
                                .map(role -> role.getName().name())
                                .collect(Collectors.toList()))
                        .setServiceResponse(ServiceResponse.newBuilder()
                                .setSuccess(true)
                                .setMessage("User info retrieved successfully")
                                .build())
                        .build();
                
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                
            }, () -> {
                GetUserInfoResponse response = GetUserInfoResponse.newBuilder()
                        .setServiceResponse(ServiceResponse.newBuilder()
                                .setSuccess(false)
                                .setMessage("User not found")
                                .build())
                        .build();
                
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            });
            
        } catch (Exception e) {
            log.error("Error getting user info: {}", e.getMessage());
            
            GetUserInfoResponse response = GetUserInfoResponse.newBuilder()
                    .setServiceResponse(ServiceResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Error getting user info: " + e.getMessage())
                            .build())
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}