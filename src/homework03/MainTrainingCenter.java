package homework03;

/*
 * Java Pro. Homework #03
 *
 * @author Sergey Bugaenko
 * @version 07.11.22 -
 */

public class MainTrainingCenter {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Cat cat = new Cat();
        Dog dog2 = new Dog();

        System.out.println(dog1.run(100));
        System.out.println(dog1.swim(8));
        System.out.println(dog2.swim(12));
        System.out.println(cat.swim(1));
        System.out.println(cat.run(200));

        System.out.println();

        System.out.println("Total Animals Created: " + dog2.getAnimalsCounter());
        cat.showAllAnimals();

        for (Animal animal: cat.getAllAnimals()) {
            System.out.println(animal);
        }

        System.out.println("The second way to determine the total number of created animals: " + cat.getAllAnimals().length);

    }
}

/*
Создать классы Cat и Dog с наследованием от класса Animal.
Все животные могут бежать run() и плыть swim(). В качестве параметра каждому методу передается длина препятствия.
Результатом выполнения действия будет печать в консоль.
(Например, dog.run(150) -> 'Собака пробежала 150 м.' или 'Собака не может пробежать 150 м.');
У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.). Для этого необходимо использовать соответствующие поля, которые инициализируются через конструктор.
Кота и собаку необходимо добавить в массив и использовать цикл.
* Добавить подсчет созданных котов, собак и животных (используя статическое поле).

 */