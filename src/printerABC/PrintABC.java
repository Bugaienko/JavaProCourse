package printerABC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergii Bugaienko
 */

public class PrintABC {
    private final Object monitor = new Object();
    private static List<Character> result = Collections.synchronizedList(new ArrayList<>());
    private volatile char currentChar = 'A';

    public static List<Character> getResult() {
        return result;
    }

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 15; i++) {
                    while (currentChar != 'A') {
                        monitor.wait();
                    }
                    result.add('A');
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
                for (int i = 0; i < 15; i++) {
                    while (currentChar != 'B') {
                        monitor.wait();
                    }
                    result.add('B');
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
                for (int i = 0; i < 15; i++) {
                    while (currentChar != 'C') {
                        monitor.wait();
                    }
                    result.add('C');
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