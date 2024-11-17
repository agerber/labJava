package edu.uchicago.gerber.labjava.lec06.recursion;

public class RecurseSimple {

    // Example usage:
    public static void main(String[] args) {
        String result = replaceCharRecursive("hello", 'l', 'x');
        System.out.println(result); // Output: "hexxo"
    }



    public static String replaceCharRecursive(String str, char oldChar, char newChar) {
        if (str.isEmpty()) { // Base case: if the string is empty, return an empty string
            return "";
        }
        char firstChar = (str.charAt(0) == oldChar) ? newChar : str.charAt(0); // Replace if necessary
        return firstChar + replaceCharRecursive(str.substring(1), oldChar, newChar); // Process the rest of the string
    }



    public static String replaceCharIterative(String str, char oldChar, char newChar) {
        char[] charArray = str.toCharArray(); // Convert string to character array
        for (int i = 0; i < charArray.length; i++) { // Loop through each character
            if (charArray[i] == oldChar) { // Check if it matches the target character
                charArray[i] = newChar; // Replace it with the new character
            }
        }
        return new String(charArray); // Convert back to string
    }

    public static int factorialRecursive(int n) {
        if (n == 0) { // Base Case
            return 1;
        }
        return n * factorialRecursive(n - 1); // Recursive Case
    }


    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }







}
