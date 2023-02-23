package lesson29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Bugaienko
 */

public class ChatServer {
    public static int SERVER_PORT = 2048;

    public static String EXIT_CMD = "/exit";
    public static String RENAME_CMD = "/rn";

    private List<ClientHandler> clients;

    public static void main(String[] args) {
        new ChatServer();
    }

    public ChatServer() {
        int clientCount = 0;
        clients = new ArrayList<>();
        System.out.println("Server started...");
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket socket = server.accept();
                String name = "Client #" + (++clientCount);
                ClientHandler client = new ClientHandler(socket, name);
                clients.add(client);
                new Thread(client).start();
                System.out.println(name + ": joined.");

//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                PrintWriter writer = new PrintWriter(socket.getOutputStream());
//                String message = "";
//                do {
//                    message = reader.readLine();
//                    System.out.println("Client says: " + message);
//                    writer.println((message.equals("exit")? "" : "Echo: ") + message);
//                    writer.flush();
//                } while (!message.equals("exit"));
//                reader.close();
//                writer.close();
//                System.out.println("Client disconnected ...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendToAll(String name, String message) {
        for (ClientHandler client : clients) {
            if (!name.equals(client.name)) {
                client.send(name + ": " + message);
            }
        }
    }

    private class ClientHandler implements Runnable {
        private BufferedReader reader;
        private PrintWriter writer;
        private Socket socket;
        private String name;

        public ClientHandler(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                do {
                    message = reader.readLine();
                    if (message.equals("exit")) {
                        sendToAll(name, "left the chat");
                        send("exit");
                    } else {
                        sendToAll(name, message);
                    }
                    System.out.println(name + ": " + message);
                } while (!message.equalsIgnoreCase("exit"));

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clients.remove(this);
            System.out.println(name + ": disconnected.");
        }

        public void send(String message) {
            writer.println(message);
            writer.flush();
        }
    }
}
