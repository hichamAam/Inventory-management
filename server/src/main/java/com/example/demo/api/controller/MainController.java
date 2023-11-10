package com.example.demo.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
public class MainController {
    @GetMapping("/")
    public ResponseEntity<Boolean> state(){
        return ResponseEntity.ok(true);
    }
}
