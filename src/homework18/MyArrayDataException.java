package homework18;

public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException(String s) {
        super(s);
    }
    public MyArrayDataException(int col, int row) {
        super("Failed to convert cell: " + "r:" + col + " c:" + row);
    }


}
