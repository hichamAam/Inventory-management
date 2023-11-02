package com.example.demo.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.UserRepository;
import com.example.demo.api.model.User;

@Service
public class AuthService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public AuthService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public String authenticateUser(String email, String password){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found !"));

        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return "Your JWT Token Here";
        }else {
            throw new BadCredentialsException("Invalid password");
        }
    }
}
