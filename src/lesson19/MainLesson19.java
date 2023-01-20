package lesson19;

import java.io.*;

/**
 * Java Pro. Lesson #18.
 *
 * @author Sergey Bugaenko
 * @version 16.01.23
 */
public class MainLesson19 {
    public static void main(String[] args) {
        File file = new File("text.txt");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.length());

        byteArrayStreamDemo();
        fileOutputStreamDemo();
        fileInputStreamDemo();

        fileWriterDemo();
        fileReaderDemo();
    }

    static void fileWriterDemo() {
        try (FileWriter fw = new FileWriter("char_file.txt")) {
            fw.write("Hello dudes!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileReaderDemo() {
        String separator = File.separator;
        char[] buffer= new char[100];
        try (FileReader fr = new FileReader(separator + "JavaProCourse" + separator + "src" +separator + "lesson19" + separator + "testPath.txt")) {
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
        try (FileOutputStream fos = new FileOutputStream("byte_array.bin")) {
            fos.write(buffer2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileInputStreamDemo () {
        byte[] buffer = new byte[3];
        try (FileInputStream fis = new FileInputStream("byte_array.bin")) {
            fis.read(buffer);
        }catch (IOException e) {
            e.printStackTrace();
        }
        for (byte b : buffer) {
            System.out.println(b + " - " + (char) b);
        }
    }
}
