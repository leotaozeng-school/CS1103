/**
 * User Interface:
 * a. Include a simple text-based for the client to facilitate message input and display.
 */

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("server")) {
            runServer();
        } else {
            runClient();
        }
    }

    private static void runServer() {
        try {
            ChatServer server = new ChatServer();
            server.start();
        } catch (Exception e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    private static void runClient() {
        try {
            ChatClient client = new ChatClient();
            client.start();

            String userInput;
            while (true) {
                userInput = scanner.nextLine(); // Reads a String value from the user
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                client.sendMessage(userInput);
            }

            client.stop();
        } catch (Exception e) {
            System.out.println("Error running client: " + e.getMessage());
        } finally {
            System.out.println("Goodbye!");
            // Close the input in a finally block to ensure it's always closed
            scanner.close();
        }
    }
}