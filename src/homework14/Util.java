package homework14;

import java.util.Arrays;

public class Util {
    public static boolean readCommand(String command) {
        String[] tokens = command.split(" ");
        switch (tokens[0].toLowerCase()){
            case "put":
                break;
            case "get":
                get(tokens);
                break;
            case "remove":
                break;
            case "exit":
                System.out.println("exit");
                return false;
            default:
                System.out.println("Def");
                return false;
        }
        return true;
    }

    private static void get(String[] tokens){
        System.out.println(Arrays.toString(tokens));
    }
}
