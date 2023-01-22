package homework19;

import java.io.*;
import java.util.Scanner;

/**
 * Java Pro. Homework #19.
 *
 * @author Sergey Bugaenko
 * @version 22.01.23
 */
public class MainHomework19 {
    private static final String separator = File.separator;
    private static final String mainPath = separator + "JavaProCourse" + separator + "src" + separator + "homework19" + separator;

    public static void main(String[] args) {
        File file = new File(mainPath + "text.txt");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.length());

        byteArrayStreamDemo();
        fileOutputStreamDemo();
        fileInputStreamDemo();

        fileWriterDemo();
        fileReaderDemo();

        readFileScanner();

    }

    static void readFileScanner() {
        File file = new File(mainPath + "hw19.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void fileWriterDemo() {
        try (FileWriter fw = new FileWriter(mainPath + "char_file.txt")) {
            fw.write("Hello dudes!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileReaderDemo() {
        char[] buffer = new char[100];
        try (FileReader fr = new FileReader(mainPath + "char_file.txt")) {
            fr.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(buffer));
    }

    static void byteArrayStreamDemo() {
        byte[] buffer = {66, 67, 68};
        ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer);
        int x;
        while ((x = byteStream.read()) != -1) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void fileOutputStreamDemo() {
        byte[] buffer = {48, 49, 50};
        byte[] buffer2 = {0x30, 0x31, 0x32};
        try (FileOutputStream fos = new FileOutputStream(mainPath+ "byte_array.bin")) {
            fos.write(buffer2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileInputStreamDemo() {
        byte[] buffer = new byte[3];
        try (FileInputStream fis = new FileInputStream(mainPath + "byte_array.bin")) {
            fis.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (byte b : buffer) {
            System.out.println(b + " - " + (char) b);
        }
    }
}
