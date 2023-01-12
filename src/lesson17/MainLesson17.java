package lesson17;

import homework12.DbInit;
import homework12.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java Pro. Lesson #17.
 *
 * @author Sergey Bugaenko
 * @version 12.01.23
 */
public class MainLesson17 {
    static List<Employee> employees;

    public static void main(String[] args) {
        employees = DbInit.init();

        //фильтрация списка
        List<Employee> assistants = employees.stream()
                .filter(e -> e.getPosition().equals("Assistant")).collect(Collectors.toList());
        System.out.println(assistants);

        //преобразование списка
        Set<String> positions = employees.stream()
                .map(employee -> employee.getPosition())
//                .distinct()
                .sorted()
                .collect(Collectors.toSet());

        System.out.println(positions);

        //преобразование List в Map
        Map<Integer, Employee> employeeMap = employees.stream()
//                .collect(Collectors.toMap(e -> e.getId(), e -> e));
                .collect(Collectors.toMap(Employee::getId, e -> e));
        System.out.println(employeeMap);

        //преобразование в сложную Map
        Map<String, List<Employee>> positionMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition));
//        System.out.println(positionMap);

        createCompoundMap();

    }
    static void createCompoundMap() {
        Map<String, List<Employee>> posMap = new HashMap<>();
        List<Employee> tempList;
        Set<String> positionsAll = new HashSet<>();
        for (Employee employee: employees){
            positionsAll.add(employee.getPosition());
        }

        for (String position: positionsAll){
            tempList = new ArrayList<>();
            for (Employee employee: employees){
                if (position.equals(employee.getPosition())){
                    tempList.add(employee);
                }
            }
            posMap.put(position, tempList);
        }

        System.out.println(posMap);
    }

    static void firstMeeting() {

        long counter = 0;
        for (Employee employee : employees) {
            if (employee.getPosition().equals("Assistant")) {
                counter++;
            }
        }
        System.out.println("counter " + counter);
        counter = 0;
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getPosition().equals("Assistant")) {
                counter++;
            }
        }
        System.out.println("counter " + counter);

        counter = employees.stream()
                .filter(emp -> emp.getPosition().equals("Assistant"))
                .count();

        System.out.println(counter);

        int sum = Stream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
        int sum2 = Stream.of(1, 2, 3, 4).reduce((a, b) -> a + b).get();
        System.out.println(sum + " " + sum2);
    }
}
