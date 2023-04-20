package printerABC;

/**
 * @author Sergii Bugaienko
 */

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class TestThreads extends Thread {
    private ReentrantLock lock;
    private static Integer counter = 3;
    private int thread_id;
    private char letter;
    int repeats;

    public TestThreads(ReentrantLock lock, int repeats, int thread_id, char letter) {
        this.lock = lock;
        this.repeats = repeats;
        this.thread_id = thread_id;
        this.letter = letter;
    }

    public void run() {
        try {

            for (int i = 0; i < repeats; i++) {
                while (thread_id != (counter % 3)) {
                    sleep(50);
                }
                lock.lock();

                System.out.print(letter);
                counter++;
                lock.unlock();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock locker = new ReentrantLock();

        TestThreads thread1 = new TestThreads(locker, 9, 0, 'A');
        TestThreads thread2 = new TestThreads(locker, 9, 1, 'B');
        TestThreads thread3 = new TestThreads(locker, 9, 2, 'C');
        thread1.start();
        thread2.start();
        thread3.start();
    }
}