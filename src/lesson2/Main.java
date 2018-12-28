package lesson2;

import lesson2.exceptions.*;

public class Main {

    public static void main(String[] args) {

        String[][] mass = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};

        // Test all cases
        for(int i = 0; i < 3; i++) {

            try {
                switch(i) {
                    case 0: /* Proper array and data */
                        System.out.printf("Result is %d\n", calculate2DArray(mass, 4, 4));
                        break;
                    case 1: /* Proper array, incorrect data */
                        mass[1][2] = "a";
                        System.out.printf("Result is %d\n", calculate2DArray(mass, 4, 4));
                        break;
                    case 2: /* Incorrect array size */
                        System.out.printf("Result is %d\n", calculate2DArray(new String[2][3], 4, 4));
                }
            }
            catch (MyArraySizeException e) {
                System.out.println(e);
            }
            catch (MyArrayDataException e){
                System.out.println(e);
            }
        }
    }

    static int calculate2DArray(String[][] arr, final int _row, final int _col)
            throws MyArraySizeException, MyArrayDataException {

        int summ = 0;

        // Check rows
        if(arr.length != _row) throw new MyArraySizeException("Incorrect rows value");

        // Check columns
        for(String[] s : arr) {
            if(s.length != _col) throw new MyArraySizeException("Incorrect cols value");
        }

        // Calculate summ
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