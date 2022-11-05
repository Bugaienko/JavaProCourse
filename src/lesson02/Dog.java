package lesson02;

public class Dog extends Animal {
    public Dog(String name, String color, int age) {
        super(name, color, age);
        this.kind = "Dog";
    }

    @Override
    public void voice() {
        System.out.println("Gaf-gaf!");
    }
}
