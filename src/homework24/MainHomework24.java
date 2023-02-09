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
Изначально лифт находится на нижнем этаже

Задача. Перевезти всех людей с первого  на последний этаж и всех людей с последнего на первый.
При этом использовать минимальное количество перемещений лифта.
Посчитать кол-во совершенных лифтом движений.
*/

public class MainHomework24 {
    public static void main(String[] args) {
        FirstFloor firstFloor = new FirstFloor(2);
        LastFloor lastFloor = new LastFloor(2);
        Lift lift = new Lift(3);

        System.out.println("На первом этаже ждут лифта: " + firstFloor.getQueue());
        System.out.println("На верхнем этаже ждут лифта: " + lastFloor.getQueue());
        System.out.println("Запускаем лифт");
        System.out.println();

        lift.go(firstFloor, lastFloor);


        System.out.println("Прибывшие на первый: " + firstFloor.getArrived());
        System.out.println("Остались на верху: " + lastFloor.getQueue());
        System.out.println();

        System.out.println("Прибывшие на верхний этаж: " + lastFloor.getArrived());
        System.out.println("Остались внизу: " + firstFloor.getQueue());

        System.out.println();
        System.out.println("Лифт совершил: " + lift.getCounter() + " движений");
    }
}
