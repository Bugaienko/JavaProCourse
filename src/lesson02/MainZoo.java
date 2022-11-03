package lesson02;

/*
 * Java Pro. Lesson/Homework #02
 *
 * @author Sergey Bugaenko
 * @version 03.11.22 -
 */

public class MainZoo {
    public static void main(String[] args) {
        Cat cat = new Cat("Murzik", "red", 3);
        Dog dog = new Dog("Scharik", "black", 5);

        Cat emptyCat = new Cat();

        cat.voice();
        dog.voice();

        System.out.println(cat);
        System.out.println(dog);

        System.out.println(add(2, 3));
        System.out.println(add(-5.3, 3.5));
        System.out.println(add("-123", "456"));
    }

    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b){
        return a + b;
    }

    static String add(String a, String b){
        return a.concat(b);
    }
}

/*
* Задание: Сделать класс Animal абстрактным
 */