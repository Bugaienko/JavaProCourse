package homework06;


/**
 * Java Pro. Lesson #06
 *
 * @author Sergey Bugaenko
 * @version 17.11.22 -
 */

public class MainLesson06 {
    public static void main(String[] args) {
        RubberArray<String> raStr = new RubberArray<>();
        raStr.addAll("aa", "bb", "cc", "dd", "ee", "ff");
        raStr.remove("dd");
        raStr.remove(0);
        System.out.println(raStr);
        RubberArray<Integer> raInt = new RubberArray<>();
        raInt.addAll(1, 2, 3, 4, 5);
        raInt.remove((Integer) 2);
        System.out.println("raStr.contains('cc'): " + raStr.contains("cc"));
        System.out.println("raStr.indexOf('cc'): " + raStr.indexOf("cc"));
        System.out.println("raStr.lastIndexOf('cc'): " + raStr.lastIndexOf("cc"));

        System.out.println();
        System.out.println(raInt);

//        RubberArray raMix = new RubberArray();
//        raMix.addAll(1.1, "abc", true, 4);
//        System.out.println(raMix);
//        double f = (double) raMix.get(0);
//        System.out.println(f*2);

        SimpleBox<Integer> ints1 = new SimpleBox<>(2);
        SimpleBox<Integer> ints2 = new SimpleBox<>(3);
//        if (ints1.getObject() instanceof Integer && ints2.getObject() instanceof Integer) {
        int sum = ints1.getObject() + ints2.getObject();
        System.out.println(sum);




//        }

    }
}
