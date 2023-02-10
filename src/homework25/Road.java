package homework25;

import static homework25.MainClass.getFINISH;

/**
 * @author Sergii Bugaienko
 */

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
//            System.out.println("sleep " + (  length * 1000L / c.getSpeed()));
            Thread.sleep(length * 1000L / c.getSpeed());
            System.out.println(c.getName() + " закончил этап: " + description);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "{" + description + '}';
    }
}

