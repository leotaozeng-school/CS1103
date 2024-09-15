package com.ecommerce.cart;

import com.ecommerce.Product;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    // Create a HashMap of Product keys and Integer values
    private Map<Product, Integer> items;

    // Constructor Declaration of Class
    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Getter
    public Map<Product, Integer> getItems() {
        return this.items;
    }

    // Other methods
    public void addProduct(Product product, int quantity) {
        this.items.put(product, quantity);
    }

    public void removeProduct(Product product) {
        // Remove an element from the HashMap
        this.items.remove(product);
    }

    public void updateQuantity(Product product, int newQuantity) {
        if (newQuantity <= 0) {
            removeProduct(product);
        } else {
            this.items.put(product, newQuantity);
        }
    }

    public Integer getTotalPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
