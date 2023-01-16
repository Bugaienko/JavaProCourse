package lesson18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java Pro. Lesson #18.
 *
 * @author Sergey Bugaenko
 * @version 16.01.23
 */
public class MainLesson18 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int c;
        if (b == 0) {
            throw new DivisionByZeroException();
        }

        try {
            c = div(a, b);
        } catch (ArithmeticException e) {
//            throw new DivisionByZeroException();
            e.printStackTrace();
            System.out.println(e);
        }

        System.out.println("Continue program");
        fileWriteRead();
    }

    static int div(int a, int b) {
        return a / b;
    }

    //передаем ответственность за обработку исключения вызывающему методу
    static void fileWrite() throws IOException {
        FileWriter fileWriter = new FileWriter("text.txt");
        fileWriter.write("Hello\nfrom\nmethod");
        fileWriter.close();
    }
    public static void fileWriteRead() {

        //writing
        try {
            FileWriter file = new FileWriter("text.txt");
            file.write("Hello\nJava");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

//        try {
//            fileWrite();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //reading
        try {
            FileReader file = new FileReader("text.txt");
            int b;
            while ((b = file.read()) != -1){
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
