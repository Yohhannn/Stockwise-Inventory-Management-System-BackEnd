package com.stockwiseinventory.stockwiseInventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "company_details")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_id")
    private int businessId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "business_registration_number")
    private String businessRegistrationNumber;

    @Column(name = "business_address")
    private String businessAddress;

    @Column(name = "business_phone_number")
    private String businessPhoneNumber;

    @Column(name = "business_email")
    private String businessEmail;

    @Column(name = "business_operator_name")
    private String businessOperatorName;

    @Column(name = "business_operator_contact")
    private String businessOperatorContact;

    // Getters and setters
    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessRegistrationNumber() {
        return businessRegistrationNumber;
    }

    public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
        this.businessRegistrationNumber = businessRegistrationNumber;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public void setBusinessPhoneNumber(String businessPhoneNumber) {
        this.businessPhoneNumber = businessPhoneNumber;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getBusinessOperatorName() {
        return businessOperatorName;
    }

    public void setBusinessOperatorName(String businessOperatorName) {
        this.businessOperatorName = businessOperatorName;
    }

    public String getBusinessOperatorContact() {
        return businessOperatorContact;
    }

    public void setBusinessOperatorContact(String businessOperatorContact) {
        this.businessOperatorContact = businessOperatorContact;
    }
}
