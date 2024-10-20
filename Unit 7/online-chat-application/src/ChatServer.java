/**
 * Server Implementation:
 * a. Create a server class, ChatServer, using socket programming to manage connections from multiple clients.
 * b. The server should be able to handle incoming connections, assign a unique user ID to each connected client, and maintain a list of connected users.
*/

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class implements Java Socket Server to handle multiple Clients with socket connections
 * @author Tao Zeng
 */
public class ChatServer {
    // socket server port on which it will listen
    private static final int PORT = 5001;
    private final Set<PrintWriter> writers = new HashSet<>();
    private int userIdCounter = 0;
    private final ExecutorService pool = Executors.newFixedThreadPool(50);

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat Server is running on port " + PORT);
            // Accept incoming connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                // Create a new client handler for the connected client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                pool.execute(clientHandler);
            }
        } finally {
            pool.shutdown();
        }
    }

    // Run method to handle client communication
    private class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final BufferedReader in;
        private final PrintWriter out;
        private final int userId;

        // Constructor
        public ClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            this.userId = ++userIdCounter;

            // Create input and output streams for communication
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        }

        // Run method to handle client communication
        @Override
        public void run() {
            try {
                synchronized (writers) {
                    writers.add(out);
                }

                broadcast("User " + userId + " has joined the chat.");

                String message;
                while ((message = in.readLine()) != null) {
                    if (!message.isEmpty()) {
                        broadcast("User " + userId + ": " + message);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client " + userId + ": " + e.getMessage());
            } finally {
                if (out != null) {
                    synchronized (writers) {
                        writers.remove(out);
                    }
                }
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket for client " + userId + ": " + e.getMessage());
                }
                broadcast("User " + userId + " has left the chat.");
            }
        }
    }

    private void broadcast(String message) {
        synchronized (writers) {
            for (PrintWriter writer : writers) {
                writer.println(message);
            }
        }
    }
}
