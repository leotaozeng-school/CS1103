## Online Chat Application
This assignment aims to assess your skills in socket programming, client-server communication, and user interface design.

## Instructions
You are tasked with developing a simple online chat application using Java. The application should allow multiple users to connect to a central server, send messages, and receive messages from other users.

### Tasks:
1. **Server Implementation:**
   - Create a server class, ChatServer, using socket programming to manage connections from multiple clients.
   - The server should be able to handle incoming connections, assign a unique user ID to each connected client, and maintain a list of connected users.

2. **Client Implementation:**
    - Implement a client class, ChatClient, that connects to the server using sockets.
    - Each client should be able to send messages to the server, which will broadcast the messages to all connected clients.
    - Clients should also be able to receive messages from other users.

3. **User Interface:**
    - Include a simple text-based for the client to facilitate message input and display.

## Files
1. `Main.java`: The entry point of the application. It allows you to start either a server or a client.
2. `ChatServer.java`: Contains the server implementation.
3. `ChatClient.java`: Contains the client implementation.