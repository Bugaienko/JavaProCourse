package Homework09;

import java.util.Iterator;
import java.util.Random;

/**
 * Java Pro. Homework #09
 *
 * @author Sergey Bugaenko
 * @version 28.11.22 - 01.12.22
 *
 */
public class MainHomework09 {
    public static void main(String[] args) {
        RubberList<Integer> rl = new RubberList();
        rl.addLast(6);
        rl.addFirst(0);
        rl.addLast(7, 8, 9, 9, 8, 9);
        System.out.println(rl + " s:" + rl.size());
        System.out.println("f:" + rl.getFirstNode() + " l:" + rl.getLastNode());

        for (Integer val : rl) {
            System.out.print(val + "; ");
        }
        System.out.println();

        rl.remove(9);
        System.out.println("after remove(9): " + rl + " s:" + rl.size());
        rl.removeAll(9);
        System.out.println("after removeAll(9): " + rl + " s:" + rl.size());
        rl.removeLast();
        rl.removeFirst();
        System.out.println(rl + " s:" + rl.size());
        System.out.println("f:" + rl.getFirstNode() + " l:" + rl.getLastNode());

        // get value by index
        System.out.println("rl.getFirst(): " + rl.getFirst());
        System.out.println("rl.getFirst(1): " + rl.getFirst(1));
        Integer val = rl.getFirst(1);
        System.out.println("rl.set(1, val + 100): (old value) " + rl.set(1, val + 100));
        System.out.println(rl);

        RubberList<String> rls = new RubberList<>();
        rls.addLast("One", "Two", "Three");
        System.out.println(rls);
        rls.remove("Two");
        System.out.println(rls + "  f:" + rls.getFirstNode() + " l:" + rls.getLastNode());
        rls.addLast("For", "Five");
        System.out.println(rls);
        System.out.println(rls.getFirst(0));
        rls.add(3, "Insert value");
        System.out.println(rls + "  f:" + rls.getFirstNode() + " l:" + rls.getLastNode());

        rl.addLast(15, 9, 18, 6, 11);
        Iterator<Integer> iterator = rl.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value > 10) {
//                System.out.println(value);
                iterator.remove();
            }
            System.out.print (value + " ");
        }
        System.out.println();

        System.out.println(rl);
        RubberList<Integer> stack = new RubberList<>();
        for (int i = 0; i < 7; i++){
            stack.add(new Random().nextInt(15));
        }
        System.out.println("Stack: " + stack);
        for (int i = 0; i < 7; i++){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        System.out.println("Stack: " + stack);

    }
}
