package lesson12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Java Pro. Lesson #12.
 *
 * @author Sergey Bugaenko
 * @version 08.12.22
 *
 *
 *
 */
public class MainLesson12 {
    public static void main(String[] args) {
//        new CommandLine().exec();
        List<Integer> integers = Arrays.asList(5, 8, 3, 12, 4, 0);
        System.out.println(integers);
        Collections.sort(integers);
        System.out.println(integers);

        List<String> strings = Arrays.asList("c", "ab", "aa", "zzz", "ghh", "bbb", "ddd");
        System.out.println(strings);
        Collections.sort(strings);
        System.out.println(strings);

        
    }
}
