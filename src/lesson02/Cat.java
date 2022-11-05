package lesson02;

public class Cat extends Animal {
    public Cat(String name, String color, int age) {
        super(name, color, age);
        this.kind = "Cat";
    }
    public Cat() {
        super();
    }
    @Override
    public void voice() {
        System.out.println("Meow!");
    }
}
