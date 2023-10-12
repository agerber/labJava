package edu.uchicago.gerber.labjava.lec03._autoboxing;

public class AutoboxingAllWrapperDemo {

    public static void main(String[] args) {




        // Autoboxing with Byte
        byte primitiveByte = 1;
        Byte boxedByte = primitiveByte;
        System.out.println("Autoboxed Byte: " + objectMetaData(boxedByte));

        // Autoboxing with Short
        short primitiveShort = 2;
        Short boxedShort = primitiveShort;
        System.out.println("Autoboxed Short: " + objectMetaData(boxedShort));

        // Autoboxing with Integer
        int primitiveInt = 3;
        Integer boxedInt = primitiveInt;
        System.out.println("Autoboxed Integer: " + objectMetaData(boxedInt));

        // Autoboxing with Long
        long primitiveLong = 4L;
        Long boxedLong = primitiveLong;
        System.out.println("Autoboxed Long: " + objectMetaData(boxedLong));

        // Autoboxing with Float
        float primitiveFloat = 5.5f;
        Float boxedFloat = primitiveFloat;
        System.out.println("Autoboxed Float: " + objectMetaData(boxedFloat));

        // Autoboxing with Double
        double primitiveDouble = 6.6;
        Double boxedDouble = primitiveDouble;
        System.out.println("Autoboxed Double: " + objectMetaData(boxedDouble));

        // Autoboxing with Character
        char primitiveChar = 'A';
        Character boxedChar = primitiveChar;
        System.out.println("Autoboxed Character: " + objectMetaData(boxedChar));

        // Autoboxing with Boolean
        boolean primitiveBoolean = true;
        Boolean boxedBoolean = primitiveBoolean;
        System.out.println("Autoboxed Boolean: " + objectMetaData(boxedBoolean));


    }

    private static String objectMetaData(Object object){

        return object.getClass().getName() + " : " + object.toString();

    }
}
