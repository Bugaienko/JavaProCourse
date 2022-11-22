package lesson07;


import java.util.Iterator;

public class RubberArray<T> implements Iterable<T>{
    private T[] array;

    public void add(T item) {
        if (array == null) {
//            System.out.println("Null");
            array = (T[]) new Object[0];
        }
        T[] newArray = (T[]) new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = item;
        array = newArray;
    }

    public void addAll(T... objects) {
        for (T item : objects) {
            add(item);
        }
    }

    public int indexOf(T item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public void replace(T item, T newItem) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(item)) array[i] = newItem;
            }
        }
    }

    public homework06.RubberArray<T> subList(int fromIndex, int toIndex) {
        homework06.RubberArray<T> temp = new homework06.RubberArray<>();
        if (array != null) {
            for (int i = fromIndex; i < toIndex; i++) {
                temp.add(array[i]);
            }
        }
        return temp;
    }


    public Object lastIndexOf(Object item) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                result = i;
            }
        }
        return result;
    }

    public int size() {
        if (array != null) {
            return array.length;
        }
        return 0;
    }

    public T get(int idx) {
        if (array != null && idx >= 0 && idx < array.length) {
            return array[idx];
        }
        return null;
    }

    public void set(int idx, T item) {
        if (array != null) {
            array[idx] = item;
        }
    }

    public boolean contains(T element) {
        for (T i : array) {
            if (i.equals(element)) return true;
        }
        return false;
    }

    public void remove(int idx) {
        if (array != null && idx <= array.length - 1 && idx >= 0) {
            T[] newArray = (T[]) new Object[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, idx);
            System.arraycopy(array, idx + 1, newArray, idx, newArray.length - idx);
            array = newArray;
        }
    }

    public boolean remove(T item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public T[] toArray() {
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i != array.length - 1) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int cursor = 0; //

        @Override
        public boolean hasNext() {
            return array != null && array.length > cursor;
//            return cursor != array.length;
        }

        @Override
        public T next() {
            return array[cursor++];
        }
    }
}
