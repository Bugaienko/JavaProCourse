package lesson23;

/**
 * @author Sergii Bugaienko
 */

public class PrintAB {
    private final Object monitor = new Object();
    private volatile char currentChar = 'A';

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 30; i++) {
                    while (currentChar != 'A') {
                        monitor.wait();
                    }
                    System.out.print('A');
                    currentChar = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 30; i++) {
                    while (currentChar != 'B') {
                        monitor.wait();
                    }
                    System.out.print('B');
                    currentChar = 'C';
                    monitor.notifyAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 30; i++) {
                    while (currentChar != 'C') {
                        monitor.wait();
                    }
                    System.out.print('C');
                    currentChar = 'A';
                    monitor.notifyAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}