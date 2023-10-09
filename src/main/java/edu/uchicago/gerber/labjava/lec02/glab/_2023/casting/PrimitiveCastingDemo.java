package edu.uchicago.gerber.labjava.lec02.glab._2023.casting;

public class PrimitiveCastingDemo {

    public static void main(String[] args) {

        // Implicit casting (widening conversion)
        int intVal = 100;
        long longVal = intVal; // implicit cast from int to long
        System.out.println("Implicitly casted int to long: " + longVal);

        double doubleVal = intVal; // implicit cast from int to double
        System.out.println("Implicitly casted int to double: " + doubleVal);

        // Explicit casting (narrowing conversion)
        double anotherDouble = 100.25;
        int truncatedVal = (int) anotherDouble; // explicitly cast from double to int (fractional part is lost)
        System.out.println("Explicitly casted double to int (truncated): " + truncatedVal);

        long bigLong = 1000L;
        int smallerInt = (int) bigLong; // explicitly cast from long to int
        System.out.println("Explicitly casted long to int: " + smallerInt);

        // Casting involving byte and char
        byte byteVal = 65;
        char charVal = (char) byteVal; // explicitly cast from byte to char
        System.out.println("Explicitly casted byte to char: " + charVal);

        // Overflow due to casting
        int largeInt = 130;
        byte overflowedByte = (byte) largeInt; // causes overflow as byte max is 127
        System.out.println("Overflowed cast from int to byte: " + overflowedByte);
    }
}
