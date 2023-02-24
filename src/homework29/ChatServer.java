package homework29;

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
    public static int SERVER_PORT = 512;

    public final static String EXIT_CMD = "/exit";
    public final static String RENAME_CMD = "/rn";
    public final static String USERS_SHOW_CMD = "/users";
    public final static String HELP_CMD = "/help";

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
                    if (isCommandInMessage(message).length == 0) {
//                        if (message.equals(EXIT_CMD)) {
//                            sendToAll(name, "left the chat");
//                            send(EXIT_CMD);
//                        } else {
                        sendToAll(name, message);
//                        }
                    }
                    System.out.println(name + ": " + message);
                } while (!message.equalsIgnoreCase(EXIT_CMD));

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clients.remove(this);
            System.out.println(name + ": disconnected.");
        }

        private void send(String message) {
            writer.println(message);
            writer.flush();
        }

        private String[] isCommandInMessage(String message) {
            String[] messageWithoutNoCommand = new String[0];

            if (message.length() < 1) {
                return messageWithoutNoCommand;
            }
            String[] strings = message.split(" ");

            switch (strings[0]) {
                case EXIT_CMD:
                    sendToAll(name, "left the chat");
                    send(EXIT_CMD);
                    return strings;
                case RENAME_CMD:
                    if (strings[1] != null) {
                        name = strings[1];
                        send("You changed your name to: " + name);
                        sendToAll(name, "My new name: " + name);
                    }
                    return strings;
                case USERS_SHOW_CMD:
                    StringBuilder stringBuilder = new StringBuilder("Users online: \n");
                    int count = 0;
                    for (ClientHandler client: clients) {
                        stringBuilder.append(client.name);
                        stringBuilder.append("\n");
                        count++;
                    }
                    stringBuilder.append("Total: " + count);
                    send(stringBuilder.toString());
                    return strings;
                case HELP_CMD:
                    StringBuilder sB2 = new StringBuilder("Commands: \n");
                    sB2.append("/help -> read help \n");
                    sB2.append("/users -> show online users \n");
                    sB2.append("/rn newName -> change Name to newName \n");
                    sB2.append("/exit -> Exit");
                    send(sB2.toString());


                default:
                    return messageWithoutNoCommand;

            }
        }

    }
}
