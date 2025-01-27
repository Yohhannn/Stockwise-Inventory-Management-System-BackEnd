package com.stockwiseinventory.stockwiseInventory.service;

import com.stockwiseinventory.stockwiseInventory.model.Product;
import com.stockwiseinventory.stockwiseInventory.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public BigDecimal getTotalRevenue() {
        return orderRepository.getTotalRevenue();
    }

    @Override
    public long getTotalSales() {
        return orderRepository.getTotalSales();
    }

    @Override
    public Product getBestSellingProduct() {
        List<Object[]> result = orderRepository.getBestSellingProduct();
        if (!result.isEmpty()) {
            return (Product) result.get(0)[0];
        }
        return null;
    }

    @Override
    public long getTotalUsers() {
        return orderRepository.getTotalUsers();
    }

    @Override
    public List<Map<String, Object>> getAllTopSellingProducts() {
        List<Object[]> result = orderRepository.getAllTopSellingProducts();
        List<Map<String, Object>> products = new ArrayList<>();
        for (Object[] obj : result) {
            Map<String, Object> productInfo = new HashMap<>();
            productInfo.put("product", obj[0]);
            productInfo.put("quantitySold", obj[1]);
            products.add(productInfo);
        }
        return products;
    }
}
