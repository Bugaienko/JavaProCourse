package homework04;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Pro. Homework #04
 *
 * @author Sergey Bugaenko
 * @version 10.11.22 -
 */

public class MainTrainingCenter {
    private static List<IBarrier> barriers = new ArrayList<>();

    public static List<IBarrier> getBarriers() {
        return barriers;
    }

    public static void main(String[] args) {


        ICompetitor human1 = new Human(100, 3);
        ICompetitor human2 = new Human(200, 12);
        ICompetitor robot1 = new Robot(250, 30);
        ICompetitor cat1 = new Cat(150, 30);

        IBarrier barrier1 = new Track(50);
        IBarrier barrier2 = new Track(150);
        IBarrier barrier3 = new Track(200);
        IBarrier wall1 = new Wall(8);
        IBarrier wall2 = new Wall(10);
        IBarrier wall3 = new Wall(25);

        barriers.add(barrier1);
        barriers.add(barrier2);
        barriers.add(barrier3);
        barriers.add(wall1);
        barriers.add(wall2);
        barriers.add(wall3);

        System.out.println("All competitors list: " + Competitor.getList());
        System.out.println("All barriers list: " + getBarriers());
        System.out.println();


        for (ICompetitor competitor : Competitor.getList()) {
            for (IBarrier barrier : getBarriers()) {
                if (competitor.move(barrier) < 0) {
                    System.out.println("Competitor dropped out! Next!");
                    break;
                }
            }
            System.out.println();
        }
    }
}




/*
Создайте три класса Human, Cat, Robot, которые не наследуются от одного класса.
Эти классы должны уметь бегать run() и прыгать jump() (методы просто выводят информацию о действии в консоль).
Создайте два класса: Track (беговая дорожка) и Wall (стена), при прохождении через которые,
участники должны выполнять соответствующие действия (бежать или прыгать),
результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
Уровень 2. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */
