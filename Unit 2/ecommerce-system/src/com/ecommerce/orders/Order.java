package com.ecommerce.orders;

import com.ecommerce.Customer;
import com.ecommerce.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Order {
    private final String orderID;
    private final Customer customer;
    private final Map<Product, Integer> products;
    private final BigDecimal orderTotal;
    private OrderStatus status;
    private final LocalDateTime orderDate;

    public enum OrderStatus {
        PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED
    }

    // Constructor Declaration of Class
    public Order(Customer customer, Map<Product, Integer> products) {
        this.orderID = UUID.randomUUID().toString();
        this.customer = customer;
        this.products = new HashMap<>(products);
        this.orderTotal = calculateTotal();
        this.status = OrderStatus.PENDING;
        this.orderDate = LocalDateTime.now();
    }

    // Getters
    public String getOrderID() {
        return this.orderID;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Map<Product, Integer> getProducts() {
        return this.products;
    }

    public BigDecimal getOrderTotal() {
        return this.orderTotal;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public String getOrderDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return this.orderDate.format(formatter);
    }

    // Setters
    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order Summary for Order ID: ").append(orderID).append("\n");
        summary.append("Customer: ").append(customer.getName()).append("\n");
        summary.append("Order Date: ").append(getOrderDate()).append("\n");
        summary.append("Status: ").append(status).append("\n");
        summary.append("Products:\n");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            summary.append("- ").append(product.getName())
                    .append(" (Quantity: ").append(quantity)
                    .append(", Price: $").append(product.getPrice())
                    .append(") Subtotal: $").append(product.getPrice().multiply(BigDecimal.valueOf(quantity)))
                    .append("\n");
        }
        summary.append("Total: $").append(orderTotal);
        return summary.toString();
    }

    private BigDecimal calculateTotal() {
        return this.products.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
