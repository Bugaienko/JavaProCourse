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
        Thread t4 = new Thread(() -> printer.print(doc3));


        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println();
        System.out.println("В очередь на печать отправленны страницы:");
        System.out.println(printer.getQuery());

    }
}
