import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    private String userTextInput;
    private String[] words;

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    // User Input: Ask the user to input a paragraph or a lengthy text. Your program should read and store this input.
    public void run() {
        System.out.println("\nWelcome to Text Analysis Tool!");
        System.out.println("Enter a paragraph or a lengthy text:");

        // nextLine() reads a String value from the user
        userTextInput = scanner.nextLine();  // Read user input
        if (userTextInput == null || userTextInput.isEmpty()) {
            throw new IllegalStateException("Please make sure to enter a paragraph or a lengthy text.");
        }

        scanner.close();
    }
}