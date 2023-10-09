package edu.uchicago.gerber.labjava.lec02.glab._2023.strings;

public class StringImmutabilityDemo {

    public static void main(String[] args) {
        String original = "Hello";
        String modified = original.concat(", World!");

        System.out.println("Original String: " + original);
        System.out.println("Modified String: " + modified);

        // Prove that 'original' was not modified by comparing the references
        if (original == modified) {
            System.out.println("Both strings reference the same memory location.");
        } else {
            System.out.println("Both strings reference different memory locations.");
        }

        // Further demonstrating immutability
        modified.replace(",", "!!!");  // This operation creates a new string, but we're not storing the reference anywhere
        System.out.println("Modified after replace (without storing): " + modified);  // So, the original 'modified' string remains unchanged

        // Storing the reference to the newly created string after the replace operation
        modified = modified.replace(",", "!!!");
        System.out.println("Modified after replace (with storing): " + modified);
    }
}
