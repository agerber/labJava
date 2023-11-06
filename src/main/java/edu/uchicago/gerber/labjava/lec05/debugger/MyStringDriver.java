package edu.uchicago.gerber.labjava.lec05.debugger;

import java.awt.*;
import java.util.Date;

public class MyStringDriver {

    public static void main(String[] args) {


        printMyArray(new Rectangle(1,2,3,4),78, 5.4, new Date(), 334, 34354, new Object(), new Date());


    }

    private static void printMyArray(Object... objects){

        for (int nC = 0; nC < objects.length; nC++) {
            printMe(objects[nC].getClass().getSimpleName());

        }
    }

    private static void printMe(String str){
        System.out.println(capitalizeRecursively(str));
    }


    private static String capitalize(String s) {
        return s.toUpperCase();
    }


    private static String capitalizeRecursively(String s) {
        // Base case: if the string is empty, return an empty string.
        if (s.isEmpty()) {
            return "";
        }
        //Recursive case

        // Capitalize the first character.
        char firstChar = Character.toUpperCase(s.charAt(0));
        // Recursively capitalize the rest of the string.
        String restOfString = capitalizeRecursively(s.substring(1));
        // Concatenate and return the result.
        return firstChar + restOfString;
    }


}
