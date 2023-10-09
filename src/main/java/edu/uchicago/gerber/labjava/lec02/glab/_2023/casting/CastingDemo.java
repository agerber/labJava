package edu.uchicago.gerber.labjava.lec02.glab._2023.casting;

public class CastingDemo {

    public static void main(String[] args) {
        // Initial int value
        int intValue = 256; // Beyond the range of a byte
        System.out.println("Original int value (256): " + Integer.toBinaryString(intValue));

        // Casting int to byte (Overflow, since byte range is -128 to 127)
        byte byteValue = (byte) intValue;
        System.out.println("Cast to byte (Overflow): " + Integer.toBinaryString(byteValue & 0xFF));

        // Initial int value
        intValue = 15; // Within the range of a byte
        System.out.println("\nOriginal int value (15): " + Integer.toBinaryString(intValue));

        // Casting int to byte (No Overflow)
        byteValue = (byte) intValue;
        System.out.println("Cast to byte (No Overflow): " + Integer.toBinaryString(byteValue & 0xFF));

        // Initial double value
        double doubleValue = 123.456;
        System.out.println("\nOriginal double value (123.456): " + Long.toBinaryString(Double.doubleToRawLongBits(doubleValue)));

        // Casting double to int (Truncation, since we lose the decimal part)
        intValue = (int) doubleValue;
        System.out.println("Cast to int (Truncation): " + Integer.toBinaryString(intValue));
    }
}
