package lesson12;

import java.util.Scanner;

public class CommandLine {
    public void exec() {
        DataBase db = new DataBase(DbInit.init());
//        db.init(DbInit.init());
        Scanner scanner = new Scanner(System.in);
        System.out.println("CRUD app v.12.0");

        while (true) {
            System.out.println();
            System.out.println("List of command: c[reate], r[ead], u[pdate], d[elete], ");
            System.out.println("s[o]rt, s[earch menu], f[ind], [t]est, x[exit]");            System.out.println("# Main menu");
            String cmd = scanner.next();
            switch (cmd.toLowerCase().charAt(0)) {
                case 'c':
                    db.create();
                    break;
                case 'r':
                    db.read();
                    break;
                case 'u':
                    db.update();
                    break;
                case 'd':
                    db.delete();
                    break;
                case 'x':
                    System.out.println("Exit of command line.");
                    return;
                case 's':
                    db.search();
                    break;
                case 'f':
                    db.find();
                    break;
                case 'p':
                    db.positions();
                    break;
                case 'o':
                    db.sorting();
                    break;

                case 't':
                    TestMethodsSpeed.testRandomList();
                    break;
                default:
                    System.out.println("List of command: c[reate], r[ead], u[pdate], d[elete], ");
                    System.out.println("s[o]rt, s[earch menu], f[ind], [t]est, x[exit]");

            }
        }
    }
}
