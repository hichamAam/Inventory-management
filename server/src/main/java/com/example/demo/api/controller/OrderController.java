package com.example.demo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.api.repository.OrderRepository;
import com.example.demo.api.repository.OrderDetailRepository;
import com.example.demo.api.model.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @PostMapping
    public String addOrder(){
        return "order";
    }
}
