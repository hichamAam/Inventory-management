package com.example.demo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Your custom query methods can be defined here if needed
    Optional<User> findByEmail(String email);
}
