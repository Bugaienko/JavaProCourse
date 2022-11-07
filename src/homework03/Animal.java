package homework03;

import java.util.Arrays;

abstract public class Animal implements IAnimal {
    protected int runLimit;
    protected int swimLimit;
    protected String kind;
    static int counter = 0;
    static Animal[] animals = new Animal[0];

    public Animal() {
        counter++;
        animals = addAnimal(animals, this);
    }

    private Animal[] addAnimal(Animal[] animals, Animal animal) {
        Animal[] temp = new Animal[counter];
        temp = Arrays.copyOf(animals, counter);
        temp[counter - 1] = animal;
        return temp;
    }

    protected int getAnimalsCounter() {
        return counter;
    }

    public String swim(int distance) {
        if (distance > swimLimit) {
            return "Такое препятствие я не могу преодолеть";
        }
        return kind + " проплыла " + distance + "м.";
    }

    public String run(int distance) {
        if (distance > runLimit) {
            return "Такое препятствие я не могу преодолеть";
        }
        return kind + " пробежала " + distance + "м.";
    }

    protected void showAllAnimals() {
        for (Animal animal : animals) {
            System.out.printf(animal.toString() + "; ");
        }
        System.out.println();
    }
    protected Animal[] getAllAnimals() {
        return animals;
    }

    @Override
    public String toString() {
        return this.kind;
    }
}

