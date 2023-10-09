package edu.uchicago.gerber.labjava.lec02.glab._2023.casting;

public class TypeConversionDemo {

    public static void main(String[] args) {

        // Convert string to int using parseInt
        String intStr = "123";
        int intValue = Integer.parseInt(intStr);
        System.out.println("Converted string to int: " + intValue);

        // Convert string to double using parseDouble
        String doubleStr = "123.45";
        double doubleValue = Double.parseDouble(doubleStr);
        System.out.println("Converted string to double: " + doubleValue);

        // Convert string to byte using parseByte
        String byteStr = "65";
        byte byteValue = Byte.parseByte(byteStr);
        System.out.println("Converted string to byte: " + byteValue);

        // Convert string to float using parseFloat
        String floatStr = "3.14";
        float floatValue = Float.parseFloat(floatStr);
        System.out.println("Converted string to float: " + floatValue);

        // Convert string to long using parseLong
        String longStr = "123456789";
        long longValue = Long.parseLong(longStr);
        System.out.println("Converted string to long: " + longValue);

        // Error handling
        try {
            String invalidStr = "abc";
            int invalidInt = Integer.parseInt(invalidStr);
        } catch (NumberFormatException e) {
            System.out.println("Error converting string to int: " + e.getMessage());
        }
    }
}
