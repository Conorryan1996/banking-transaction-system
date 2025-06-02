package com.pm.authservice.controller;

import com.pm.authservice.model.Role;
import com.pm.authservice.model.RoleName;
import com.pm.authservice.model.User;
import com.pm.authservice.repository.RoleRepository;
import com.pm.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/debug")
@RequiredArgsConstructor
public class DebugController {
    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    
    @GetMapping("/test-auth/{username}")
    public Map<String, Object> testAuth(@PathVariable String username, @RequestParam String password) {
        Map<String, Object> result = new HashMap<>();
        
        try {
            // Find user
            User user = userRepository.findByUsername(username).orElse(null);
            if (user == null) {
                result.put("error", "User not found");
                return result;
            }
            
            // Get stored password
            String storedPassword = user.getPassword();
            result.put("username", username);
            result.put("storedPasswordLength", storedPassword.length());
            result.put("storedPasswordStart", storedPassword.substring(0, Math.min(10, storedPassword.length())));
            
            // Test password encoding
            String newlyEncoded = passwordEncoder.encode(password);
            result.put("newlyEncodedLength", newlyEncoded.length());
            result.put("newlyEncodedStart", newlyEncoded.substring(0, 10));
            
            // Test password matching
            boolean matches = passwordEncoder.matches(password, storedPassword);
            result.put("passwordMatches", matches);
            
            // Test with a known hash
            String knownHash = "$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG"; // password: "password"
            boolean knownMatches = passwordEncoder.matches("password", knownHash);
            result.put("knownHashTest", knownMatches);
            
            // Log details
            log.info("Debug auth test for user: {}", username);
            log.info("Stored password: {}", storedPassword);
            log.info("Input password: {}", password);
            log.info("Matches: {}", matches);
            
        } catch (Exception e) {
            result.put("error", e.getMessage());
            log.error("Error in debug auth", e);
        }
        
        return result;
    }
    
    @PostMapping("/create-test-user")
    public Map<String, String> createTestUser() {
        Map<String, String> result = new HashMap<>();
        
        try {
            // Create CUSTOMER role if it doesn't exist
            Role customerRole = roleRepository.findByName(RoleName.ROLE_CUSTOMER)
                    .orElseGet(() -> {
                        Role role = Role.builder()
                                .name(RoleName.ROLE_CUSTOMER)
                                .description("Customer role")
                                .build();
                        return roleRepository.save(role);
                    });
            
            // Delete existing test user
            userRepository.findByUsername("testuser").ifPresent(userRepository::delete);
            
            // Create new user with plain text password (NoOpPasswordEncoder)
            User user = User.builder()
                    .username("testuser")
                    .email("test@test.com")
                    .password("password123")  // Plain text password for NoOpPasswordEncoder
                    .customerId(java.util.UUID.fromString("22222222-2222-2222-2222-222222222222"))
                    .enabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .roles(Set.of(customerRole))  // Assign role
                    .build();
            
            userRepository.save(user);
            
            result.put("status", "User created with role");
            result.put("username", "testuser");
            result.put("password", "password123");
            result.put("storedPassword", user.getPassword());
            result.put("rolesCount", String.valueOf(user.getRoles().size()));
            
        } catch (Exception e) {
            result.put("error", e.getMessage());
            log.error("Error creating test user", e);
        }
        
        return result;
    }
}