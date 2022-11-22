package lesson07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Java Pro. Lesson #07
 *
 * @author Sergey Bugaenko
 * @version 21.11.22 -
 */
public class MainLesson07 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(); // Integer - обертка/декоратор для int
        int[] arr = {4, 8, 3, 9, 1};
//        System.out.println(arr);
//        System.out.println(Arrays.toString(arr)); // декоратор/обертка над массивом

        numbers.addAll(Arrays.asList(4, 6, 2, 9, 1));
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
        for (Integer item : numbers) {
            System.out.print(item + " ");
        }
        System.out.println();
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();

        RubberArray<Integer> ra = new RubberArray<>();
        ra.addAll(9, 3, 5, 7, 0);

        for (Integer item : ra) {
            System.out.print(item + " ");
        }
        System.out.println();

        Iterator<Integer> iterator = ra.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        RubberArray<Integer> ra2 = new RubberArray<>();
        for (Integer integer: ra2){
            System.out.println(integer);
        }
    }
}
