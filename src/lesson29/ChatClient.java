package lesson29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static lesson29.ChatServer.SERVER_PORT;

/**
 * @author Sergii Bugaienko
 */

public class ChatClient {
    private static String SERVER_IP = "localhost";
//    private static String SERVER_IP = "91.149.232.150";
    public static void main(String[] args) {

        new ChatClient();
    }

    public ChatClient() {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream());
             BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()))
        )
        {
            System.out.println("Connect to server...");
            new Thread(new CommandHandler(writer)).start();
            String message;
            do {
                message = reader.readLine();
                System.out.println(message);
            } while (!message.equalsIgnoreCase("exit"));
            System.out.println("Connection close");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class CommandHandler implements Runnable {
        private PrintWriter writer;
        private Scanner scanner;

        public CommandHandler(PrintWriter writer) {
            this.writer = writer;
            this.scanner = new Scanner(System.in);
        }

        @Override
        public void run() {
            String message;
            do {
                message = scanner.nextLine();
                writer.println(message);
                writer.flush();

            } while (!message.equalsIgnoreCase("exit"));

        }
    }

}
