package edu.uchicago.gerber.labjava.lec02.glab._2023.strings;

public class EscapeSequencesDemo {

    public static void main(String[] args) {
        // Newline escape sequence
        System.out.println("Hello\nWorld");

        // Tab escape sequence
        System.out.println("Hello\tWorld");

        // Backspace escape sequence
        System.out.println("Hello\bWorld");

        // Carriage return escape sequence
        System.out.println("Hello\rWorld");

        // Single quote escape sequence
        System.out.println("It\'s a sunny day.");

        // Double quote escape sequence
        System.out.println("\"Java\" is a popular programming language.");

        // Backslash escape sequence
        System.out.println("C:\\Program Files\\Java");

        // Unicode escape sequence (for example: U+2665 is a heart symbol)
        System.out.println("I love Java \u2665");
    }
}
