package edu.uchicago.gerber.labjava.lec02;

import java.util.Date;

public class FinalKeywordExample {

    public static void main(String[] args) {
        // Final primitive variable
        final int number = 10;
        // number = 20; // Error: cannot assign a value to a final variable

        // Final mutable object (array)
        final int[] array = {1, 2, 3};

        // Printing array before mutation
        System.out.println("Before mutation (array): " + java.util.Arrays.toString(array));

        // Mutating the array
        array[0] = 100;  // This is allowed even though the array is final

        // Printing array after mutation
        System.out.println("After mutation (array): " + java.util.Arrays.toString(array));

        // Final Date object
        final Date currentDate = new Date();

        // Printing Date before mutation
        System.out.println("Before mutation (Date): " + currentDate);

        // Mutating the Date object
        currentDate.setTime(currentDate.getTime() + 950_000_000_000L);  // Modifying the time

        // Printing Date after mutation
        System.out.println("After mutation (Date): " + currentDate);
    }
}
