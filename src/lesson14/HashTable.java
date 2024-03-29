package lesson14;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class HashTable<K, V> extends JFrame {
    private int capacity = 16;
    private Entry<K, V>[] buckets = new Entry[capacity];
    private int size = 0;

    private Random random = new Random();

    public HashTable() {
        setTitle("Hello Swing");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 600);
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

    public void put(K key, V value) {
        int hash = key.hashCode();
//        System.out.println("hash: " + hash);
        Entry<K, V> entry = new Entry<>(hash, key, value);
        int idx = hash & (capacity - 1);
        System.out.println("idx: " + idx);
        if (buckets[idx] == null) {
            buckets[idx] = entry;
        } else {
            Entry<K, V> pointer = buckets[idx];
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = entry;
        }
        size++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int idx = hash & (capacity - 1);
        if (buckets[idx] == null) {
            return null;
        }
        Entry<K, V> pointer = buckets[idx];
        do {
            if (pointer.key.equals(key)) {
                return pointer.value;
            }
            pointer = pointer.next;
        } while (pointer != null);
        return null;
    }

    private class Entry<K, V> {
        private int hash;
        private K key;
        private V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }

    @Override
    public String toString() {
        int counter = 0;
        StringBuilder sb = new StringBuilder("[");
        for (Entry<K, V> entry : buckets) {
            Entry<K, V> pointer = entry;
            while (pointer != null) {
                sb.append(pointer.key + "=" + pointer.value);
                counter++;
                if (counter < size) {
                    sb.append(", ");
                }
                pointer = pointer.next;
            }
        }
        return sb.append("]").toString();
    }

    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);

            // рисуем что хотим
            for (int i = 0; i < buckets.length; i++) {
                int link = 0;
                int x = 10 + i * 70;
                int y = 20;
                int dx = 65;
                int dy = 65;
                if (buckets[i] != null) {
                    g.setColor(Color.cyan);
                    g.fillRect(x, y, dx, dy);
                    Entry<K, V> pointer = buckets[i];
                    while (pointer.next != null) {
                        y = 20 + 65 + dy * link + 10 * (link + 1) ;
                        link++;
                        g.fillRect(x, y, dx, dy);
                        pointer = pointer.next;
                    }
                } else {
                    g.setColor(Color.gray);
                    g.drawRect(x, y, dx, dy);

                }
            }
//            g.fillOval(10, 10, 100, 100);

//            for (int i = 0; i < 10; i++) {
//                g.setColor(Color.blue);
//                int x = random.nextInt(500);
//                int y = random.nextInt(350);
//                int dx = random.nextInt(100);
//                int dy = random.nextInt(100);
//                if (random.nextBoolean()) {
//                    g.fillOval(x, y, dx, dy);
//                } else {
//                    g.fillRect(x, y, dx, dy);
//                }
//            }
        }
    }
}
