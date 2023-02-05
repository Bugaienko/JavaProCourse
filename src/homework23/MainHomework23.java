package homework23;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaPro. Homework #23
 *
 * @author Sergii Bugaienko
 * @version 03.02.23
 */

public class MainHomework23 {
    public static void main(String[] args) throws InterruptedException {
        List<String> doc1 = new ArrayList<>();
        List<String> doc2 = new ArrayList<>();
        List<String> doc3 = new ArrayList<>();


        for (int i = 1; i < 5; i++) {
            doc1.add("Doc1:Page" + i);
            doc2.add("Doc2:Page" + i);
            doc3.add("Doc3:Page" + i);
        }


        Printer printer = new Printer();
        Thread t1 = new Thread(() -> printer.print(doc1));
        Thread t2 = new Thread(() -> printer.print(doc2));
        Thread t3 = new Thread(() -> printer.print(doc3));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println();
        System.out.println("В очередь на печать отправленны страницы: (v.1)");
        System.out.println(printer.getQuery());


        // Version2 with ArrayBlockingQueue

        PrinterQueue printer2 = new PrinterQueue();
        Thread t5 = new Thread(() -> printer2.print(doc1));
        Thread t6 = new Thread(() -> printer2.print(doc2));
        Thread t7 = new Thread(() -> printer2.print(doc3));
        Thread output = new Thread(() -> printer2.output());

        t5.start();
        t6.start();
        t7.start();
        output.start();

        t5.join();
        t6.join();
        t7.join();
        output.join();

        System.out.println();
        System.out.println("В очередь на печать отправленны страницы: (v.2)");
        System.out.println(printer2.getOutput());

    }
}
