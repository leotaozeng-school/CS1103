/*
a. Implement a generic catalog class that can store information about library items (e.g., books, DVDs, magazines)
b. Ensure that the catalog works seamlessly with different types of items by using generics
*/

import java.util.ArrayList;
import java.util.List;

public class Catalog<T> {
    private final List<LibraryItem<T>> items;

    public Catalog() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem<T> item) {
        items.add(item);
        System.out.println("Item added successfully.");
    }

    public void removeItem(T itemID) {
        boolean removed = items.removeIf(item -> item.getItemID().equals(itemID));
        if (removed) {
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public LibraryItem<T> getItem(T itemID) {
        for (LibraryItem<T> item : items) {
            if (item.getItemID().equals(itemID)) {
                return item;
            }
        }
        return null;
    }

    public void displayCatalog() {
        if (items.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            System.out.println("Current Catalog:");
            for (LibraryItem<T> item : items) {
                System.out.println(item);
            }
        }
    }
}
