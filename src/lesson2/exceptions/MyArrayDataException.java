package lesson2.exceptions;

public class MyArrayDataException extends Exception {
    private int row, col;

    public MyArrayDataException(int _row, int _col) {
        row = _row;
        col = _col;
    }

    public String toString() {
        return "\nInconsistent data type in cell [" + row + "][" + "[" + col + "]";
    }
}