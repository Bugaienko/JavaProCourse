package lesson23;

/**
 * @author Sergii Bugaienko
 */

public class BankAccount {
    private int money;

    public BankAccount(int money) {
        this.money = money;
    }

    public synchronized void pay(int amount, String name) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (money >= amount) {
            money -= amount;
            System.out.println(name + " gets " + amount + " : " + money);
        } else {
            System.out.println("Sorry, " + name + " not enough money: " + money);
        }
    }

    @Override
    public String toString() {
        return "BankAccount {" +
                "money=" + money +
                '}';
    }
}
