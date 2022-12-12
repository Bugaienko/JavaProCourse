package lesson13;

import java.util.Comparator;

public class ComparatorPersonName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
//        return  (nameComp != 0 ) ? nameComp : p1.getAge() - p2.getAge();
//        return nameComp;
    }
}
