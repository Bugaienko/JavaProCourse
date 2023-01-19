package homework18;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException(int testSize, int correctSize) {
        super("Incorrect size! Current size: " + testSize + "; Must be: " + correctSize);
    }
}
