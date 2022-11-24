package lesson08;

public class RubberList<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public void add(T value) {
        if (first == null) {
            first = new Node<>(value, null, null);
        } else if (last == null) {
            last = new Node<>(value, first, null);
            first.next = last;
        } else {
            Node<T> temp = last;
            last = new Node<>(value, temp, null);
            temp.next = last;
        }
        size++;
    }

    public void firstAdd(T value) {
        if (first == null) {
            first = new Node<>(value, null, null);
        } else if (last == null) {
            last = first;
            first = new Node<>(value, null, last);
        } else {
            Node<T> temp = first;
            first = new Node<>(value, null, temp);
            temp.previous = first;
        }
        size++;
    }

    // size . Реализовать. И убрать проблему с 2 эл при удаление одного из них
    public boolean remove(T value) {
        if (first != null) {
            Node<T> cursor = first;
            do {
                if (cursor.value.equals(value)) {
                    //remove
                    if (cursor == first) {
                        System.out.println("First");
                        if (size > 2) {
                            cursor.next.previous = null;
                            first = cursor.next;
                        } else if (size == 2) {
                            first = last;
                            last = null;
                        } else {
                            first = null;
                        }
                    } else if (cursor == last) {
                        System.out.println("Last");
                        if (last.previous != first) {
                            last = last.previous;
                            last.next = null;
                        } else {
                            first.next = null;
                            last = null;
                        }
                    } else if (size == 3) {
                        System.out.println("3 elements");
                        first.next = last;
                        last.previous = first;
                    } else {
                        cursor.previous.next = cursor.next;
                        cursor.next.previous = cursor.previous;
                    }
                    size--;
                    return true;
                    // end remove
                }
                cursor = cursor.next;
            } while (cursor != null);
        }
        return false;
    }

    public boolean removeLast() {
        if (first != null) {
            if (last == null) {
                first = null;
                size--;
                return true;
            } else if (first.next == last) {
                first.next = null;
                last = null;
                size--;
                return true;
            } else {
                Node<T> temp = last;
                last = temp.previous;
                last.next = null;
                temp = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (first != null) {
            sb.append(first.value);
            Node<T> cursor = first;
            while ((cursor.next != null)) {
                sb.append("; ");
                sb.append(cursor.next.value);
                cursor = cursor.next;
            }
        }
        return sb.append("]").toString();
    }

    private class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;

        public Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    value +
                    '}';
        }
    }
}
