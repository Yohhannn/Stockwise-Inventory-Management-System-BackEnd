package com.stockwiseinventory.stockwiseInventory.repository;

import com.stockwiseinventory.stockwiseInventory.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserId(int userId);

}
