package lesson16;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.*;

public class SwingHashTable extends JFrame {
    private final int WIDTH_SIZE = 1800;
    private final int HEIGHT_SIZE = 600;
    private HashTable<String, String> hashTable = new HashTable<>(16);

    public static void main(String[] args) {
        new SwingHashTable();
    }

    private void initTable() {
        hashTable.put("Kiev", "Ukraine"); //15
        hashTable.put("Berlin", "Germany"); //2
        hashTable.put("Paris", "France"); //11
        hashTable.put("Madrid", "Spain"); //13
        hashTable.put("Oslo", "Sweden"); //7
        hashTable.put("Baku", "Azer"); //9
    }

    public SwingHashTable() {
        initTable(); // Если закомментировать - будет пустая карта
        setTitle("HashTable");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CanvasPanel canvasPanel = new CanvasPanel();
        canvasPanel.setPreferredSize(new Dimension(WIDTH_SIZE, HEIGHT_SIZE));
        canvasPanel.setBackground(Color.lightGray);

        JTextField textField = new JTextField();
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(e -> {
            String[] tokens = textField.getText().split(" ");
            switch (tokens[0].toLowerCase()) {
                case "put":
                    hashTable.put(tokens);
                    textField.setText("");
                    break;
                case "get":
                    String res = hashTable.get(tokens);
                    textField.setText(res);
                    break;
                case "remove":
                    String res2 = hashTable.remove(tokens);
                    textField.setText(res2);
                    break;
                default:
                    textField.setText("Неверная команда");
            }
            canvasPanel.repaint();
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.add(textField);
        bottomPanel.add(enterButton);

        add(canvasPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            HashTable<String, String>.Entry<String, String>[] table = hashTable.getBuckets();
            g.setColor(Color.black);
            String sizeStr = "size = " + hashTable.getSizeTable();
            g.drawString(sizeStr, 780, 13);

            for (int i = 0; i < table.length; i++) {
                int link = 0;
                int dx = 80; // размер квадрата по Х - можно менять
                int dy = 80; //размер квадрата по Y - можно менять
                int x = 10 + i * (dx + 5);
                int y = 20;
                if (table[i] != null) {
                    g.setColor(Color.cyan);
                    g.fillRect(x, y, dx, dy);
                    g.setColor(Color.black);
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append(" ");
                    sb.append(table[i].key);
                    g.drawString(sb.toString(), x + 5, y + 25);
                    g.drawString(table[i].value, x + 5, y + 40);
                    String next = (table[i].next == null) ? "n-> null" : "n-> " + table[i].next.key;
                    g.drawString(next, x + 5, y + 55);
                    HashTable<String, String>.Entry<String, String> pointer = table[i];
                    while (pointer.next != null) {
                        y = 20 + dx + dy * link + 10 * (link + 1);
                        link++;
                        g.setColor(Color.cyan);
                        g.fillRect(x, y, dx, dy);
                        g.setColor(Color.black);
                        StringBuilder sb1 = new StringBuilder();
                        sb1.append(i);
                        sb1.append(" ");
                        sb1.append(pointer.next.key);
                        g.drawString(sb1.toString(), x + 5, y + 25);
                        g.drawString((String) pointer.next.value, x + 5, y + 40);
                        String next2 = (pointer.next.next == null) ? "n-> null" : "n-> " + pointer.next.next.key;
                        g.drawString(next2, x + 5, y + 55);
                        pointer = pointer.next;
                    }
                } else {
                    g.setColor(Color.gray);
                    g.drawRect(x, y, dx, dy);
                    g.setColor(Color.black);
                    g.drawString(String.valueOf(i), x + 5, y + 25);
                }
            }
            // TODO
        }
    }
}
