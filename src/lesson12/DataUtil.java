package lesson12;

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

    public static void printListColumn(List<Employee> employees) {
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
        PositionEnum positionEnum = getPosition();
        System.out.println(positionEnum);
        return new Employee(name, position, salary, age);
    }

    public static Employee createEmployeePart(String prompt) {
        System.out.println(prompt);
        String position = SCANNER.next();
        int salary = SCANNER.nextInt();
        int age = SCANNER.nextInt();
        PositionEnum positionEnum = getPosition();
        System.out.println(positionEnum);
        return new Employee(null, position, salary, age);
    }

    private static PositionEnum getPosition() {
        System.out.println("Get Position");
        String value = SCANNER.next();
        try {
            PositionEnum position = PositionEnum.valueOf(value.toUpperCase());
            return position;
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Position not found");
            return null;
        }
    }
}
