package com.stockwiseinventory.stockwiseInventory.service;

import com.stockwiseinventory.stockwiseInventory.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface StatisticsService {

    BigDecimal getTotalRevenue();

    long getTotalSales();

    Product getBestSellingProduct();

    long getTotalUsers();

    List<Map<String, Object>> getAllTopSellingProducts();
}
