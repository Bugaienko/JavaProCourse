package homework08;

/**
 * Java Pro. Homework #08
 *
 * @author Sergey Bugaenko
 * @version 24.11.22 - 25.11.22
 * @apiNote includes methods: addLast(value/values), addFirst, remove(value), removeAll(value), removeLast, removeFirst,
 * getFirst(by index), set(int index, T value)
 * implements Iterator;
 */
public class MainHomework08 {
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

    }
}
