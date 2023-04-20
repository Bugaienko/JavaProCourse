package printerABC;

import java.util.List;

/**
 * @author Sergii Bugaienko
 */

public class PrintABCDemo {
    public static void main(String[] args) throws InterruptedException {
        PrintABC pab = new PrintABC();

        Thread prA = new Thread(pab::printA);
        Thread prB = new Thread(() -> pab.printB());
        Thread prC =new Thread(() -> pab.printC());

        prA.start();
        prB.start();
        prC.start();

        prA.join();
        prB.join();
        prC.join();


        List<Character> result = PrintABC.getResult();
        System.out.println();
        result.stream().forEach(System.out::print);


    }
}
