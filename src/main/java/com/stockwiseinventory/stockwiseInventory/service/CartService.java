package com.stockwiseinventory.stockwiseInventory.service;

import com.stockwiseinventory.stockwiseInventory.model.Cart;
import com.stockwiseinventory.stockwiseInventory.model.Product;

import java.util.List;
import java.util.Optional;

public interface CartService {
    void addToCart(int userId, int productId, int quantity);
    List<Cart> getCartItems(int userId);
    void deleteCartItem(int cartId);
    Optional<Cart> getCartById(int id);
    void removeFromCart(int id);
    Cart updateQuantity(int cartId, int newQuantity);
}

