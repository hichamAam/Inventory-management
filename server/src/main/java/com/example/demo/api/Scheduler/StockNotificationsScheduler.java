package com.example.demo.api.Scheduler;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StockNotificationsScheduler {
    @Autowired
    private ProductService productService;
      //@Scheduled(fixedRate = 60000) verify all the minutes (60000 ms)
    @Scheduled(cron = "0 * * * * *") // verify in each minutes
    public void checkStockLevels() {
        productService.checkStockLevelsAndNotify();
    }
}
