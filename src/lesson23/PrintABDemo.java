package lesson23;

/**
 * @author Sergii Bugaienko
 */

public class PrintABDemo {
    public static void main(String[] args) {
        PrintAB pab = new PrintAB();

        new Thread(pab::printA).start();
        new Thread(() -> pab.printB()).start();
        new Thread(() -> pab.printC()).start();


    }
}
