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
        System.out.println("# Search menu");
        System.out.println("Выборки по возрасту: (1)");
        System.out.println("Поиск по должности: (2)");
        System.out.println("Выборки по зп: (3)");
        System.out.println("Поиск по имени: (4)");
        System.out.println("Поиск по нескольким условиям: (5)");
        System.out.println("Выход: (9)");
        int choose = SCANNER.nextInt();
        switch (choose) {
            case 1:
                searchByAge();
                break;
            case 2:
                searchByPosition();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                searchMulti();
                break;
            case 9:
                System.out.println("Exit ended");
                return;
            default:
                System.out.println("возраст-> 1; Должность-> 2, ЗП-> 3, Имя-> 4, Multi-> 5; Выход-> 9");
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

    // MultiSearch section
    private List<Employee> searchMulti() {
        System.out.println("# Search combo menu");
        System.out.println("Должность + возраст: (1)");
        System.out.println("Должность + зп: (2)");
        System.out.println("Имя + возраст: (3)");
        System.out.println("Имя + зп: (4)");
        System.out.println("Выход: (9)");
        int choose = SCANNER.nextInt();
        switch (choose) {
            case 1:
                return searchByAge(searchByPosition());
            case 2:

                break;
            case 3:

                break;
            case 4:
                break;
            case 9:
                System.out.println("Exit by multi search");
                return null;
            default:
                System.out.println("pos + age-> 1; pos + salary-> 2, name + age-> 3,  name + salary-> 3, Выход-> 9");
        }
        return null;
    }

    // Search by Age section
    private List<Employee> searchByAge() {
//    private void searchByAge() {
        System.out.println("# Search by age menu");
        System.out.println("Min возраст: (1)");
        System.out.println("Max возраст: (2)");
        System.out.println("Between возраст (3)");
        System.out.println("Выход: (9)");
        int choose = SCANNER.nextInt();
        switch (choose) {
            case 1:
                return searchMinAge();

            case 2:
                return searchMaxAge();

            case 3:
                return searchIntervalAge();

            case 9:
                System.out.println("Exit by age search");
                return null;
            default:
                System.out.println("Min-> 1; Max-> 2, Between-> 3,  Выход-> 9");
        }
        return null;
    }

    private List<Employee> searchByAge(List<Employee> employees) {
//    private void searchByAge() {
        System.out.println("# Search by age menu");
        System.out.println("Min возраст: (1)");
        System.out.println("Max возраст: (2)");
        System.out.println("Between возраст (3)");
        System.out.println("Выход: (9)");
        int choose = SCANNER.nextInt();
        switch (choose) {
            case 1:
                return searchMinAge(employees);

            case 2:
                return searchMaxAge(employees);

            case 3:
                return searchIntervalAge(employees);

            case 9:
                System.out.println("Exit by age search");
                return null;
            default:
                System.out.println("Min-> 1; Max-> 2, Between-> 3,  Выход-> 9");
        }
        return null;
    }

    private List<Employee> searchIntervalAge() {
        System.out.println("Введите минимальный и максимальный возраст: ");
        int minAge = SCANNER.nextInt();
        int maxAge = SCANNER.nextInt();
        List<Employee> result = searchIntervalAge(minAge, maxAge, employees);
        System.out.println("Результат выборки intervalAge {" + minAge + " -> " + maxAge + "}");
        printListColumn(result);
        return result;
    }

    private List<Employee> searchIntervalAge(List<Employee> employees) {
        System.out.println("Введите минимальный и максимальный возраст: ");
        int minAge = SCANNER.nextInt();
        int maxAge = SCANNER.nextInt();
        List<Employee> result = searchIntervalAge(minAge, maxAge, employees);
        System.out.println("Результат выборки intervalAge {" + minAge + " -> " + maxAge + "}");
        printListColumn(result);
        return result;
    }

    private List<Employee> searchIntervalAge(int minAge, int maxAge, List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge && employee.getAge() <= maxAge) {
                result.add(employee);
            }
        }
        return result;
    }

