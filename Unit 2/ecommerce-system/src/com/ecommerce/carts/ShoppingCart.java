package com.ecommerce.carts;

import com.ecommerce.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    // Create a HashMap of Product keys and Integer values
    private final Map<Product, Integer> items;

    // Constructor Declaration of Class
    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Getter
    public Map<Product, Integer> getItems() {
        return this.items;
    }

    // Add products to the shopping carts
    public void addProduct(Product product, int quantity) {
        // put() method would simply overwrite the existing quantity if the product is already in the carts.
        // merge() method adds the new quantity to the existing quantity if the product is already in the carts.
        // The first argument product is the key.
        // The second argument quantity is the value to be merged.
        // The third argument Integer::sum is a function that defines how to merge the values.
        this.items.merge(product, quantity, Integer::sum);
    }

    // Remove products from the shopping carts
    public void removeProduct(Product product) {
        this.items.remove(product);
    }

    // Clear and remove all the products
    public void clearProducts() {
        this.items.clear();
    }

    public BigDecimal getTotalPrice() {
        return this.items.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
