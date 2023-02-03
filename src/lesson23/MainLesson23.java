package lesson23;

/**
 * JavaPro. Lesson #23
 *
 * @author Sergii Bugaienko
 * @version 02.02.23
 */

public class MainLesson23 {
    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();
        CounterSync counterSync = new CounterSync();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counterSync.inc();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counterSync.dec();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(count.getValue());
    }
}
