package edu.uchicago.gerber.labjava.lec02.statics;

public class MathDemo {

    public static void main(String[] args) {

        // Basic arithmetic
        double a = 25.5;
        double b = 5.7;

        System.out.println("a: " + a + ", b: " + b);

        // Maximum and Minimum
        System.out.println("Max of a and b: " + Math.max(a, b));
        System.out.println("Min of a and b: " + Math.min(a, b));

        // Square root
        System.out.println("Square root of a: " + Math.sqrt(a));

        // Power
        System.out.println("a raised to the power of b: " + Math.pow(a, b));

        // Absolute
        System.out.println("Absolute value of -a: " + Math.abs(-a));

        // Trigonometry
        System.out.println("Sin of a: " + Math.sin(Math.toRadians(a))); // Convert to radians first
        System.out.println("Cos of a: " + Math.cos(Math.toRadians(a)));

        // Rounding
        System.out.println("a rounded: " + Math.round(a));
        System.out.println("Floor of a: " + Math.floor(a));
        System.out.println("Ceiling of a: " + Math.ceil(a));


    }
}
