package lesson03;

public class Cat extends Animal {
    public Cat(String name, String color, int age) {
        super(name, color, age);
        this.kind = "Cat";
    }

    @Override
    public void voice() {
        System.out.println("Meow!");
    }
}
