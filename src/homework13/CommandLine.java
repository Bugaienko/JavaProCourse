package homework13;

import java.util.Scanner;


public class CommandLine {
    public void exec() {
        DataBase db = new DataBase(DbInit.init());
        Scanner scanner = new Scanner(System.in);
        System.out.println("CRUD app v.13.sort");

        while (true) {
            printChoiceVariants();
            System.out.println("# Main menu");
            String cmd = scanner.next();
            ChoiceEnum choice2;
            try {
                choice2 = ChoiceEnum.getEnumByKey(cmd.trim().toLowerCase().substring(0, 1));
            } catch (IllegalArgumentException e) {
                System.out.println("No found2");
                choice2 = ChoiceEnum.READ;
            }
            try {
            switch (choice2) {
                case CREATE:
                    db.create();
                    break;
                case READ:
                    db.read();
                    break;
                case UPDATE:
                    db.update();
                    break;
                case DELETE:
                    db.delete();
                    break;
                case EXIT:
                    System.out.println("Exit of command line.");
                    return;
                case SEARCH:
                    db.search();
                    break;
                case FIND:
                    db.find();
                    break;
                case POSITION:
                    db.positions();
                    break;
                case SORT:
                    db.sorting();
                    break;
                case TEST:
                    TestMethodsSpeed.testRandomList();
                    break;
                default:
                    printChoiceVariants();
            }
        } catch (NullPointerException e){
                System.out.println(e);
            }
        }
    }

    private void printChoiceVariants() {
        System.out.println();
        System.out.print("List of command: ");
        for (ChoiceEnum choiceEnum : ChoiceEnum.values()) {
            System.out.print(choiceEnum.description + ", ");
        }
        System.out.println();
    }
}
