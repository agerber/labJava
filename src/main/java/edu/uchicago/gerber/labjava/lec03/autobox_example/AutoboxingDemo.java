package edu.uchicago.gerber.labjava.lec03.autobox_example;

import java.util.ArrayList;
import java.util.List;

public class AutoboxingDemo {

    public static void main(String[] args) {
        // Autoboxing: converting a primitive int to its corresponding Integer object
        int primitiveInt = 10;
        Integer boxedInt = primitiveInt;  // Autoboxing
        System.out.println("Auto-boxed Integer: " + boxedInt);

        // Auto-unboxing: converting an Integer object to its corresponding primitive int
        Integer anotherBoxedInt = 20;
        int anotherPrimitiveInt = anotherBoxedInt;  // Auto-unboxing
        System.out.println("Auto-unboxed int: " + anotherPrimitiveInt);

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        // Using ArrayList with primitives, thanks to autoboxing and auto-unboxing
        //You can not store primitives in a data-structure (other than an array), so you must use Wrapper-classes
        List<Integer> list = new ArrayList<>();
        // Autoboxing during addition
        for (int count = 0; count < 5; count++) {
            list.add(count);  // Autoboxing
            //what is the type of this value
            System.out.println("Retrieved from list as Object [" + list.get(count).getClass().getName() + "]: " + list.get(count));
        }

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        // Auto-unboxing during retrieval
        for (int count = 0; count < list.size(); count++) {
            int value = list.get(count);  // Auto-unboxing
            System.out.println("Retrieved from list as primitive: " + value);
        }
    }
}
