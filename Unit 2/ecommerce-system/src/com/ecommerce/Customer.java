package com.ecommerce;

import com.ecommerce.carts.ShoppingCart;

import java.util.UUID;

public class Customer {
    private final String customerID;
    private String name;
    private ShoppingCart cart;

    // Constructor Declaration of Class
    public Customer(String name) {
        this.customerID = UUID.randomUUID().toString();
        this.name = name;
        this.cart = new ShoppingCart();
    }

    // Getters
    public String getCustomerID() {
        return this.customerID;
    }

    public String getName() {
        return this.name;
    }

    public ShoppingCart getCart() {
        return this.cart;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    // Other methods
    public void clearCart() {
        this.cart = new ShoppingCart();
    }

    @Override
    public String toString() {
        return "Customer{ " +
                "customer_id='" + getCustomerID() + '\'' +
                ", name='" + getName() + '\'' +
                ", cart=" + getCart() +
                " }";
    }
}
