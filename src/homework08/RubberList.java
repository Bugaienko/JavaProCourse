package homework08;

import java.util.Iterator;

public class RubberList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public void addLast(T value) {
        if (first == null) { // Наша List пустой. Добавляем ноду в позицию first
            first = new Node<>(value, null, null);
        } else if (last == null) { // У нас есть только first. Добавляем ноду в позицию last
            last = new Node<>(value, first, null);
            first.next = last;
        } else { // У нас есть 2 и более элементов
            Node<T> temp = last;
            last = new Node<>(value, temp, null);
            temp.next = last;
        }
        size++;
    }

    public void addLast(T... values) {
        for (T value : values) {
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
        } else {
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
        }

        //Избыточные проверки при удалении элементов соседей first, last...
        //Вполне работает и "общий" подход при количестве элементов больше 2

//        else if (size == 3) { // We have just 3 elements und must delete index = 1
//            first.next = last;
//            last.previous = first;
//
//        } else if (deleteMe.previous == first) { //we remove the element inside the structure that IS the neighbor of FIRST
//            first.next = deleteMe.next;
//            deleteMe.next.previous = first;
//        } else if (deleteMe.next == last) { //we remove the element inside the structure that IS the neighbor of LAST
//            deleteMe.previous.next = last;
//            last.previous = deleteMe.previous;
//        }

        else { // we remove an element inside the structure that IS NOT last or first
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

    public boolean removeFirst() {
        if (first != null) {
            if (size == 2) {
                first = last;
                first.previous = null;
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

    public Node<T> getFirstNode() {
        return first;
    }

    public T getFirst() {
        return first.value;
    }

    public T getFirst(int index) {
        if (index < 0 || index >= size) return null;
        if (index <= size / 2) { // Если индекс в первой половине коллекции - начинаем с начала
            int count = 0;
            for (T el : this) {
                if (index == count) {
                    return el;
                }
                count++;
            }
        } else { // Если индекс во второй половине коллекции - начинаем с конца
            int count = size - 1;
            Node<T> item = last;
            do {
                if (count == index) {
                    return item.value;
                }
                count--;
                item = item.previous;
            } while (item != null);
        }
        return null;
    }

    public T getLast() {
        return last.value;
    }

    public void setFirst(T value) {
        first.value = value;
    }

    public void setLast(T value) {
        last.value = value;
    }

    public T set(int index, T value) {
        if (index < 0 || index >= size) return null;

        if (index <= size / 2) {
            Node<T> temp = first;
            int count = 0;
            T result;
            do {
                if (index == count) {
                    result = temp.value;
                    temp.value = value;
                    return result;
                }
                count++;
                temp = temp.next;
            } while (temp != null);
        } else {
            Node<T> temp = last;
            int count = size -1;
            T result;
            while (temp != null){
                if (index == count){
                    result = temp.value;
                    temp.value = value;
                    return result;
                }
                count--;
                temp = temp.previous;
            }
        }

        return null;
    }


    public Node<T> getLastNode() {
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

    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
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
