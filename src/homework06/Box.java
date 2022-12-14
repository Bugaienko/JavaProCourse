package homework06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    public Box() {}

    public Box(T fruit) {
        fruits.add(fruit);
    }

    public Box(T... fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void add(T... fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
//        for (T fruit : fruits) {
//            add(fruit);
//        }
    }

    public double getWeight() {
        double temp = 0;
        for (T fruit : fruits) {
            temp += fruit.getWeight();
        }
        return temp;
    }

    public void replaceFruit(T fruit1, T fruit2) {
        fruits.set(fruits.indexOf(fruit1), fruit2);
    }

    public void remove(T fruit) {
        fruits.remove(fruit);
    }

    public Box<T> copyBox() {
        Box<T> newBox = new Box<>();
        for (T fruit : fruits) {
            newBox.add(fruit);
        }
        return newBox;
    }

    public Box<T> removeToOtherBox() {
        Box<T> newBox = copyBox();
        fruits.clear();
        return newBox;
    }

    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }

    public List<T> getFruits() {
        return fruits;
    }


    @Override
    public String toString() {
        return "Box {" +
                fruits +
                " W= " + getWeight() +
                '}';
    }
}
