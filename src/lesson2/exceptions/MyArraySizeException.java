package lesson2.exceptions;

public class MyArraySizeException extends Exception {
    private String cause;

    public MyArraySizeException(String _cause){
        cause = _cause;
    }

    public String toString() {
        return cause;
    }
}