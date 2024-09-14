package com.ecommerce;

public class Customer {
    private final String customerID;
    private String name;

    // Constructor Declaration of Class
    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    // Getter
    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
}
