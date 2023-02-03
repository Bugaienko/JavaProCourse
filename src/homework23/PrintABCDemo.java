package homework23;

/**
 * @author Sergii Bugaienko
 */

public class PrintABCDemo {
    public static void main(String[] args) {
        PrintABC pab = new PrintABC();

        new Thread(pab::printA).start();
        new Thread(() -> pab.printB()).start();
        new Thread(() -> pab.printC()).start();


    }
}
