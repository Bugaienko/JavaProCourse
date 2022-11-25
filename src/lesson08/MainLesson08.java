package lesson08;

/**
 * Java Pro. Lesson #08
 *
 * @author Sergey Bugaenko
 * @version 24.11.22 -
 */

public class MainLesson08 {
    public static void main(String[] args) {

        RubberList<Integer> rl = new RubberList<>();
        rl.addLast(9);
//        rl.addFirst(1);
        rl.addFirst(1);
        rl.addLast(10);
        rl.addLast(10);
        rl.addLast(10);
        System.out.println(rl + " s:" + rl.size());
        rl.remove(10);
        System.out.println("f:" + rl.getFirst() + " l:" + rl.getLast());

        System.out.println(rl + " s:" + rl.size());
        rl.removeAll(10);
        System.out.println(rl + " s:" + rl.size());
        rl.addFirst(0);
        rl.addLast(11);

        System.out.println("f:" + rl.getFirst() + " l:" + rl.getLast());
        System.out.println(rl + " s:" + rl.size());

        for (Integer val : rl){
            System.out.print(val + " ");
        }
        System.out.println();


    }
}
