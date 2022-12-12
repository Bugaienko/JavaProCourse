package homework13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * t
 * Задайте длину генерируемого списка сотрудников
 * 1500000
 * Задайте количество индексов для поиска
 * 12000
 * Тест HashMap vs ArrayList - поиск по индексу
 * ArrayList size: 1500000; Кол-во индексов для поиска: 12000
 * MAP time (ms): 6
 * ArrayList time (ms): 104248
 */


public class TestMethodsSpeed {
    private static List<Employee> testList;
    private static Map<Integer, Employee> map;

        public static void testRandomList() {
        int size = 1_500_000;
        size = DataUtil.getInt("Задайте длину генерируемого списка сотрудников");
        testList = DbInit.createBigRandomList(size);
        map = new HashMap<>();
        for (Employee employee : testList) {
            map.put(employee.getId(), employee);
        }
        int arrSize = 10_000;
        arrSize = DataUtil.getInt("Задайте количество индексов для поиска");
        int[] arr = new int[arrSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(size);
        }
        System.out.println("Тест HashMap vs ArrayList - поиск по индексу");
        System.out.println("ArrayList size: " + size + "; Кол-во индексов для поиска: " + arrSize);
        testByIdMapUsing(arr);
        testByIdEnumeration(arr);
    }


    private static void testByIdMapUsing(int[] arr) {
        //TODO - создать карту. Реализовать поиск
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            Employee temp = map.get(arr[i]);
        }
        System.out.println("MAP time (ms): " + (System.currentTimeMillis() - startTime));
    }

    private static void testByIdEnumeration(int[] arr) {
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < arr.length; j++) {
            for (Employee employee : testList) {
                if (employee.getId() == j) {
                    Employee temp = employee;
                    break;
                }
            }
        }
//        System.out.println();
        System.out.println("ArrayList time (ms): " + (System.currentTimeMillis() - startTime));
    }
}
