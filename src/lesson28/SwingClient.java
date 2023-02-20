package lesson28;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author Sergii Bugaienko
 */

public class SwingClient extends JFrame {
    JTextField msgField;
    JTextArea dialogue;
    JButton send;
    JButton connect;
    PrintWriter writer;
    BufferedReader reader;
    Boolean isConnectServer = false;


    public static void main(String[] args) {
        new SwingClient();
    }

    public SwingClient() {
        setTitle("Network chat client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (writer != null) {
                    writer.println("exit");
                    writer.close();
                }
                super.windowClosing(e);
            }
        });

        dialogue = new JTextArea();
        dialogue.setLineWrap(true);
        dialogue.setEditable(false);
        JScrollPane scroll = new JScrollPane(dialogue);


        msgField = new JTextField();
        send = new JButton("Send");

        connect = new JButton("Connect");


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(connect);
        panel.add(msgField);
        panel.add(send);


        // Listen Enter key on Message Field
        msgField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessageToServer();
                }
                super.keyPressed(e);
            }
        });

        connect.addActionListener(e -> {
            if (isConnectServer) {
                disconnect();
            } else {
                connect();
            }
        });

        send.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO вынести в отдельный метод
                sendMessageToServer();
            }
        }));

        add(BorderLayout.CENTER, scroll);
        add(BorderLayout.SOUTH, panel);

        setVisible(true);

        connect();

    }

    private void sendMessageToServer() {
        try {
            String echo = "";
            writer.println(msgField.getText());
            writer.flush();
            dialogue.append("   I: " + msgField.getText() + "\n");
            echo = reader.readLine();

            dialogue.append("   A:  " + echo + "\n");
            msgField.setText("");
            msgField.requestFocusInWindow();
            if (echo.equals("exit")) {
                dialogue.append("   S: disconnect done" + "\n");
               switchOfButtons();
//                connect.setText("Connect");
////                connect.setEnabled(true);
//                isConnectServer = false;
            }
        } catch (SocketException se) {
            System.out.println("Connection to server lost");
            connect.setText("Connect");
//            connect.setEnabled(true);
            isConnectServer = false;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



    private void disconnect() {
        String echo = "";
        writer.println("exit");
        writer.flush();
        dialogue.append("   S: connection to server los" + "\n");
        try {
            echo = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switchOfButtons();

    }

    private void switchOfButtons() {
        connect.setText("Connect");
        isConnectServer = false;
        msgField.setEnabled(false);
        send.setEnabled(false);
    }

    private void connect() {
        try {
            Socket socket = new Socket("localhost", 2048);
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            connect.setText("Disconnect");
//            connect.setEnabled(false);
            isConnectServer = true;
            dialogue.append("   S:  connection to server -> successfully" + "\n");
            System.out.println("Connect to server...");
            msgField.setEnabled(true);
            send.setEnabled(true);
            msgField.requestFocusInWindow();
        } catch (IOException e) {
            System.out.println("Can't Connect to server...");
        }


    }
}
