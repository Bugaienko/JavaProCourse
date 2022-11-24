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
        rl.add(12);
//        rl.remove(12);
        rl.add(4);
//        rl.add(5);
//        rl.add(6);
//        rl.firstAdd(0);
        System.out.println(rl + " s:" + rl.size() );
//        rl.removeLast();
//        rl.remove(0);
//        rl.remove(6);
        rl.remove(4);
        rl.add(8);
        rl.removeLast();
        rl.add(6);
        rl.add(11);
        System.out.println(rl + " s:" + rl.size() );
        rl.remove(6);
        System.out.println(rl + " s:" + rl.size() );
    }
}
