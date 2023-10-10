package edu.uchicago.gerber.labjava.lec01;

/**
 1) Write a program that does the following: Create seven variables, one for each of the primitive number types in Java,
 and initialize each variable with any appropriate value. Print out the name of each variable and its value. Modify the
 value of each variable with an assignment statement and print out the names of the variables and their new values.

 Next, create seven constants, one for each of the primitive number types in Java. Print the name of the constant and
 its value.

 What happens if you try to assign a value to a constant?
 */
public class NumberDemo
{
    public static void main(String[] args)
    {

        int aInt = 23;
        byte aByte = +127;
        short aShort = 32767;
        long aLong = 123456789012345678L; // L indicates a long value
        double aDouble = 3.456789D;      // D indicates a double value
        float aFloat = -320.00987F;      // F indicates a float value
        char aChar = 97;
        System.out.println("aInt    = " + aInt);
        System.out.println("aByte   = " + aByte);
        System.out.println("aShort  = " + aShort);
        System.out.println("aLong   = " + aLong);
        System.out.println("aDouble = " + aDouble);
        System.out.println("aFloat  = " + aFloat);
        System.out.println("aChar   = " + aChar);
        aInt = 44;
        aByte = -128;
        aShort = -32768;
        aLong = -33333333333L;
        aDouble = 3.32E-6;
        aFloat = 4.00007F;
        aChar = 98;
        System.out.println("aInt    = " + aInt);
        System.out.println("aByte   = " + aByte);
        System.out.println("aShort  = " + aShort);
        System.out.println("aLong   = " + aLong);
        System.out.println("aDouble = " + aDouble);
        System.out.println("aFloat  = " + aFloat);
        System.out.println("aChar   = " + aChar);
        final int aConstantInt = 23;
        final byte aConstantByte = +127;
        final short aConstantShort = 32767;
        final long aConstantLong = 123456789012345678L; // L indicates a long value
        final double aConstantDouble = 3.456789D; // D indicates a double value
        final float aConstantFloat = -320.00987F; // F indicates a float value
        final char aConstantChar = 97;
        System.out.println("aConstantInt    = " + aConstantInt);
        System.out.println("aConstantByte   = " + aConstantByte);
        System.out.println("aConstantShort  = " + aConstantShort);
        System.out.println("aConstantLong   = " + aConstantLong);
        System.out.println("aConstantFloat  = " + aConstantFloat);
        System.out.println("aConstantChar   = " + aConstantChar);
        // aConstantInt = 24;  // A compile-time error when uncommented
    }
}
