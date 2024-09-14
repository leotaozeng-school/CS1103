# Overview
**Exception Handling** and **String Handling** in Java serves as a crucial component of the course, bridging the gap between fundamental programming concepts and more advanced software development practices. They are fundamental building blocks for writing robust, user-friendly applications.

Exception handling is the art of managing errors and exceptions gracefully in our code, ensuring that software remains robust and reliable. We will learn how to use **try-catch blocks, throw and throws keywords**, and handle different **types of exceptions**. Additionally, we will delve into the world of strings, understanding their importance in working with textual data and harnessing the power of **Java's string handling capabilities**.

## Assignment Instructions
In this assignment, you will create a simple e-commerce system for an online store using Java. The system allows customers to browse products, add them to a shopping cart, and place orders. The focus is on organizing the code using Java packages and the import statement for better encapsulation.

**Scenario:** You are tasked with building a simple e-commerce system for an online store. This system should allow customers to browse products, add them to a shopping cart, and place orders. To ensure proper organization and encapsulation, you will be using Java packages and the **import** statement.  

## Assignment Tasks:
1. Create a Java package named **com.ecommerce** to encapsulate all classes related to the e-commerce system.  

2. Inside the **com.ecommerce** package, create the following classes:
    - **Product** class: This class should represent a product available for purchase. Include attributes like **productID**, **name**, **price**, and any other relevant fields. Implement the necessary constructors, getters, setters, and any other methods for product-related operations.

    - **Customer** class: This class should represent a customer with attributes like **customerID**, **name**, and a shopping cart. Implement methods to add and remove products from the shopping cart, calculate the total cost, and place orders.  

3. Create a package named  **com.ecommerce.orders** for managing orders. 

4. Inside the **com.ecommerce.orders**  package, create the following classes:
    - **Order** class: This class should represent an order placed by a customer. Include attributes like **orderID**, **customer**, **products**, and the order total. Implement methods to generate order summaries, update order status, and manage order information.  

5. In the main program (outside of packages), demonstrate the use of packages and the import statement by:  
    - Creating instances of products, customers, and orders.  

    - Allowing customers to browse products, add them to their shopping cart, and place orders.  

    - Displaying information about products, customers, and orders.  

6. Make sure to import the necessary classes from the **com.ecommerce** and **com.ecommerce.orders**  packages into the main program.  

7. Use appropriate access modifiers to ensure proper encapsulation and data hiding.  
