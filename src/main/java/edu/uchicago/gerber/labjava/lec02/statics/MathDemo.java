package edu.uchicago.gerber.labjava.lec02.statics;

public class MathDemo {

    public static void main(String[] args) {

        // Basic arithmetic
        double dubA = 25.5;
        double dubB = 5.7;

        System.out.println("dubA: " + dubA + ", dubB: " + dubB);

        // Maximum and Minimum
        System.out.println("Max of dubA and dubB: " + Math.max(dubA, dubB));
        System.out.println("Min of dubA and dubB: " + Math.min(dubA, dubB));

        // Square root
        System.out.println("Square root of dubA: " + Math.sqrt(dubA));

        // Power
        System.out.println("dubA raised to the power of dubB: " + Math.pow(dubA, dubB));

        // Absolute
        System.out.println("Absolute value of -dubA: " + Math.abs(-dubA));

        // Trigonometry
        System.out.println("Sin of dubA: " + Math.sin(Math.toRadians(dubA))); // Convert to radians first
        System.out.println("Cos of dubA: " + Math.cos(Math.toRadians(dubA)));

        // Rounding
        System.out.println("dubA rounded: " + Math.round(dubA));
        System.out.println("Floor of dubA: " + Math.floor(dubA));
        System.out.println("Ceiling of dubA: " + Math.ceil(dubA));


    }
}
