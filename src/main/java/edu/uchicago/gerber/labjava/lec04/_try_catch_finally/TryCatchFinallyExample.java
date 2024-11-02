package edu.uchicago.gerber.labjava.lec04._try_catch_finally;

public class TryCatchFinallyExample {
    public static void main(String[] args) {

        int result = 0;

        try {
            // Attempt to divide
            result = 818 / 0;  // this line will throw exception
            System.out.println("Result: " + result);
            System.out.println("Persist result to database");
            System.out.println("Close connection to database from try");
        } catch (ArithmeticException e) {
            // Handle division by zero error
            System.out.println("Error: Cannot divide by zero.");

            //This is your opportunity to close any open resources like
            // database connections or streams to remote servers.
        } finally {
            // This block always executes
            System.out.println("Finally block always executed.");
            System.out.println("Close connection to database from finally");

        }

        System.out.println("Exiting program");
    }
}