//    private List<Employee> searchIntervalAge(int minAge, int maxAge, List<Employee> employees) {
//        List<Employee> result = new ArrayList<>();
//        for (Employee employee : employees) {
//            if (employee.getAge() >= minAge && employee.getAge() <= maxAge) {
//                result.add(employee);
//            }
//        }
//        return result;
//    }

    private List<Employee> searchMaxAge() {
        System.out.println("Введите максимальный возраст: ");
        int maxAge = SCANNER.nextInt();
        List<Employee> result = searchMaxAge(maxAge);
        System.out.println("Результат выборки maxAge= " + maxAge);
        printListColumn(result);
        return result;
    }
    private List<Employee> searchMaxAge(List<Employee> employees) {
        System.out.println("Введите максимальный возраст: ");
        int maxAge = SCANNER.nextInt();
        List<Employee> result = searchMaxAge(maxAge, employees);
        System.out.println("Результат выборки maxAge= " + maxAge);
        printListColumn(result);
        return result;
    }

    private List<Employee> searchMinAge() {
        System.out.println("Введите минимальный возраст: ");
        int minAge = SCANNER.nextInt();
        List<Employee> result = searchMinAge(minAge, employees);
        System.out.println("Результат выборки minAge= " + minAge);
        printListColumn(result);
        return result;
    }
    private List<Employee> searchMinAge(List<Employee> employees) {
        System.out.println("Введите минимальный возраст: ");
        int minAge = SCANNER.nextInt();
        List<Employee> result = searchMinAge(minAge, employees);
        System.out.println("Результат выборки minAge= " + minAge);
        printListColumn(result);
        return result;
    }

    public void printListColumn(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private List<Employee> searchMinAge(int minAge, List<Employee> employeeList) {
        System.out.println("Search min + employeeList");
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

    // Search by Position section
    private List<Employee> searchByPosition() {
        System.out.println("# Search by position menu");
        System.out.println("Search by 1 word: (1)");
        System.out.println("Search by 2 word: (2)");
        System.out.println("Выход: (9)");
        int choose = SCANNER.nextInt();
        switch (choose) {
            case 1:
                return searchPositionContains();
            case 2:
                return searchPositionContainsTwoWords();
            case 9:
                System.out.println("Exit by position search");
                return null;
            default:
                System.out.println("Position-> 1; Exit-> 9");
        }
        return null;
    }

    private List<Employee> searchPositionContains() {
        System.out.print("Введите позицию для поиска: ");
        String positionSearch = SCANNER.next();
        List<Employee> result = searchPositionContains(positionSearch, employees);
        System.out.println("Результат выборки по позиции " + positionSearch);
        printListColumn(result);
        return result;
    }
    private List<Employee> searchPositionContains(List<Employee> employees) {
        System.out.print("Введите позицию для поиска: ");
        String positionSearch = SCANNER.next();
        List<Employee> result = searchPositionContains(positionSearch, employees);
        System.out.println("Результат выборки по позиции " + positionSearch);
        printListColumn(result);
        return result;
    }

    private List<Employee> searchPositionContainsTwoWords() {
        System.out.print("Введите два слова для поиска в позиции через пробел: ");
        String positionSearch1 = SCANNER.next();
        String positionSearch2 = SCANNER.next();
        List<Employee> result = searchPositionContains(positionSearch1, positionSearch2, employees);
        System.out.println("Результат выборки по позиции " + positionSearch1 + " + " + positionSearch2);
        printListColumn(result);
        return result;
    }

    private List<Employee> searchPositionContainsTwoWords(List<Employee> employees) {
        System.out.print("Введите два слова для поиска в позиции через пробел: ");
        String positionSearch1 = SCANNER.next();
        String positionSearch2 = SCANNER.next();
        List<Employee> result = searchPositionContains(positionSearch1, positionSearch2, employees);
        System.out.println("Результат выборки по позиции " + positionSearch1 + " + " + positionSearch2);
        printListColumn(result);
        return result;
    }

    private List<Employee> searchPositionContains(String posSearch, List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getPosition().toLowerCase().contains(posSearch.toLowerCase().trim())) {
//                System.out.println(employee + " содержит " + posSearch);
                result.add(employee);
            }
        }
        return result;
    }
    private List<Employee> searchPositionContains(String posSearch1, String posSearch2, List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getPosition().toLowerCase().contains(posSearch1.toLowerCase().trim()) && employee.getPosition().toLowerCase().contains(posSearch2.toLowerCase().trim())) {
//                System.out.println(employee + " содержит " + posSearch);
                result.add(employee);
            }
        }
        return result;
    }
}
