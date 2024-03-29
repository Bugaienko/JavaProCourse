package homework25;

import static homework25.MainClass.getFINISH;
import static homework25.MainClass.getSTART;


/**
 * @author Sergii Bugaienko
 */

public class Car implements Runnable {
    private static int carNumbers;
    private Race race;
    private int speed;
    private String name;
    private static Car winner;


    public static Car getWinner() {
        return winner;
    }

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        carNumbers++;
        this.name = "Участник #" + carNumbers;

    }

    @Override
    public String toString() {
        return "" + name + " " + race +
                ", speed=" + speed + '}';
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов! (spd: " + this.speed + ")");
            getSTART().countDown();
            getSTART().await();
            Thread.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        getFINISH().countDown();
        if (getFINISH().getCount() == carNumbers - 1) {
            winner = this;
            System.out.println(getName() + " WIN!");
        }
    }
}

