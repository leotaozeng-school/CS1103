package com.ecommerce;

public class Customer {
    private String customerID;
    private String name;
    private int shoppingCartID;

    // Constructor Declaration of Class
    public Customer(int productID, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String newName) {
        this.name = newName;
    }
}
