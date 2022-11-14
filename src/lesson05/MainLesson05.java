package lesson05;

/**
 * Java Pro. Lesson #05
 *
 * @author Sergey Bugaenko
 * @version 14.11.22 -
 */

public class MainLesson05 {
    public static void main(String[] args) {
        RubberArray rb = new RubberArray();
        rb.add(12);
        rb.addAll(3, 5);
        System.out.println(rb.size());
        rb.add(10);
        rb.remove(3);
        System.out.println(rb);
        System.out.println("rb[1] = " +rb.get(1));
        System.out.println(rb.contains(5));
        rb.add(99);
        System.out.println(rb.contains(999));
        System.out.println(rb.remove(Integer.valueOf(99)));
        System.out.println(rb);
    }
}
