package lesson27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Sergii Bugaienko
 */

public class HelloSocket {
    public static void main(String[] args) {
        new HelloSocket();
    }

    public HelloSocket() {
        try (Socket socket = new Socket("localhost", 2048))
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
