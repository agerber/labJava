package edu.uchicago.gerber.labjava.lec02.glab._2023.strings;

public class StringDemo {

    public static void main(String[] args) {

        // Instantiating a String using the new keyword
        String newString = new String("Adam");
        System.out.println(newString);

        // Instantiating a String as a literal
        String literalString = "Adam";
        System.out.println(literalString);

        // Comparing both strings using '=='
        if (newString == literalString) {
            System.out.println("The two strings are the same object in memory.");
        } else {
            System.out.println("The two strings are different objects in memory.");
        }

        // Comparing both strings using 'equals()'
        if (newString.equals(literalString)) {
            System.out.println("The contents of the two strings are the same.");
        } else {
            System.out.println("The contents of the two strings are different.");
        }
    }
}
