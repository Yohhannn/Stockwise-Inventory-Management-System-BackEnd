package com.stockwiseinventory.stockwiseInventory.controller;

import com.stockwiseinventory.stockwiseInventory.model.Cart;
import com.stockwiseinventory.stockwiseInventory.model.CartRequest;
import com.stockwiseinventory.stockwiseInventory.service.CartService;
import com.stockwiseinventory.stockwiseInventory.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    // Add a product to the user's cart
    @PostMapping
    public ResponseEntity<Void> addToCart(@RequestBody CartRequest cartRequest) {
        cartService.addToCart(cartRequest.getUserId(), cartRequest.getProductId(), cartRequest.getQuantity());
        return ResponseEntity.ok().build();
    }


    // Get all cart items for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getAllCartItems(@PathVariable int userId) {
        List<Cart> cartItems = cartService.getCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }

    // Update the quantity of an existing cart item
    @PutMapping("/{cartId}")
    public ResponseEntity<Cart> updateCartQuantity(
            @PathVariable int cartId,
            @RequestBody Map<String, Integer> requestBody) {

        int quantity = requestBody.get("quantity"); // Assuming body has a "quantity" field

        Cart updatedCart = cartService.updateQuantity(cartId, quantity);

        return ResponseEntity.ok(updatedCart);
    }

    // Get a specific cart item by cartId
    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartItemById(@PathVariable int cartId) {
        return cartService.getCartById(cartId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Remove a product from the cart by cartId
    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable int cartId) {
        cartService.removeFromCart(cartId);
        return ResponseEntity.noContent().build();
    }

    //checkout function in the Cart Controller
    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestParam int userId, @RequestBody List<Integer> cartItemIds) {
        orderService.checkout(userId, cartItemIds);
        return ResponseEntity.ok("Order placed successfully");
    }
}
