package com.example.demo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AuthRequest;
import com.example.demo.service.AuthService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api")
public class AuthController {
    private AuthService authService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(AuthService authService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authService = authService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest){
        String email = authRequest.getEmail();
        String password = authRequest.getPassword();
        return authService.authenticateUser(email, password);
    }
}
