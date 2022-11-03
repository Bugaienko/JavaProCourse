package homework01;/*
 * Java Prof. Homework #01
 *
 * @author Sergey Bugaienko
 * @version 01.11.2022
 */


public class HomeWork01 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", "red", 4);

        cat.setName("Barsik New");
        cat.setColor("red");
        cat.setAge(4);

        cat.voice();
        System.out.println(cat);
    }
}
