package edu.uchicago.gerber.labjava.lec02.glab.strings;

public class StringMethodsDemo {

    public static void main(String[] args) {
        String example = "   Hello, World!   ";

        // Using trim() to remove leading and trailing white spaces
        System.out.println("Original String: '" + example + "'");
        String trimmed = example.trim();
        System.out.println("Trimmed String: '" + trimmed + "'");

        // Using charAt() to get a character at a specific index
        char charAt5 = trimmed.charAt(5);
        System.out.println("Character at index 5: " + charAt5);

        // Using indexOf() to find the position of a character or substring
        int indexOfComma = trimmed.indexOf(",");
        System.out.println("Index of comma: " + indexOfComma);

        // Using length() to get the length of the string
        int length = trimmed.length();
        System.out.println("Length of trimmed string: " + length);

        // Using substring() to get a part of the string
        String substring = trimmed.substring(0, 5);
        System.out.println("Substring from index 0 to 5: " + substring);

        // Using toLowerCase() and toUpperCase() for case conversion
        System.out.println("Lowercase: " + trimmed.toLowerCase());
        System.out.println("Uppercase: " + trimmed.toUpperCase());

        // Using replace() to replace characters or substrings
        String replaced = trimmed.replace("World", "Java");
        System.out.println("Replaced 'World' with 'Java': " + replaced);

        // Using split() to split the string into an array based on a delimiter
        String[] words = trimmed.split(" ");
        System.out.print("Words in the string: ");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
