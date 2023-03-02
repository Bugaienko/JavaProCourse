package lesson31;

/**
 * @author Sergii Bugaienko
 */

public class Cat {
    public String name;
    public int age;
    private String account;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;


    }

    public void voice() {
        System.out.println("meow!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account='" + account + '\'' +
                '}';
    }
}
