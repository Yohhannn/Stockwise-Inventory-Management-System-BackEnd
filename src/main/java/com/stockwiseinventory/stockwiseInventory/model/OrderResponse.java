package com.stockwiseinventory.stockwiseInventory.model;

import java.time.LocalDateTime;

public class OrderResponse {
    private String name;
    private String location;
    private String orderStatus;
    private LocalDateTime deliveryDate;

    public OrderResponse(Order order) {
        this.name = order.getDeliveryInfo().getFirstName() + " " + order.getDeliveryInfo().getLastName();
        this.location = order.getDeliveryInfo().getStreetAddress() + ", " +
                order.getDeliveryInfo().getCity() + ", " +
                (order.getDeliveryInfo().getState() != null ? order.getDeliveryInfo().getState() + ", " : "") +
                order.getDeliveryInfo().getZipCode();
        this.orderStatus = order.getOrderStatus();
        this.deliveryDate = order.getDeliveryDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
