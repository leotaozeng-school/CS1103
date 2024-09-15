package com.ecommerce;

import com.ecommerce.cart.ShoppingCart;

public class Customer {
    private final String customerID;
    private String name;
    private ShoppingCart cart;

    // Constructor Declaration of Class
    public Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.cart = new ShoppingCart();
    }

    // Getter
    public String getCustomerID() {
        return this.customerID;
    }

    public String getName() {
        return this.name;
    }

    public ShoppingCart getCart() {
        return this.cart;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Other methods
    public void clearCart() {
        this.cart = new ShoppingCart();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", name='" + name + '\'' +
                ", cart=" + cart +
                '}';
    }
}
