package edu.uchicago.gerber.labjava.lec01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CardDriver {
    public static void main(String[] args) throws IllegalAccessException {


        //the instance values are stored on the heap.
        //the method definitions (including constructors) are stored on the .class object.


        System.out.println("THESE ARE THE INSTANCES - THERE CAN BE MANY >>>>>>>>>>>>>");
        System.out.println("Instance are created at runtime >>>>>>>>>>>>>");
        System.out.println("Instances contain field-values ONLY >>>>>>>>>>>>>");
        System.out.println();

        Card[] cards = {
                new Card('K', 'S', (byte)10),
                new Card('8', 'C', (byte)8),
                new Card('9', 'H', (byte)9),
                new Card('A', 'C', (byte)11)
        };

        for (Card card : cards) {
            System.out.println(card);
        }

        System.out.println("THIS is the ONE and ONLY class-object for the Card class");
        System.out.println("Class-objects are loaded PRIOR to runtime >>>>>>>>>>>>>");
        System.out.println("Class-objects contain all the meta-data of this class");
        System.out.println("There is always only ONE class-object per class in your program, even if you use it in " +
                "multiple source files");


        System.out.println(cards[0].getClassObjectAsString());









    }
}
