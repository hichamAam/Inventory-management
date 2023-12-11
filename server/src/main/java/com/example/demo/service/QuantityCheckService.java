package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.api.model.Product;
import com.example.demo.api.repository.ProductRepository;

import java.util.List;

@Service
public class QuantityCheckService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public QuantityCheckService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRate = 10000) // Run every 10 seconds
    public void checkProductQuantity() {
        List<Product> products = productRepository.findAll();

        for (Product product : products) {
            if (product.getStock_qte() <= 3) {
                System.out.println("send notify for this : " + product.getName());
                sendNotificationToNodeJS(product);
            }
        }
    }

    private void sendNotificationToNodeJS(Product product) {
        // Assuming your Node.js server endpoint for notifications
        String nodeJsUrl = "http://localhost:9091/notify";
        System.out.println("send request for this : " + product.getName());
        restTemplate.postForObject(nodeJsUrl, product, Void.class);
    }
}

