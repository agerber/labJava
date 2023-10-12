package edu.uchicago.gerber.labjava.lec03._autoboxing;

import java.awt.Rectangle;
public class AlternativesToNewKeyword {

    public static void main(String[] args) {
        //In Java, you can only create an object in one of three ways:

        //1. for Strings, we can use a string literal to instantiate a new String. This creates a new object,
        //and this is equivalent to String adam = new String("Adam");
        String adam = "Adam";

        //2. for objects that wrap primitives (aka Wrapper objects), we can use the Autoboxing feature,
        //and this also creates a new object, and is equivalent to Double dub = new Double(38.12);
        Double dub = 38.12;

        //3. We can simply use the 'new' keyword to instantiate a new object on the heap.
        Rectangle rectangle = new Rectangle(1,2,3,4);

        //if we don't use of the three techniques above, we DO NOT have an object.
    }
}
