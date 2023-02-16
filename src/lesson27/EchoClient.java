package lesson27;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Sergii Bugaienko
 */

public class EchoClient {
    public static void main(String[] args) {

        new EchoClient();
    }

    public EchoClient() {
        try (Socket socket = new Socket("localhost", 2048))
        {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Connect to server...");
            Scanner scanner = new Scanner(System.in);
            String message = "";
            do {
                message = scanner.nextLine();
                writer.println(message);
                writer.flush();
            } while (!message.equals("exit"));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
