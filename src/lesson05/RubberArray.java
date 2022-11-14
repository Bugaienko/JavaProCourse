package lesson05;


public class RubberArray {
    private int[] array;

    public void add(int item) {
        if (array == null) {
            System.out.println("Null");
            array = new int[0];
        }
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = item;
        array = newArray;
    }

    public void addAll(int... ints) {
        for (int item : ints) {
            add(item);
        }
    }

    public int size() {
        if (array != null) {
            return array.length;
        }
        return 0;
    }

    public int get(int idx) {
        if (array != null && idx >= 0 && idx < array.length) {
            return array[idx];
        }
        return -1;
    }

    public void set(int idx, int item) {
        if (array != null) {
            array[idx] = item;
        }
    }

    public boolean contains(int element) {
        for (int i : array) {
            if (i == element) return true;
        }
        return false;
    }

    public void remove(int idx) {
        if (array != null && idx <= array.length - 1 && idx >= 0) {
            int[] newArray = new int[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, idx);
            System.arraycopy(array, idx + 1, newArray, idx, newArray.length - idx);
            array = newArray;
        }
    }

    public boolean remove(Integer item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                remove(i);
                return true;
            }
        }
        return false;
    }
    public int[] toArray() {
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
}
