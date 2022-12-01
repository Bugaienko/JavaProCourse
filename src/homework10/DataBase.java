package homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    private final List<Employee> employees;
    private final Scanner SCANNER = new Scanner(System.in);

    public DataBase() {
        this.employees = new ArrayList<>();
    }

    public void init(List<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void search() {
        System.out.println("Выборки по возрасту: (1)");
        System.out.println("Поиск по должности: (2)");
        System.out.println("Выборки по зп: (3)");
        System.out.println("Поиск по имени: (4)");
        System.out.println("Выход: (9)");
        int choose = SCANNER.nextInt();
        switch (choose) {
            case 1:
                searchByAge();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 9:
                System.out.println("Exit ended");
                return;
            default:
                System.out.println("возраст-> 1; Должность-> 2, ЗП-> 3, Имя-> 4, Выход-> 9");
        }
    }

    public void create() {
        System.out.println("create: ");
        String name = SCANNER.next();
        String position = SCANNER.next();
        int salary = SCANNER.nextInt();
        int age = SCANNER.nextInt();
        employees.add(new Employee(name, position, salary, age));
    }

    public void read() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void update() {
        System.out.println("find by id: ");
        int searchId = SCANNER.nextInt();
        Employee employee = findById(searchId);
        if (employee != null) {
            System.out.println("Update: (position, salary, age ");
            String position = SCANNER.next();
            int salary = SCANNER.nextInt();
            int age = SCANNER.nextInt();
            employee.update(position, salary, age);
            System.out.println("Updated " + employee);
        }
    }

    public void delete() {
        System.out.println("Delete by id: ");
        int searchId = SCANNER.nextInt();
        Employee employee = findById(searchId);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Deleted " + employee);
        }
    }


    private Employee findByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    private Employee findById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    private void searchByAge() {
        System.out.println("Min возраст: (1)");
        System.out.println("Max возраст: (2)");
        System.out.println("Between возраст (3)");
        System.out.println("Выход: (9)");
        int choose = SCANNER.nextInt();
        switch (choose) {
            case 1:
                searchMinAge();
                break;
            case 2:
                searchMaxAge();
                break;
            case 3:
                break;
            case 9:
                System.out.println("Exit by age search");
                return;
            default:
                System.out.println("Min-> 1; Max-> 2, Between-> 3,  Выход-> 9");
        }

    }

    private void searchMaxAge() {
        System.out.println("Введите максимальный возраст: ");
        int maxAge = SCANNER.nextInt();
        List<Employee> result = searchMaxAge(maxAge);
        System.out.println("Результат выборки maxAge= : " + maxAge);
        printListColumn(result);
    }

    private void searchMinAge() {
        System.out.println("Введите минимальный возраст: ");
        int minAge = SCANNER.nextInt();
        List<Employee> result = searchMinAge(minAge);
        System.out.println("Результат выборки minAge= : " + minAge);
        printListColumn(result);
    }

    public void printListColumn(List<Employee> employees) {
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }

    private List<Employee> searchMinAge(int minAge, List<Employee> employeeList) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getAge() >= minAge) {
                result.add(employee);
            }
        }
        return result;
    }

    private List<Employee> searchMinAge(int minAge) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                result.add(employee);
            }
        }
        return result;
    }

    private List<Employee> searchMaxAge(int maxAge) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() <= maxAge) {
                result.add(employee);
            }
        }
        return result;
    }

    private List<Employee> searchMaxAge(int maxAge, List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() <= maxAge) {
                result.add(employee);
            }
        }
        return result;
    }
}
