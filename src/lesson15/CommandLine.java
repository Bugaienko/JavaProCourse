package lesson15;



import java.util.Scanner;

public class CommandLine {
    public void exec() {
        System.out.println("HashTable v.14.0.1");
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.addList(Init.init());
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        System.out.println("# Main menu");
        System.out.println("# swing; put Key Value; get Key; remove Key");
        while (flag) {
            System.out.println("Введите операцию");
            String choice = scanner.nextLine();
            flag = hashTable.readCommand(choice);
        }
    }
}
