package homework24;

/**
 * @author Sergii Bugaienko
 */


public class Lift {
    private int capacity;
    private LiftStatus status;
    private Object lock = new Object();
    private int counter;

    public Lift(int capacity) {
        this.capacity = capacity;
        this.status = LiftStatus.DOWN;
    }


    public void go(FirstFloor firstFloor, LastFloor lastFloor) {
        firstFloor.syncColl();
        lastFloor.syncColl();
        Thread thread1 = new Thread(() -> goUp(firstFloor, lastFloor));
        Thread thread2 = new Thread(() -> goDown(firstFloor, lastFloor));

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goDown(FirstFloor firstFloor, LastFloor lastFloor) {
        synchronized (lock) {
            while (!lastFloor.getQueue().isEmpty() || !firstFloor.getQueue().isEmpty()) {

                while (!status.equals(LiftStatus.UP)) {
//                    System.out.println("лифт внизу. Жду лифт");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (lastFloor.getQueue().isEmpty() && firstFloor.getQueue().isEmpty()) {
                    break;
                }
//                System.out.println("Перевозим людей вниз");
                lastFloor.goDown(capacity, firstFloor);
                counter++;
                status = LiftStatus.DOWN;
                lock.notify();
            }
        }
    }

    private void goUp(FirstFloor firstFloor, LastFloor lastFloor) {
        synchronized (lock) {
            while (!lastFloor.getQueue().isEmpty() || !firstFloor.getQueue().isEmpty()) {

                while (!status.equals(LiftStatus.DOWN)) {
//                    System.out.println("лифт вверху. Жду лифт");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (lastFloor.getQueue().isEmpty() && firstFloor.getQueue().isEmpty()) {
                    break;
                }

//                System.out.println("Перевозим людей вверх");
                firstFloor.goUp(capacity, lastFloor);
                counter++;
                status = LiftStatus.UP;
                lock.notify();
            }
        }
    }

    public int getCounter() {
        return counter;
    }
}
