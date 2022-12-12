package lesson13;

import java.util.*;

/**
 * Java Pro. Lesson #13.
 *
 * @author Sergey Bugaenko
 * @version 12.12.22
 *
 */

public class MainLesson13 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList("Hello", "Java", "Welcome", "Bye", "Programing"));
        System.out.println(stringList);
        Set<String> treeSet = new TreeSet<>(stringList);
        System.out.println(treeSet);

        // Implements Comparable<Person>
        List<Person> personList = new ArrayList<>();
        personList.addAll(Arrays.asList(
                new Person("Winston", 25),
                new Person("Winston", 23),
                new Person("Anna", 35),
                new Person("Boris", 28)));
        System.out.println(personList);

        Set<Person> personSet = new TreeSet<>(personList);
        System.out.println("personSet: " + personSet);

        //Implements Comparator;
        ComparatorPersonAge comparatorPersonAge = new ComparatorPersonAge();
        ComparatorPersonName comparatorPersonName = new ComparatorPersonName();
        Set<Person> ageSortedSet = new TreeSet<>(comparatorPersonAge);
        Set<Person> nameSortedSet = new TreeSet<>(comparatorPersonName);
        ageSortedSet.addAll(personList);
        nameSortedSet.addAll(personList);
        System.out.println("ageSortedSet" + ageSortedSet);
        System.out.println("nameSortedSet" + nameSortedSet);

        personList.sort(comparatorPersonName);
        System.out.println("personList Name" + personList);

        //Concat 2 and more Comparators
        Comparator comparatorFull = new ComparatorPersonName().thenComparing(new ComparatorPersonAge());
        personList.sort(comparatorFull);
        System.out.println("personList Full" + personList);
    }

}
