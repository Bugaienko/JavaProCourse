package lesson02;

public abstract class Animal {
    protected String name;
    protected String color;
    protected int age;
    protected String kind;

    public abstract void voice();

    public Animal() {
    }

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return ""+kind+" { " +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                " }";
    }

}
