package edu.uchicago.gerber.labjava.lec04._instanceof;

public class NumberInstanceOfDemo {

    public static void main(String[] args) {
        Number[] numbers = {
                10,      // Autoboxed to Integer
                10.5,    // Autoboxed to Double
                5.5f,    // Autoboxed to Float
                1000L    // Autoboxed to Long
        };

        for (Number num : numbers) {
            if (num instanceof Integer) {
                System.out.println(num + " is an instance of Integer");
            } else if (num instanceof Double) {
                System.out.println(num + " is an instance of Double");
            } else if (num instanceof Float) {
                System.out.println(num + " is an instance of Float");
            } else if (num instanceof Long) {
                System.out.println(num + " is an instance of Long");
            }
        }

    }
}
