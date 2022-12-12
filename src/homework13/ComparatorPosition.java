package homework13;

import java.util.Comparator;

public class ComparatorPosition implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        System.out.println(e1.getPosition() + "vs " + e2.getPosition() );
        return e1.getPosition().compareTo(e2.getPosition());
    }
}
