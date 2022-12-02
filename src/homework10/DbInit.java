package homework10;

import java.util.ArrayList;
import java.util.List;

public class DbInit {
    public static List<Employee> init() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Boss", 2000, 45));
        employees.add(new Employee("Gina", "Assistant", 950, 21));
        employees.add(new Employee("Svetlana", "CafeMaker", 930, 20));
        employees.add(new Employee("Johanna", "Front-end prog", 1700, 25));
        employees.add(new Employee("Tomas", "Back-end prog", 1800, 28));
        employees.add(new Employee("Tomara", "Back-end prog", 1700, 23));
        return employees;

    }
}
