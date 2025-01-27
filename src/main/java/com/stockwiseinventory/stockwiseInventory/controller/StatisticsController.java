package com.stockwiseinventory.stockwiseInventory.controller;


import com.stockwiseinventory.stockwiseInventory.model.Product;
import com.stockwiseinventory.stockwiseInventory.model.User;
import com.stockwiseinventory.stockwiseInventory.service.StatisticsService;
import com.stockwiseinventory.stockwiseInventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private UserService userService;

    @GetMapping("/total-revenue")
    public ResponseEntity<BigDecimal> getTotalRevenue() {
        BigDecimal revenue = statisticsService.getTotalRevenue();
        return ResponseEntity.ok(revenue);
    }

    @GetMapping("/total-sales")
    public ResponseEntity<Long> getTotalSales() {
        long sales = statisticsService.getTotalSales();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/best-selling-product")
    public ResponseEntity<Product> getBestSellingProduct() {
        Product bestProduct = statisticsService.getBestSellingProduct();
        return bestProduct != null ? ResponseEntity.ok(bestProduct) : ResponseEntity.noContent().build();
    }

    @GetMapping("/total-users")
    public ResponseEntity<Long> getTotalUsers() {
        long users = statisticsService.getTotalUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/top-selling-products")
    public List<Map<String, Object>> getTopSellingProducts() {
        return statisticsService.getAllTopSellingProducts();
    }

    @GetMapping("/new-users-this-month")
    public List<User> getNewUsersThisMonth() {
        return userService.getNewUsersThisMonth();
    }

    @GetMapping("/new-users-count")
    public long getNewUsersCountThisMonth() {
        return userService.getNewUsersCountThisMonth();
    }

    @GetMapping("/active-users")
    public long getActiveUsersCount() {
        return userService.getActiveUsersCount();
    }
}