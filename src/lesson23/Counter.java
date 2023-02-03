package lesson23;

/**
 * @author Sergii Bugaienko
 */

public class Counter {
    private int value = 0;


    public void inc() {
        value++;
    }

    public void dec () {
        value--;
    }

    public int getValue() {
        return value;
    }
}
