package edu.uchicago.gerber.labjava.lec02;

import java.util.Date;

public class StringImmutableExample {

    public static void main(String[] args) {
        // Date object (mutable)
        Date date = new Date();
        Date sameDate = date;  // Reference points to the same object

        System.out.println("Before mutation (Date):");
        System.out.println(date == sameDate);  // Should be true

        // Mutating Date object
        date.setTime(date.getTime() + 1000000000L);
        System.out.println("After mutation (Date):");
        System.out.println(date == sameDate);  // Still true, same reference

        // String object (immutable)
        String text = "Hello";
        String sameText = text;  // Reference points to the same object

        System.out.println("Before 'mutation' (String):");
        System.out.println(text == sameText);  // Should be true

        // Attempting to 'mutate' the String by concatenating
        text = text.concat(", World!");

        System.out.println("After 'mutation' (String):");
        System.out.println(text == sameText);  // False, new String object created
    }
}
