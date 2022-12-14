package homework03;

import java.util.Arrays;

abstract public class Animal implements IAnimal {
    protected int runLimit;
    protected int swimLimit;
    protected String kind;
    private static int counter = 0;
    private static Animal[] animals = new Animal[0];

    public Animal(int runLimit) {
        this.runLimit = runLimit;
        counter++;
        animals = addAnimal(animals, this);
    }

    private Animal[] addAnimal(Animal[] animals, Animal animal) {
        Animal[] temp = new Animal[counter];
        temp = Arrays.copyOf(animals, counter);
        temp[counter - 1] = animal;
        return temp;
    }

    public static int getAnimalsCounter() {
        return counter;
    }

    public String swim(int distance) {
        if (distance > swimLimit) {
            return "This obstacle I cannot overcome.";
        }
        return kind + " swam " + distance + "m.";
    }

    public String run(int distance) {
        if (distance > runLimit) {
            return "This obstacle I cannot overcome.";
        }
        return kind + " ran " + distance + "m.";
    }

    public void showAllAnimals() {
        for (Animal animal : animals) {
            System.out.printf(animal.toString() + "; ");
        }
        System.out.println();
    }
    public Animal[] getAllAnimals() {
        return animals;
    }

    @Override
    public String toString() {
        return kind + " {" +
                "runLimit=" + runLimit +
                ", swimLimit=" + swimLimit +
                "}";

    }
}


