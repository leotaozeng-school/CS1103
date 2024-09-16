package com.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String productID; // private = restricted access
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;

    // Constructor Declaration of Class
    public Product(String name, String description, BigDecimal price, int stockQuantity) {
        // The UUID.randomUUID().toString() method can generate unique identifiers for any class that needs a unique ID
        this.productID = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getter
    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Other methods
    public void increaseStock(int quantity) {
        this.stockQuantity+= quantity;
    }

    public void decreaseStock(int quantity) {
        if (quantity > this.stockQuantity) {
            throw new IllegalArgumentException("Quantity exceeds stock limit");
        }
        this.stockQuantity -= quantity;
    }

    @Override
    public String toString() {
        return "Product{ " +
                "product_id='" + productID + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock_quantity=" + stockQuantity +
                " }";
    }
}
