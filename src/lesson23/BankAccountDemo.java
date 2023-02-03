package lesson23;

/**
 * @author Sergii Bugaienko
 */

public class BankAccountDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount ba = new BankAccount(100);
        System.out.println(ba);
        Thread t1 = new Thread(() -> ba.pay(30, "Alla"));
        Thread t2 = new Thread(() -> ba.pay(35, "Bob"));
        Thread t3 = new Thread(() -> ba.pay(33, "Cela"));
        Thread t4 = new Thread(() -> ba.pay(25, "Debra"));

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();

        System.out.println(ba);
    }
}
