package com.stockwiseinventory.stockwiseInventory.controller;

import com.stockwiseinventory.stockwiseInventory.model.OrderRequest;
import com.stockwiseinventory.stockwiseInventory.model.OrderResponse;
import com.stockwiseinventory.stockwiseInventory.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Endpoint to finalize the order
    @PostMapping("/finalize")
    public ResponseEntity<String> finalizeOrder(@RequestBody OrderRequest request) {
        String companyName = Optional.ofNullable(request.getCompanyName()).orElse("N/A");
        String phone = Optional.ofNullable(request.getPhone()).orElse("N/A");

        String state = request.getOptionalState().orElse("N/A");
        String zipCode = request.getOptionalZipCode().orElse("N/A");

        orderService.finalizeOrder(
                request.getOrderId(),
                request.getFirstName(),
                request.getLastName(),
                companyName,
                phone,
                request.getStreetAddress(),
                request.getCity(),
                state,
                zipCode
        );

        return ResponseEntity.ok("Order finalized successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable int id) {
        OrderResponse response = orderService.getOrderById(id);
        return ResponseEntity.ok(response);
    }

}
