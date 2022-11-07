package lesson03;

abstract public class Animal implements IAnimal {
    protected String name;
    protected String color;
    protected int age;
    protected String kind;
    private boolean test;


    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    private void test() {
        System.out.println("Test");
    }

    @Override
    public String toString() {
        return "" + kind + " { " +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                " }";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
