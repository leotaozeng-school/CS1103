import java.io.*;
import java.net.*;

/**
 * This class implements Java Socket server to handle multiple Clients with socket connections
 *
 * @author Tao Zeng
 */
public class ChatServer {
    // socket server port on which it will listen
    private static final int PORT = 5000;

    public void start() throws Exception {
        System.out.println("Chat Server is running on port " + PORT);
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        ClientHandler clientHandler = new ClientHandler(clientSocket);
    }

    // Run method to handle client communication
    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        private int userId;

        // Constructor
        public ClientHandler(Socket socket, int userId) throws IOException {
            // Create input and output streams for communication
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.clientSocket = socket;
            this.userId = userId;
        }

        // Run method to handle client communication
        @Override
        public void run() {
            try {

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
