package lesson27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Sergii Bugaienko
 */

public class EchoServer {
    public static void main(String[] args) {
        new EchoServer();
    }

    public EchoServer() {
        try (ServerSocket server = new ServerSocket(2048)) {
            System.out.println("Server started...");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected ...");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = "";
                do {
                    message = reader.readLine();
                } while (!message.equals("exit"));
                reader.close();
                System.out.println("Client disconnected ...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
