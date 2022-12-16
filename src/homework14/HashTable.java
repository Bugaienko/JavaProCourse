package homework14;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HashTable<K, V> extends JFrame {
    private int capacity = 16;
    private Entry<K, V>[] buckets = new Entry[capacity];
    private int size = 0;

    private Random random = new Random();

    public HashTable() {
        setTitle("HashMap work scheme");
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

    public V remove(K key) {
        int hash = key.hashCode();
        int idx = hash & (capacity - 1);
        if (buckets[idx] == null) {
            return null;
        }
        Entry<K, V> pointer = buckets[idx];
        if (pointer.key.equals(key)) {
            V result = pointer.value;
            if (pointer.next == null) {
                buckets[idx] = null;
            } else {
                buckets[idx] = buckets[idx].next;
            }
            return result;
        }
        Entry<K, V> next = pointer.next;
        while (next != null) {
            if (next.key.equals(key)) {
                V result = next.value;
                if (next.next == null) {
                    pointer.next = null;
                } else {
                    pointer.next = next.next;
                }
                return result;
            }
            pointer = pointer.next;
            next = next.next;
        }
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
            for (int i = 0; i < buckets.length; i++) {
                int link = 0;
                int x = 10 + i * 70;
                int y = 20;
                int dx = 65;
                int dy = 65;
                if (buckets[i] != null) {
                    g.setColor(Color.cyan);
                    Rectangle rect1 = new Rectangle(x, y, dx, dy);
                    g.fillRect(x, y, dx, dy);
                    g.setColor(Color.black);
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append(" ");
                    sb.append((String) buckets[i].key);
                    g.drawString(sb.toString(), x + 5, y + 25);
                    g.drawString((String) buckets[i].value, x + 5, y + 40);
                    String next = (buckets[i].next == null) ? "n-> null" : "n-> " + buckets[i].next.key;
                    g.drawString(next, x + 5, y + 55);
                    Entry<K, V> pointer = buckets[i];
                    while (pointer.next != null) {
                        y = 20 + 65 + dy * link + 10 * (link + 1);
                        link++;
                        g.setColor(Color.cyan);
                        g.fillRect(x, y, dx, dy);
                        g.setColor(Color.black);
                        StringBuilder sb1 = new StringBuilder();
                        sb1.append(i);
                        sb1.append(" ");
                        sb1.append((String) pointer.next.key);
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
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i);
                    g.drawString(sb2.toString(), x + 5, y + 25);
                }
            }
        }
    }
}
