package edu.uchicago.gerber.labjava.lec02.strings;

public class StringPoolDemo {

    public static void main(String[] args) {
        // Using string literals. These are likely placed in a string pool.
        String s1 = "Hello";
        String s2 = "Hello";

        // Using new keyword. Forces new object instances
        String s3 = new String("Hello");
        String s4 = new String("Hello");

        // Comparing references. When you use the double-equals operator on references, it checks
        //to see if the memory addresses of the two references are the same (e.g. pointing to the same object)
        System.out.println("s1 == s2: " + (s1 == s2)); // This will be true because both refer to the same object in the string pool.
        System.out.println("s3 == s4: " + (s3 == s4)); // This will be false because both refer to different objects in the heap.

        // Comparing string content
        System.out.println("s1 equals s3: " + s1.equals(s3)); // This will be true because the content of the strings is the same.
    }
}
