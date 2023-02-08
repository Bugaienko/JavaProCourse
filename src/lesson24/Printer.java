package lesson24;

/**
 * @author Sergii Bugaienko
 */

public class Printer {

    private  final Object lock = new Object();
    public void print(Document doc) {
        synchronized (lock) {
            for (int p = 1; p <= doc.getCountPages(); p++) {
                System.out.printf("Doc: %s page %d printing \n", doc.getName(), p);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Doc: %s page %d printed \n", doc.getName(), p);
            }
        }
    }
}
