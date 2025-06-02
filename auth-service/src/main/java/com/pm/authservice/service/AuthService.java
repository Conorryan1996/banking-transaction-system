package com.pm.authservice.service;

import com.pm.authservice.dto.JwtAuthenticationResponse;
import com.pm.authservice.dto.LoginRequest;
import com.pm.authservice.dto.RegisterUserRequest;
import com.pm.authservice.exception.EmailAlreadyExistsException;
import com.pm.authservice.exception.UserAlreadyExistsException;
import com.pm.authservice.model.Role;
import com.pm.authservice.model.RoleName;
import com.pm.authservice.model.User;
import com.pm.authservice.repository.RoleRepository;
import com.pm.authservice.repository.UserRepository;
import com.pm.authservice.security.CustomUserDetails;
import com.pm.authservice.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider tokenProvider;
    
    @Value("${jwt.expiration}")
    private int jwtExpirationInMs;
    
    @Transactional
    public JwtAuthenticationResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String accessToken = tokenProvider.generateToken(authentication);
        String refreshToken = tokenProvider.generateRefreshToken(authentication);
        
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        
        // Update last login time
        userRepository.findById(userDetails.getId()).ifPresent(user -> {
            user.setLastLoginAt(LocalDateTime.now());
            userRepository.save(user);
        });
        
        return JwtAuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .expiresIn((long) jwtExpirationInMs)
                .userId(userDetails.getId())
                .customerId(userDetails.getCustomerId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .build();
    }
    
    @Transactional
    public User registerUser(RegisterUserRequest registerRequest) {
        // Check if username already exists
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            throw new UserAlreadyExistsException("Username is already taken!");
        }
        
        // Check if email already exists
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email is already in use!");
        }
        
        // Check if customer already has an account
        if (userRepository.existsByCustomerId(registerRequest.getCustomerId())) {
            throw new UserAlreadyExistsException("Customer already has an account!");
        }
        
        // Create new user
        User user = User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .customerId(registerRequest.getCustomerId())
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
        
        // Assign customer role
        Role customerRole = roleRepository.findByName(RoleName.ROLE_CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Customer Role not found."));
        
        user.setRoles(Collections.singleton(customerRole));
        
        User savedUser = userRepository.save(user);
        log.info("User registered successfully with username: {}", savedUser.getUsername());
        
        return savedUser;
    }
    
    public boolean validateToken(String token) {
        return tokenProvider.validateToken(token);
    }
    
    public UUID getUserIdFromToken(String token) {
        return UUID.fromString(tokenProvider.getUserIdFromToken(token));
    }
    
    public UUID getCustomerIdFromToken(String token) {
        return UUID.fromString(tokenProvider.getCustomerIdFromToken(token));
    }
}