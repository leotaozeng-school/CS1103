/*
a. Create a simple command-line interface for users to interact with the library catalog
b. Allow users to add a new library item, remove an item, and view the current catalog
*/

import java.util.Scanner;

public class Main {
    private static final Catalog<String> catalog = new Catalog<>();
    private static final Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    public int getIntInput(Scanner input) {
        while (true) {
            try {
                // nextLine() returns a String value from the user
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    // User Input: Ask the user to input a paragraph or a lengthy text. Your program should read and store this input.
    public void run() {
        try {
            int choice;
            do {
                displayMenu();

                // Get the user's choice
                choice = getIntInput(scanner);

                // Switch statements to perform actions based on the user's choice
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        removeItem();
                        break;
                    case 3:
                        catalog.displayCatalog();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        // Handle invalid input and display appropriate error messages
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } finally {
            System.out.println("Goodbye!");
            // Close the input in a finally block to ensure it's always closed
            scanner.close();
        }
    }

    private static void displayMenu() {
        System.out.println("\nLibrary Catalog Menu:");
        System.out.println("1. Add a new library item");
        System.out.println("2. Remove an item");
        System.out.println("3. View catalog");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: "); // The print() method does not move the cursor to a new line.
    }

    public void addItem() {
        System.out.print("Enter item title: ");
        String title = scanner.nextLine();
        System.out.print("Enter item author: ");
        String author = scanner.nextLine();
        System.out.print("Enter item ID: ");
        String itemID = scanner.nextLine();

        LibraryItem<String> newItem = new LibraryItem<>(title, author, itemID);
        catalog.addItem(newItem);
    }

    public void removeItem() {
        System.out.print("Enter the ID of the item to remove: ");
        String itemID = scanner.nextLine();
        catalog.removeItem(itemID);
    }
}