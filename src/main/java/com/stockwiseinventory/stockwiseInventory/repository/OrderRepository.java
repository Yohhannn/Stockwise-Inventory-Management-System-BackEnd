package com.stockwiseinventory.stockwiseInventory.repository;

import com.stockwiseinventory.stockwiseInventory.model.Order;
import com.stockwiseinventory.stockwiseInventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByOrderStatusAndDeliveryDateBefore(String orderStatus, LocalDateTime deliveryDate);

    // Query for total revenue (sum of all prices in orders)
    @Query("SELECT SUM(o.totalPrice) FROM Order o")
    BigDecimal getTotalRevenue();

    // Query for total number of sales (number of orders)
    @Query("SELECT COUNT(o) FROM Order o")
    long getTotalSales();

    // Query for the best-selling product (the one with most quantity sold)
    @Query("SELECT oi.product, SUM(oi.quantity) FROM OrderItem oi " +
            "GROUP BY oi.product ORDER BY SUM(oi.quantity) DESC")
    List<Object[]> getBestSellingProduct();

    // Query for total number of users (number of distinct users)
    @Query("SELECT COUNT(u) FROM User u")
    long getTotalUsers();

    // Query to get all products along with their total quantity sold, ordered by descending quantity
    @Query("SELECT oi.product, SUM(oi.quantity) as totalQuantity FROM OrderItem oi " +
            "GROUP BY oi.product ORDER BY totalQuantity DESC")
    List<Object[]> getAllTopSellingProducts();

}
