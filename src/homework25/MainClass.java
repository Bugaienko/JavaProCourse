package homework25;

import java.util.concurrent.CountDownLatch;

/**
 * @author Sergii Bugaienko
 */

public class MainClass {
    private static final int CARS_COUNT = 4;

    private static CountDownLatch START = new CountDownLatch(CARS_COUNT);
    private static CountDownLatch FINISH = new CountDownLatch(CARS_COUNT);

    public static CountDownLatch getSTART() {
        return START;
    }

    public static CountDownLatch getFINISH() {
        return FINISH;
    }

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(80), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        //TODO машины должны ждать старта -> Старт - по задвижке. (наверное)
        //TODO Туннель - семафор(2).
        //TODO Finish - тоже по задвижке.
        //TODO - победитель, когда задвижка уменьшилась на 1 (CARS_COUNT -1)
        while (START.getCount() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        while (FINISH.getCount() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("Победитель гонки! -> " + Car.getWinner());


    }


}
