package edu.uchicago.gerber.labjava.lec09.glab.generics.methods;

import java.awt.*;

public class PrintArrayDriver {
    // generic method printArray
    public static <E> void printArray(E[] inputArray) {
        // display array elements
        for (E element : inputArray)
            System.out.printf("%s ", element);

        System.out.println();
    }

    public static void main(String args[]) {
        // create arrays of Integer, Double and Character
        Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };
        Rectangle[] rectangles = {new Rectangle(1,2,3,4), new Rectangle(3,4,5,6)};

        System.out.println("Array integerArray contains:");
        printArray(integerArray); // pass an Integer array
        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray); // pass a Double array
        System.out.println("\nArray characterArray contains:");
        printArray(characterArray); // pass a Character array

        System.out.println("\nArray recrtangles contains:");
        printArray(rectangles); // pass a Character array
    } // end main
}