package com.pm.authservice.security;

import com.pm.authservice.model.User;
import com.pm.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Loading user by username: {}", username);
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    log.warn("User not found with username: {}", username);
                    return new UsernameNotFoundException("User not found with username: " + username);
                });
        
        log.debug("Found user: {} with password length: {} and {} roles", 
                user.getUsername(), 
                user.getPassword() != null ? user.getPassword().length() : "null",
                user.getRoles() != null ? user.getRoles().size() : "null");
        
        CustomUserDetails userDetails = new CustomUserDetails(user);
        log.debug("Created UserDetails for user: {} with {} authorities", 
                userDetails.getUsername(), 
                userDetails.getAuthorities().size());
        
        return userDetails;
    }
}