package lesson11;

import java.util.List;
import java.util.Scanner;

public class DataUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.println(prompt);
        String str = SCANNER.next();
        return str;
    }

    public static int getInt(String prompt) {
        System.out.println(prompt);
        int num = SCANNER.nextInt();
        return num;
    }

    public static void printListColumn(List<lesson11.Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static Employee createEmployee(String prompt) {
        System.out.println(prompt);
        String name = SCANNER.next();
        String position = SCANNER.next();
        int salary = SCANNER.nextInt();
        int age = SCANNER.nextInt();
        return new Employee(name, position, salary, age);
    }

    public static Employee createEmployeePart(String prompt) {
        System.out.println(prompt);
        String position = SCANNER.next();
        int salary = SCANNER.nextInt();
        int age = SCANNER.nextInt();
        return new Employee(null, position, salary, age);
    }
}
