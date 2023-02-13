package homework25;

import java.util.concurrent.Semaphore;

import static homework25.MainClass.getCarsCount;

/**
 * @author Sergii Bugaienko
 */

public class Tunnel extends Stage {
    private static final Semaphore SEMAPHORE = new Semaphore(getCarsCount() / 2, true);

    public Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + this.length + " метров";
    }

    @Override
    public String toString() {
        return "{" + description + '}';
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                SEMAPHORE.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(1000L * length / c.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);

                SEMAPHORE.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

