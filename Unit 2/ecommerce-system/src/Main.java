import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.carts.ShoppingCart;
import com.ecommerce.orders.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            // Create four products (laptop, smartphone, headphone, mouse)
            Product laptop = new Product("Laptop", "Apple 2024 MacBook Air 13-inch Laptop", new BigDecimal("1099.00"), 20);
            Product smartphone = new Product("Smartphone", "Apple iPhone SE 64GB (PRODUCT)RED", new BigDecimal("429.00"), 20);
            Product headphones = new Product("Headphones", "Bose QuietComfort Ultra Headphones", new BigDecimal("349.00"), 30);
            Product mouse = new Product("Mouse", "MX Master 3S Wireless Performance Mouse | Logitech", new BigDecimal("99.99"), 30);

            // Create a fixed-size List containing the specified elements
            List<Product> productCatalog = Arrays.asList(laptop, smartphone, headphones, mouse);
            // Simulate browsing products
            System.out.println("\nAvailable products:");
            for (int i = 1; i <= productCatalog.size(); i++) {
                System.out.println(i + ": " + productCatalog.get(i - 1));
            }

            // Create a customer
            Customer tao = new Customer("Tao");
            System.out.println("\nCurrent customer:");
            System.out.println(tao);

            // Get customer's shopping cart
            ShoppingCart myCart = tao.getCart();
            myCart.addProduct(laptop, 2);
            myCart.addProduct(laptop, 5);
            myCart.addProduct(headphones, 1);

            System.out.println("\nTao's shopping cart:");
            for (var entry : myCart.getItems().entrySet()) {
                System.out.println(entry.getKey().getName() + " - Quantity: " + entry.getValue());
            }
            System.out.println("Total: $" + myCart.getTotalPrice());

            // Place an order
            Order myOrder = new Order(tao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}