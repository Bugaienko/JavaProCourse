package lesson16_HashTable_Swing;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HashTable<K, V> extends JFrame {
    private int capacity = 16;
    private Entry<K, V>[] buckets;
    private int size = 0;
    private final Random random = new Random();
    private boolean isSwing = false;

    public HashTable() {
        this.buckets = new Entry[capacity];
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[capacity];
    }

    public void swingMe() {
        if (!isSwing) {
            isSwing = true;
            new HashMapSwing();
        } else {
            System.out.println("Already starting");
        }
    }

    public void addList(List<Dict> list) {
        for (Dict dict : list) {
            put((K) dict.getCapital(), (V) dict.getCountry());
        }
    }

    public int getSizeTable() {
        return size;
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int idx = hash & (capacity - 1);
        System.out.println("idx: " + idx);
        if (get(key) == null) {
//        System.out.println("hash: " + hash);
            Entry<K, V> entry = new Entry<>(hash, key, value);
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
            if (size >= capacity * 0.8) {
                capacity = (int) (capacity * 1.5);
                recalculateMap();
            }
        } else {
            Entry<K, V> pointer = buckets[idx];
            while (pointer != null) {
                if (pointer.key.equals(key)) {
                    pointer.value = value;
                    return;
                }
                pointer = pointer.next;
            }
        }
    }

    private void recalculateMap() {
        Entry<K, V>[] tempBuckets = toArray(buckets);
        size = 0;
        buckets = new Entry[capacity];

        for (Entry<K, V> entry : tempBuckets) {
            put(entry.key, entry.value);
        }
        System.out.println("HashMap was recalculate");
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
            buckets[idx] = buckets[idx].next;

//            if (pointer.next == null) {
//                buckets[idx] = null;
//            } else {
//                buckets[idx] = buckets[idx].next;
//            }

            size--;
            return result;
        }
        Entry<K, V> next = pointer.next;
        while (next != null) {
            if (next.key.equals(key)) {
                size--;
                V result = next.value;
                pointer.next = next.next;

//                if (next.next == null) {
//                    pointer.next = null;
//                } else {
//                    pointer.next = next.next;
//                }
                return result;
            }
            pointer = pointer.next;
            next = next.next;
        }
        return null;
    }

    public class Entry<K, V> {
        private int hash;
        public K key;
        public V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }

    private Entry[] toArray(Entry[] bucketsMap) {
        Entry[] array = new Entry[size];
        int counter = 0;
        for (Entry<K, V> entry : bucketsMap) {
            Entry<K, V> pointer = entry;
            while (pointer != null) {
                array[counter++] = pointer;
                pointer = pointer.next;
            }
        }
        System.out.println(array);
        return array;
    }

    public Entry<K, V>[] getBuckets() {
        return buckets;
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

    public boolean readCommand(String command) {

        String[] tokens = command.split(" ");
        switch (tokens[0].toLowerCase()) {
            case "put":
                put(tokens);
                break;
            case "get":
                get(tokens);
                break;
            case "remove":
                remove(tokens);
                break;
            case "swing":
                swingMe();
                break;
            case "exit":
                System.out.println("exit");
                return false;
            default:
                System.out.println("Def");
                return false;
        }
        return true;
    }

    public V get(String[] tokens) {
//        System.out.println("GET " + Arrays.toString(tokens));
        if (tokens.length > 1) {
            V result = get((K) tokens[1]);
            System.out.println((String) result);
            return result;
        }
        return null;
    }

    public void put(String[] tokens) {
        System.out.println("Put " + Arrays.toString(tokens));
        if (tokens.length > 2) {
            put((K) tokens[1], (V) tokens[2]);
        }
    }

    public V remove(String[] tokens) {
        V result = null;
        if (tokens.length > 1) {
            result = remove((K) tokens[1]);
        }
        return result;
    }

    private class HashMapSwing extends JFrame {
        public HashMapSwing() {
            setTitle("HashMapSwing scheme");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(1740, 600);
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
    }

    private class CanvasPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.black);
            String sizeStr = "size = " + size;
            g.drawString(sizeStr, 780, 13);
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
