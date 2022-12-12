package lesson13;

import java.util.Comparator;

public class ComparatorPersonAge implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
//        return (compAge != 0) ? compAge : p1.getName().compareTo(p2.getName());

    }
}
