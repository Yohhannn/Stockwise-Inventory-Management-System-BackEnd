package com.stockwiseinventory.stockwiseInventory.service;

import com.stockwiseinventory.stockwiseInventory.model.Cart;
import com.stockwiseinventory.stockwiseInventory.model.Product;
import com.stockwiseinventory.stockwiseInventory.model.User;
import com.stockwiseinventory.stockwiseInventory.repository.CartRepository;
import com.stockwiseinventory.stockwiseInventory.repository.ProductRepository;
import com.stockwiseinventory.stockwiseInventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    // Add product to cart
    @Override
    public void addToCart(int userId, int productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cartItem = new Cart();

        cartItem.setUser(user);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        BigDecimal totalPrice = product.getPrice().multiply(new BigDecimal(quantity));
        cartItem.setPrice(totalPrice);

        cartRepository.save(cartItem);
    }





    // Retrieve cart items for a specific user
    @Override
    public List<Cart> getCartItems(int userId) {
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        cartItems.forEach(cart -> {
            Product product = cart.getProduct();
            if (product != null) {
                cart.setPrice(product.getPrice().multiply(new BigDecimal(cart.getQuantity())));
            }
        });
        return cartItems;
    }

    @Override
    public Cart updateQuantity(int cartId, int newQuantity) {
        Cart cartItem = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));

        Product product = cartItem.getProduct();
        if (product == null) {
            throw new RuntimeException("Product not associated with cart item");
        }

        BigDecimal newPrice = product.getPrice().multiply(new BigDecimal(newQuantity));
        cartItem.setQuantity(newQuantity);
        cartItem.setPrice(newPrice);

        return cartRepository.save(cartItem);
    }


    // Delete a cart item
    @Override
    public void deleteCartItem(int cartId) {
        Cart cartItem = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartRepository.delete(cartItem);
    }

    // Get cart item by id
    @Override
    public Optional<Cart> getCartById(int id) {
        return cartRepository.findById(id);
    }

    // Remove product from cart
    @Override
    public void removeFromCart(int id) {
        cartRepository.deleteById(id);
    }
}
