package homework14Extra;

import lesson14.HashTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class MainHomework14Extra extends JFrame {
    final private Color[] COLORS = {Color.red, Color.green,
            Color.blue, Color.black, Color.MAGENTA,
            Color.yellow, Color.pink, Color.ORANGE};
    private Random random = new Random();

    public static void main(String[] args) {
        new MainHomework14Extra();
    }

    public MainHomework14Extra() {
        setTitle("Hello Swing");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        CanvasPanel canvasPanel = new CanvasPanel();
        canvasPanel.setBackground(Color.lightGray);

        Button button = new Button("Repaint");
        button.addActionListener(e -> {
            System.out.println("Repaint");
            canvasPanel.repaint();
        });

        add(canvasPanel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            // рисуем что хотим

            for (int i = 0; i < 150; i++) {
                g.setColor(COLORS[(random.nextInt(COLORS.length))]);
                int x = random.nextInt(500);
                int y = random.nextInt(350);
                int dx = random.nextInt(100);
                int dy = random.nextInt(100);
                if (random.nextBoolean()) {
                    g.fillOval(x, y, dx, dy);
                } else {
                    g.fillRect(x, y, dx, dy);
                }
            }
        }
    }
}
