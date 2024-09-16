package com.ecommerce.orders;

import com.ecommerce.Customer;

import java.util.UUID;

public class Order {
    private String orderID;
    private Customer customer;

    // Constructor Declaration of Class
    public Order(Customer customer) {
        this.orderID = UUID.randomUUID().toString();
        this.customer = customer;
    }

    // Getter
}
