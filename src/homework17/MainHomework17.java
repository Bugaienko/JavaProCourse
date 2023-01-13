package homework17;

import lesson12.DbInit;
import lesson12.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java Pro. Homework #17.
 *
 * @author Sergey Bugaenko
 * @version 13.01.23
 */
public class MainHomework17 {
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
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(e -> e.getId(), e -> e));
        //                .collect(Collectors.toMap(Employee::getId, e -> e));
        System.out.println(employeeMap);

        //преобразование в сложную Map
        Map<String, List<Employee>> positionMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition));
//        System.out.println(positionMap);

        createCompoundMap();
        repeatCodeFromArticle();
    }

    static void repeatCodeFromArticle() {

        //Найти сумму зарплат сотрудников с нечетным ID
        int s = 0;
        int sumSalary = (int) employees.stream()
                .filter(e -> e.getId() % 2 != 0)
                .map(Employee::getSalary)
                .reduce(s, Integer::sum);
        System.out.println(sumSalary);

        Collection<String> collection = Arrays.asList("Alpha","Highload", "High", "Load", "Highload");

        //посчитать кол-во элементов "High"
        System.out.println(collection.stream().
                filter(e -> e.equals("High"))
                .count()
        );
        //Получить значение первого элемента. Если нет - присвоить None
        System.out.println(
                collection.stream().findFirst().orElse("None")
        );
        //Получить элемент со значением "Load"
        System.out.println(
                collection.stream()
                        .filter("Load"::equals)
                        .findFirst()
                        .get()
        );

        //Получить значение последнего эл коллекции
        System.out.println(
                collection.stream()
                        .skip(collection.size() - 1)
                        .findFirst()
                        .orElse("0")
        );

//        Получить два элемента, начиная со второго эл колекции
        System.out.println(
                Arrays.toString(collection.stream()
                        .skip(1)
                        .limit(2)
                        .toArray())
        );

        //Получить минимальный элементы Кол
        System.out.println(
                collection.stream()
                        .min(String::compareTo)
                        .get()
        );

        //Получить отсортированный по убыванию список. Убрать дубликаты
        List<String> arrStr = collection.stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .distinct().collect(Collectors.toList());
        System.out.println(arrStr);

        System.out.println(employees);

        //Посчитать среднюю зарплату работников, возрастом старше 25 лет
        double avgSalary = employees.stream()
                .filter((e) -> e.getAge()>25)
                .mapToInt(Employee::getSalary)
                .average()
                .getAsDouble();
        System.out.println("avgSalary " + avgSalary);

        //Посчитать количество сотрудников, чья должность начинается на букву "А"
        Predicate<String> fn;
        fn = (str) -> {
            if (str.charAt(0) == 'A')
                return true;
            return false;
        };

        Stream<String> stream = employees.stream().map(Employee::getPosition);
        Stream<String> resStream = stream.filter(fn);
//        System.out.println(Arrays.toString(resStream.toArray()));
        System.out.println(resStream.count());

    }

    static void createCompoundMap() {
        Map<String, List<Employee>> posMap = new HashMap<>();
        List<Employee> tempList;
        Set<String> positionsAll = new HashSet<>();
        for (Employee employee : employees) {
            positionsAll.add(employee.getPosition());
        }

        for (String position : positionsAll) {
            tempList = new ArrayList<>();
            for (Employee employee : employees) {
                if (position.equals(employee.getPosition())) {
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
