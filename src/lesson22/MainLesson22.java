package lesson22;

/**
 * JavaPro Lesson #22
 * @author Sergii Bugaienko
 */

public class MainLesson22 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(100);
        System.out.println(System.currentTimeMillis());

        //Implements Runnable
//        Thread thread1 = new Thread(new RunnableImpl(), "Belka");
//        Thread thread2 = new Thread(new RunnableImpl(), "Strelka");
//        thread1.start();
//        thread2.start();

        //Extends Thread
        Thread thread3 = new ThreadExt();
        Thread thread4 = new ThreadExt();

        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.printf("Thread #%d: %d %n", Thread.currentThread().getId(), i );
            }
        });

//        thread3.start();
//        thread4.start();
        thread5.start();
        thread5.join(); // говорит основному потоку ждать завершения дочернего

        System.out.println("END Main");

    }
}
