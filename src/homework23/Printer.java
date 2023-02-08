package homework23;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sergii Bugaienko
 */

public class Printer {
    private final Object locker = new Object();
    private volatile List<String> query = new ArrayList<>();
    private long currentThreadId;
    List<Long> ids = new ArrayList<>();


    //TODO разобраться с локером

    public void print(List<String> list) {


        synchronized (this) {
            ids.add(Thread.currentThread().getId());
            currentThreadId = ids.stream().mapToLong(v -> v).min().orElse(0);
        }
        printSync(list, Thread.currentThread().getId());

    }

    public void printSync(List<String> list, long id) {

        System.out.println("sync " + currentThreadId + " " + Thread.currentThread().getId() + " " + id +  " " + list);

        if (currentThreadId == id) {
            addStr(list);
        } else {
            addWait(list);
        }
    }

    private void addStr(List<String> list) {
        synchronized (locker) {

            query.addAll(list);
            currentThreadId++;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            locker.notifyAll();
        }
    }

    private void addWait(List<String> list) {
        synchronized (locker) {
            try {
                if (Thread.currentThread().getId() != currentThreadId) {
                    locker.wait();
                    query.addAll(list);
                    currentThreadId++;
                } else {
                    addWait2(list);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            locker.notify();
        }
    }

    private void addWait2(List<String> list) {
        synchronized (locker) {
            try {
                query.addAll(list);
                currentThreadId++;
                locker.notify();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getQuery() {
        return query;
    }
}
