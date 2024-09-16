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

    // Add products to the shopping cart
    public void addProduct(Product product, int quantity) {
        // put() method would simply overwrite the existing quantity if the product is already in the cart.
        // merge() method adds the new quantity to the existing quantity if the product is already in the cart.
        // The first argument product is the key.
        // The second argument quantity is the value to be merged.
        // The third argument Integer::sum is a function that defines how to merge the values.
        this.items.merge(product, quantity, Integer::sum);
    }

    // Remove products from the shopping cart
    public void removeProduct(Product product) {
        this.items.remove(product);
    }

    // Clear and remove all the products
    public void clearProducts() {
        this.items.clear();
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
