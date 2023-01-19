package homework18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Java Pro. Lesson #18.
 *
 * @author Sergey Bugaenko
 * @version 16.01.23
 */
public class MainHomework18 {
    static Random random = new Random();
    private final static List<String[][]> listMatrix = new ArrayList<>();

    public static void main(String[] args) {
        String[][] matrix;
        int correctSize;

        correctSize = 4;
        matrix = arrayInit(4, 4);
        listMatrix.add(matrix);
//        System.out.println(Arrays.deepToString(matrix));

        String[][] matrix3 = arrayInit(4, 3);
        listMatrix.add(matrix3);

        String[][] matrix4 = {{"1", "2", "3", "4"}, {"5", "6", "7"},
                {"8", "9", "10", "11"}, {"12", "13", "14", "15"}};
        String[][] matrix2 = arrayInit(4, 4);
        //Функция делает одно из значений матрицы не приводимым к типу int
        breakArray(matrix2);
        listMatrix.add(matrix2);


        listMatrix.add(matrix4);

        for (String[][] current : listMatrix) {
            try {
                System.out.println(Arrays.deepToString(current));
                System.out.println("Sum = " + sumMatrix(current, correctSize));
            } catch (MyArrayDataException | MyArraySizeException e) {
                e.printStackTrace();
            }
        }


//        System.out.println(Arrays.deepToString(matrix));
//        try {
//            System.out.println(arraySum(matrix));
//        } catch (MyArrayDataException e) {
//            e.printStackTrace();
//        }

    }

    //TODO сдклать отдельно валидацию размера
    //переписать исключения  - конструктор

    private static int sumMatrix(String[][] matrix, int size) throws MyArraySizeException, MyArrayDataException {
        testSize(matrix, size);
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return sum;
    }

    private static void testSize(String[][] matrix, int size) throws MyArraySizeException {
        int x = matrix.length;
//        System.out.println(Arrays.deepToString(matrix));
        if (x != size) {
            throw new MyArraySizeException(x, size);
        }
        for (int i = 0; i < x; i++) {
            if (matrix[i].length != size) {
                throw new MyArraySizeException(matrix[i].length, size);
            }
        }
        System.out.println("Size OK");
    }

    private static String[][] arrayInit(int a, int b) {
        String[][] temp = new String[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                temp[i][j] = "" + random.nextInt(100);
            }
        }
        return temp;
    }

    private static String[][] breakArray(String[][] matrix) {
        int x = random.nextInt(matrix.length);
        int y = random.nextInt(matrix[x].length);
        System.out.println(x + "|" + y);
        matrix[x][y] = "Surprise";
        return matrix;
    }

    public static int arraySum(String[][] matrix) throws MyArrayDataException {
        int sum = 0;
        int x = matrix.length;
        int y = matrix[x - 1].length;
//        System.out.println(x);
//        System.out.println(y);
        if (x != 4 || y != 4) {
            throw new MyArraySizeException("Matrix size incorrect");
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                try {
                    int temp = Integer.parseInt(matrix[i][j]);
//                    System.out.print(temp + " ");
                    sum += temp;
                } catch (NumberFormatException e) {
                    String mes = "Failed to convert cell: " + "r:" + i + " c:" + j;
                    throw new MyArrayDataException(mes);
                }
            }

        }

        return sum;
    }
}
