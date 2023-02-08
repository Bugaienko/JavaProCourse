package lesson24;

/**
 * @author Sergii Bugaienko
 */

public class PrinterDemo {
    public static void main(String[] args) {


        Document d1 = new Document("Doc1", 5);
        Document d2 = new Document("Doc2", 7);
        Document d3 = new Document("Doc3", 8);

        Printer printer = new Printer();

        Thread thread1 = new Thread(() -> printer.print(d1));
        Thread thread2 = new Thread(() -> printer.print(d2));
        Thread thread3 = new Thread(() -> printer.print(d3));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
