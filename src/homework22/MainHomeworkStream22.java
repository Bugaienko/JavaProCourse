package homework22;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * JavaPro. Homework #22
 *
 * @author Sergii Bugaienko
 * @version 31.01.23
 */

public class MainHomeworkStream22 {
    static final int SIZE = 10_000_000;
//        static final int SIZE = 6;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        float[] arr2;


        IntStream.range(0, arr.length).forEach(idx -> arr[idx] = 1);
        arr2 = Arrays.copyOf(arr, arr.length);

        firstMethodStream(arr);

        try {
            secondMethodStream(arr2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void firstMethodStream(float[] arr) {

        long startTime = System.currentTimeMillis();

        IntStream.range(0, arr.length).forEach(idx -> arr[idx] = (float) (1 * idx * Math.sin(0.2f + idx / 5) * Math.cos(0.2f + idx / 5) * Math.cos(0.4f + idx / 2)));

        System.out.println("One Thread time: " + (System.currentTimeMillis() - startTime));
    }

    public static void secondMethodStream(float[] arr) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        float[] leftArr = new float[arr.length / 2];
        float[] rightArr = new float[arr.length - leftArr.length];

        System.arraycopy(arr, 0, leftArr, 0, leftArr.length);
        System.arraycopy(arr, leftArr.length, rightArr, 0, rightArr.length);

        Thread thread1 = new Thread(() -> {
            IntStream.range(0, leftArr.length).forEach(idx -> leftArr[idx] = (float) (leftArr[idx] * idx * Math.sin(0.2f + idx / 5) * Math.cos(0.2f + idx / 5) * Math.cos(0.4f + idx / 2)));
        });
        Thread thread2 = new Thread(() -> {
            IntStream.range(0, rightArr.length).forEach(idx -> rightArr[idx] = (float) (rightArr[idx] * (idx + leftArr.length) * Math.sin(0.2f + (idx + leftArr.length) / 5) * Math.cos(0.2f + (idx + leftArr.length) / 5) * Math.cos(0.4f + (idx + leftArr.length) / 2)));
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
