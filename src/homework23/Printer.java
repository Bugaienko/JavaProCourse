package homework23;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Bugaienko
 */

public class Printer {
    private final Object locker = new Object();
    private volatile List<String> query = new ArrayList<>();
    private volatile static int counter;

    public synchronized void print(List<String> list) {
        if (counter == 0) {
            try {
                printMain(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (counter == 1) {
            try {
                print2(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (counter == 2) {
            try {
                print3(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else  if (counter > 2 ) {
            System.out.println("Ошибка! очередь переполнена! ");
        }

    }

    public void printMain(List<String> list) throws InterruptedException {
        synchronized (locker) {
            for (String str : list) {
                query.add(str);
//                System.out.print(str + ",M ");
            }
            counter++;
            System.out.println();
            locker.notify();
        }
    }

    public void print2(List<String> list) throws InterruptedException {
        synchronized (locker) {
            for (String str : list) {
                while (counter != 1) {
                    locker.wait();
                }
                query.add(str);
//                System.out.print(str + ",2 ");
            }
            counter++;
//            System.out.println("2 done");
            locker.notifyAll();
        }
    }

    public void print3(List<String> list) throws InterruptedException {
        synchronized (locker) {

            for (String str : list) {
                while (counter != 2) {
                    locker.wait();
                }
                query.add(str);
//                System.out.print(str + ",3 ");
            }
            counter++;
//            System.out.println("3 done");
            locker.notifyAll();
        }
    }

    public List<String> getQuery() {
        return query;
    }
}
