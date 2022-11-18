package homework06;

/**
 * Java Pro. Homework #06
 *
 * @author Sergey Bugaenko
 * @version 17.11.22 -
 */

public class MainHomework06 {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        Apple app1 = new Apple(1.5);
        Apple app2 = new Apple(1.8);
        Apple app3 = new Apple(1.7);
        Apple app4 = new Apple(1.2);

        box1.add(app1);
        box1.add(app2, app3, app4);
        System.out.println("box1-> " + box1);
        Box<Apple> box2 = box1.removeToOtherBox();
        Box<Apple> box5 = box2.copyBox();
        box5.add(app4);

        System.out.println("box1-> " + box1);
        System.out.println("box2-> " + box2);
        System.out.println("box5-> " + box5);

        Orange or1 = new Orange(2);
        Orange or2 = new Orange(1.9);
        Orange or3 = new Orange(1.8);
        Orange or4 = new Orange(1.7);
        Orange or5 = new Orange();

        Box<Orange> box3 = new Box<>();
        box3.add(or1, or2, or3, or4);
        Box<Orange> box4 = box3.copyBox();
        box3.replaceFruit(or4, or5);
        System.out.println("box3-> " + box3);

        Box<Orange> box6 = new Box<>(or4, or3, or2);

        System.out.println("box4-> " + box4);
        System.out.println("box6-> " + box6);

        System.out.println();
        System.out.println("box2.compare(box4): " + box2.compare(box4));
        System.out.println("box5.compare(box4): " + box5.compare(box4));


    }
}

/*Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с
той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
Можно сравнивать коробки с яблоками и апельсинами;
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
Не забываем про метод добавления фрукта в коробку.

 */

