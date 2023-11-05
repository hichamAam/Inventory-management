package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.example.demo.api.model.User;
import com.example.demo.api.repository.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean authenticate(String email, String password){
        Optional<User> AuthUser = userRepository.findByEmail(email);

        if (AuthUser != null) {
            User user = AuthUser.get();
            // Compare the provided raw password with the hashed password in the database
            return passwordEncoder.matches(password, user.GetPassword());
        }

        return false; // User not found or password doesn't match
    }
}
