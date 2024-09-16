package com.ecommerce.carts;

import com.ecommerce.Product;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class ShoppingCart {
    // Create a HashMap of Product keys and Integer values
    private final Map<Product, Integer> items;
    private static final int MAX_QUANTITY_PER_PRODUCT = 10;

    // Constructor Declaration of Class
    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Getters
    public Map<Product, Integer> getItems() {
        return this.items;
    }

    // Add products to the shopping carts
    public void addProduct(Product product, int quantity) {
        // Create a Logger
        Logger logger = Logger.getLogger(ShoppingCart.class.getName());

        // Set Logger level()
        logger.setLevel(Level.WARNING);

        int currentQuantity = items.getOrDefault(product, 0);
        int newQuantity = Math.min(currentQuantity + quantity, MAX_QUANTITY_PER_PRODUCT);
        this.items.put(product, newQuantity);

        if (newQuantity == MAX_QUANTITY_PER_PRODUCT) {
            // Call warning method
            logger.warning("Maximum quantity reached for " + product.getName() + ". Limited to " + MAX_QUANTITY_PER_PRODUCT);
        }
        // put() method would simply overwrite the existing quantity if the product is already in the carts.
        // merge() method adds the new quantity to the existing quantity if the product is already in the carts.
    }

    // Remove a specific number of units of the specified product from the shopping carts
    public void removeProduct(Product product, int quantity) {
        if (this.items.containsKey(product)) {
            int currentQuantity = items.get(product);
            if (quantity < currentQuantity) {
                this.items.put(product, currentQuantity - quantity);
                System.out.println("Removed " + quantity + " " + product.getName().toLowerCase() + "(s) from the cart");
            } else {
                removeProducts(product);
            }
        } else {
            System.out.println("Did not find " + product.getName().toLowerCase() + "(s) in the cart");
        }
    }

    // Remove all units of the specified product from the shopping carts
    public void removeProducts(Product product) {
        if (this.items.remove(product) != null) {
            System.out.println("Removed all " + product.getName().toLowerCase() + " from the cart");
        } else {
            System.out.println("Did not find " + product.getName().toLowerCase() + "(s) in the cart");
        }
    }

    // Clear and remove all the products
    public void clear() {
        this.items.clear();
    }

    public BigDecimal getTotalPrice() {
        return this.items.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
