package com.stockwiseinventory.stockwiseInventory.service;

import com.stockwiseinventory.stockwiseInventory.model.OrderResponse;

import java.util.List;

public interface OrderService {

    void checkout(int userId, List<Integer> cartItemIds);

    void finalizeOrder(int orderId, String firstName, String lastName, String companyName, String phone,
                              String streetAddress, String city, String state, String zipCode);

    void updateOrderDeliveryStatus();

    OrderResponse getOrderById(int orderId);


}
