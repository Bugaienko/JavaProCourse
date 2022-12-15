package lesson14;

import java.util.Arrays;

public class HashTable<K, V> {
    private int capacity = 16;
    private Entry<K, V>[] buckets = new Entry[capacity];
    private int size = 0;

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
            while (pointer.next != null){
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
        for (Entry<K, V> entry: buckets) {
                Entry<K, V> pointer = entry;
                while (pointer != null){
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
}
