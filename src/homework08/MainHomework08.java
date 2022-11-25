package homework08;

/**
 * Java Pro. Homework #08
 *
 * @author Sergey Bugaenko
 * @version 24.11.22 - 25.11.22
 * @apiNote includes methods: addLast(value/values), addFirst, remove(value), removeAll(value), removeLast, removeFirst,
 * getFirst(by index)
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
        System.out.println(rl.getFirst(1));


    }
}
