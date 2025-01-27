package com.stockwiseinventory.stockwiseInventory.model;

import java.util.Optional;

public class OrderRequest {
    private int orderId;
    private String firstName;
    private String lastName;
    private String companyName;
    private String phone;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getStreetAddress() { return streetAddress; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }


    public Optional<String> getOptionalCompanyName() {
        return Optional.ofNullable(companyName);
    }

    public Optional<String> getOptionalPhone() {
        return Optional.ofNullable(phone);
    }

    public Optional<String> getOptionalState() {
        return Optional.ofNullable(state);
    }

    public Optional<String> getOptionalZipCode() {
        return Optional.ofNullable(zipCode);
    }
}
