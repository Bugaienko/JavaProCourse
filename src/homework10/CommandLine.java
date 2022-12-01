package homework10;

import java.util.Scanner;

public class CommandLine {
    public void exec() {
        DataBase db = new DataBase();
        db.init(DbInit.init());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("# ");
            String cmd = scanner.next();
            switch (cmd) {
                case "c":
                    db.create();
                    break;
                case "r":
                    db.read();
                    break;
                case "u":
                    db.update();
                    break;
                case "d":
                    db.delete();
                    break;
                case "x":
                    System.out.println("Exit of command line.");
                    return;
                case "s":
                    db.search();
                    break;
                default:
                    System.out.println("List of command: c[reate], r[ead], u[pdate], d[elete], x[exit]");

            }
        }
    }
}
