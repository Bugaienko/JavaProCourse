package homework08;

import java.util.Iterator;

public class RubberList<T> implements Iterable<T>{
    private int size;
    private Node<T> first;
    private Node<T> last;

    public void addLast(T value) {
        if (first == null) { // Наша List пустой. Добавляем ноду в позицию first
            first = new Node<>(value, null, null);
        } else if (last == null) { // У нас есть только first. Добавляем ноду в позицию last
            last = new Node<>(value, first, null);
            first.next = last;
        }
        else { // У нас есть 2 и более элементов
            Node<T> temp = last;
            last = new Node<>(value, temp, null);
            temp.next = last;
        }
        size++;
    }

    public void addLast(T...values){
        for (T value: values){
            addLast(value);
        }
    }

    public void addFirst(T value) {
        if (first == null) {
            first = new Node<>(value, null, null);
        } else if (last == null) {
            last = first;
            first = new Node<>(value, null, last);
            last.previous = first;
        }
        else {
            Node<T> temp = first;
            first = new Node<>(value, null, temp);
            temp.previous = first;
        }
        size++;
    }


    //Удаляет, если есть, один элемент по значению (даже если совпадающих больше)
    public boolean remove(T value) {
        if (first != null) {
            Node<T> cursor = first;
            do {
                if (cursor.value.equals(value)) {
                    return deleteItem(cursor);
                }
                cursor = cursor.next;
            } while (cursor != null);
        }
        return false;
    }

    //Удаляет все элементы с совпадающими значениями
    public boolean removeAll(T value) {
        boolean result = false;
        if (first != null) {
            Node<T> cursor = first;
            do {
                if (cursor.value.equals(value)) {
                    result = deleteItem(cursor);
                }
                cursor = cursor.next;
            } while (cursor != null);
        }
        return result;
    }

    private boolean deleteItem(Node<T> deleteMe) {
        // DeletedItem is first
        if (deleteMe == first) {
            if (size > 2) { // If we have 3 and more elements
                deleteMe.next.previous = null;
                first = deleteMe.next;
            } else if (size == 2) { // If we have only 2 elements
                first = last;
                last = null;
            } else { // we have only 1 (first) element
                first = null;
            }
            // DeletedItem is Last
        } else if (deleteMe == last) {
            if (deleteMe.previous != first) { // If we have 3 and more elements
                last = last.previous;
                last.next = null;
            } else {
                // We have only 2 elements
                first.next = null;
                last = null;
            }
            // DeletedItem is NOT first or last
        } else if (size == 3) { // We have just 3 elements und must delete index = 1
            first.next = last;
            last.previous = first;

        } else if (deleteMe.previous == first) { //we remove the element inside the structure that IS the neighbor of FIRST
            first.next = deleteMe.next;
            deleteMe.next.previous = first;
        } else if (deleteMe.next == last) { //we remove the element inside the structure that IS the neighbor of LAST
            deleteMe.previous.next = last;
            last.previous = deleteMe.previous;
        } else { // we remove an element inside the structure that IS NOT a neighbor of last or first
            deleteMe.previous.next = deleteMe.next;
            deleteMe.next.previous = deleteMe.previous;
        }
        size--;
        return true;
    }

    public boolean removeLast() {
        if (first != null) {
            if (last == null) {
                first = null;
            } else if (first.next == last) {
                first.next = null;
                last = null;
            } else {
                Node<T> temp = last;
                last = temp.previous;
                last.next = null;
            }
            size--;
            return true;
        }
        return false;
    }

    public boolean removeFirst(){
        if (first != null){
            if (size == 2) {
                first = last;
                first.previous =null;
                last = null;
            } else {
                first = first.next;
                first.previous = null;
            }
            size--;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
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

    public Iterator<T> iterator(){
        return new Itr();
    }

    private class Itr implements Iterator<T>{
        Node<T> item;

        public Itr() {
            this.item = first;
        }

        @Override
        public boolean hasNext() {
            return item != null;
        }

        @Override
        public T next() {
            T value = item.value;
            item = item.next;
            return value;
        }
    }
}
