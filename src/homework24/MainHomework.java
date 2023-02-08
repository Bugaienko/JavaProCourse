package homework24;

/**
 * JavaPro. Homework #24
 *
 * @author Sergii Bugaienko
 * @version 08.02.23
 */

/*
Моделирование работы лифта.
Есть первый этаж. На нем стоит n количество людей.
Есть верхний этаж. На нем тоже стоит какое-то количество людей.
Есть лифт, который умеет подниматься с первого на последний этаж
и умеет спускаться с последнего на первый.
Максимальная грузоподъемность лифта 3 человека.

Задача. Перевезти всех людей с первого  на последний этаж и всех людей с последнего на первый.
При этом использовать минимальное количество перемещений лифта.
Посчитать кол-во совершенных лифтом движений.
*/

public class MainHomework {
    public static void main(String[] args) {
        FirstFloor firstFloor = new FirstFloor(15);
        LastFloor lastFloor = new LastFloor(12);
        Lift lift = new Lift(3);

        lift.go(firstFloor, lastFloor);

        System.out.println("Прибывшие на первый: " + firstFloor.getArrived());
        System.out.println("Остались на первом: " + lastFloor.getQueue());
    }
}
