package homework03;

import java.util.Arrays;

abstract public class Animal implements IAnimal {
    protected int runLimit;
    protected int swimLimit;
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
    public abstract String toString();
}


