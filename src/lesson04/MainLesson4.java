package lesson04;

import java.util.*;

/**
 * Java Pro. Lesson #04
 *
 * @author Sergey Bugaenko
 * @version 10.11.22 -
 */

public class MainLesson4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BB");
//        System.out.println(list);
        list.add("C");
        list.add("DDDD");
//        System.out.println(list);
        list.remove("BB");
//        System.out.println(list);
//        System.out.println(list.get(2));
        list.add(2, "BB");
        list.add(2, "BB");
        list.add(2, "BB");
        System.out.println(list);

        Set<String> set = new HashSet<>(list);
        System.out.println(set);

        Map<String, String> map = new HashMap<>();
        map.put("Prague", "CZ");
        map.put("Berlin", "DE");
        System.out.println(map);
        System.out.println(map.get("Berlin"));
        System.out.println(map.get("B"));

    }
}
