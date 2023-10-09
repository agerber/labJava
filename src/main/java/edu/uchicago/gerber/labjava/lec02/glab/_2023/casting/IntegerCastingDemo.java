package edu.uchicago.gerber.labjava.lec02.glab._2023.casting;

public class IntegerCastingDemo {

    public static void main(String[] args) {
        int intValue = 1234567890;
        byte byteValue;
        short shortValue;
        long longValue;

        System.out.println("Original int value: " + intValue);
        printBitRepresentation(intValue);

        // Cast to byte (overflow example)
        byteValue = (byte) intValue;
        System.out.println("\nCasted to byte: " + byteValue);
        printBitRepresentation(byteValue);

        // Cast to short (overflow example)
        shortValue = (short) intValue;
        System.out.println("\nCasted to short: " + shortValue);
        printBitRepresentation(shortValue);

        // Cast to long
        longValue = intValue;  // implicit casting, so no need for explicit cast
        System.out.println("\nCasted to long: " + longValue);
        printBitRepresentation(longValue);

        // Another overflow example: byte
        byteValue = 127;
        System.out.println("\nOriginal byte value: " + byteValue);
        printBitRepresentation(byteValue);

        byteValue++;
        System.out.println("\nIncremented byte value (overflow): " + byteValue);
        printBitRepresentation(byteValue);
    }

    // Print bit representation for different integer types
    public static void printBitRepresentation(int value) {
        System.out.println("Bit representation (int): " + Integer.toBinaryString(value));
    }

    public static void printBitRepresentation(byte value) {
        System.out.println("Bit representation (byte): " + String.format("%8s", Integer.toBinaryString(value & 0xFF)).replace(' ', '0'));
    }

    public static void printBitRepresentation(short value) {
        System.out.println("Bit representation (short): " + String.format("%16s", Integer.toBinaryString(value & 0xFFFF)).replace(' ', '0'));
    }

    public static void printBitRepresentation(long value) {
        System.out.println("Bit representation (long): " + Long.toBinaryString(value));
    }
}
