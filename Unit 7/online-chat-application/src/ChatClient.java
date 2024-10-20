/**
 * Client Implementation:
 * a. Implement a client class, ChatClient, that connects to the server using sockets.
 * b. Each client should be able to send messages to the server, which will broadcast the messages to all connected clients.
 * c. Clients should also be able to receive messages from other users.
*/

import java.io.*;
import java.net.*;

/**
 * This class implements Java Socket Client
 * @author Tao Zeng
 */
public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 5001;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public void start() throws IOException {
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

        // Setting up input and output streams
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Start a thread to handle incoming messages from the server
        new Thread(new MessageReader()).start();

        System.out.println("Connected to the chat server.");
        System.out.println("Type your messages. Type 'exit' to quit.");
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        socket.close();
    }

    private class MessageReader implements Runnable {
        public void run() {
            String serverResponse;
            try {
                while ((serverResponse = in.readLine()) != null) {
                    System.out.println(serverResponse);
                }
            } catch (IOException e) {
                System.out.println("Error reading from server: " + e.getMessage());
            }
        }
    }
}
