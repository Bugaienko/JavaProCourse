package lesson28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        try (Socket socket = new Socket("localhost", 2048);
             PrintWriter writer = new PrintWriter(socket.getOutputStream());
             BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()))
        )
        {
            System.out.println("Connect to server...");
            Scanner scanner = new Scanner(System.in);
            String message = "";
            do {
                System.out.println("> ");
                message = scanner.nextLine();
                writer.println(message);
                writer.flush();
                System.out.println(reader.readLine());
            } while (!message.equals("exit"));
            System.out.println("Connection close");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
