package homework18;

import java.util.Arrays;
import java.util.Random;

/**
 * Java Pro. Lesson #18.
 *
 * @author Sergey Bugaenko
 * @version 16.01.23
 */
public class MainHomework18 {
    static Random random = new Random();

    public static void main(String[] args) {
        String[][] matrix;
        matrix = arrayInit(4, 4);
        System.out.println(Arrays.deepToString(matrix));


        //Функция делает одно из значений матрицы не приводимым к типу int
        breakArray(matrix);


        System.out.println(Arrays.deepToString(matrix));
        try {
            System.out.println(arraySum(matrix));
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }




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
