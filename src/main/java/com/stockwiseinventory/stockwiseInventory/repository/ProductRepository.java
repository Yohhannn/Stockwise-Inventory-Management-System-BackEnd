package com.stockwiseinventory.stockwiseInventory.repository;

import com.stockwiseinventory.stockwiseInventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Search by name (partial or exact match)
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> findByNameContaining(@Param("name") String name);

    // Find products by category
    @Query("SELECT p FROM Product p WHERE LOWER(REPLACE(p.category, ' ', '')) LIKE LOWER(CONCAT('%', :category, '%'))")
    List<Product> findByCategoryContainsIgnoreCase(@Param("category") String category);

}
