package homework22;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Sergii Bugaienko
 */

public class MainHomeworkFor22 {
    static final int SIZE = 10_000_000;
//    static final int SIZE = 6;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] =1;

        }
        float[] arr2;
        arr2 = Arrays.copyOf(arr, arr.length);

        firstMethodFor(arr);
        try {
            secondMethodFor(arr2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void firstMethodFor(float[] arr) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }

        System.out.println("One Thread time: " + (System.currentTimeMillis() - startTime));
    }

    public static void secondMethodFor(float[] arr) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        float[] leftArr = new float[arr.length / 2];
        float[] rightArr = new float[arr.length - leftArr.length];

        System.arraycopy(arr, 0, leftArr, 0, leftArr.length);
        System.arraycopy(arr, leftArr.length, rightArr, 0, rightArr.length);

        Thread thread1 = new Thread(() -> {
            for (int idx = 0; idx < leftArr.length; idx++) {
                leftArr[idx] = (float) (leftArr[idx] * idx * Math.sin(0.2f + idx / 5) * Math.cos(0.2f + idx / 5) * Math.cos(0.4f + idx / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int idx = 0; idx < rightArr.length; idx++) {
                int idxR = idx + leftArr.length;
                rightArr[idx] = (float) (rightArr[idx] * idxR * Math.sin(0.2f + idxR / 5) * Math.cos(0.2f + idxR / 5) * Math.cos(0.4f + idxR / 2));

            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        float[] resultArr = new float[leftArr.length + rightArr.length];
        System.arraycopy(leftArr, 0, resultArr, 0, leftArr.length);
        System.arraycopy(rightArr, 0, resultArr, leftArr.length, rightArr.length);

        System.out.println("Two Thread time: " + (System.currentTimeMillis() - startTime));

//        System.out.println(Arrays.toString(resultArr));
    }
}
