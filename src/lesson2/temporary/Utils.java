package lesson2.temporary;

import lesson2.exceptions.MyArrayDataException;
import lesson2.exceptions.MyArraySizeException;

public class Utils {


    static void check2DArray(String[][] arr, int row, int col) throws MyArraySizeException {
        if(arr.length != row) throw new MyArraySizeException("Incorrect rows value");

        for(String[] s : arr) {
            if(s.length != col) throw new MyArraySizeException("Incorrect cols value");
        }
    }

    static int calculate2DArray(String[][] arr) throws MyArrayDataException {

        int summ = 0;

        for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[row].length; col++){
                try {
                    summ += Integer.parseInt(arr[row][col]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(row, col);
                }
            }
        }

        return summ;
    }
}
