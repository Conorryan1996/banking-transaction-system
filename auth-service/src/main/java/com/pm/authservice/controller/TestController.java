package com.pm.authservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    
    private final PasswordEncoder passwordEncoder;
    
    @PostMapping("/encode")
    public String encodePassword(@RequestParam String password) {
        return passwordEncoder.encode(password);
    }
    
    @PostMapping("/verify")
    public boolean verifyPassword(@RequestParam String raw, @RequestParam String encoded) {
        return passwordEncoder.matches(raw, encoded);
    }
}