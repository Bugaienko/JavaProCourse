package lesson02;

public class Cat extends Animal {
    public Cat(String name, String color, int age) {
        super(name, color, age);
    }

    public Cat() {
        super();
    }

    @Override
    public void voice() {
        System.out.println("Meow!");
    }
}
