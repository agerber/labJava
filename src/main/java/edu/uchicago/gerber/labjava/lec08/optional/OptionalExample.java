package edu.uchicago.gerber.labjava.lec08.optional;

import java.awt.*;
import java.util.Optional;

public class OptionalExample {


    // Simulate a method that could return a null value
    private static String getNullableString() {
        // In a real-world scenario, this might return null sometimes.
        return null; // for the sake of this demo, it always returns null.
    }

    public static void main(String[] args) {


        //this is a problem. try uncommenting these two lines
//        Rectangle rectangle = null;
//        System.out.println(rectangle.toString());


        // Creating an Optional object that might be null
        String nullableString = getNullableString();
        Optional<String> optional = Optional.ofNullable(nullableString);

        //isPresent() returns a boolean
        System.out.println(optional.isPresent());

        // Using ifPresent(Consumer consumer) to provide a lambda expression to execute if a value is present
        optional.ifPresent(str -> System.out.println(str));

        // Using orElse() to retrieve the value if present, or get a default one if not
        String valueOrDefault = optional.orElse("Default Value from orElse");
        System.out.println(valueOrDefault);

        // Using orElseGet() to retrieve the value or get it from a supplier functional interface
        String valueOrGetDefault = optional.orElseGet(() -> "Default Value from Supplier");
        System.out.println(valueOrGetDefault);

        // Using orElseThrow() to throw an exception if the Optional is empty
        try {
            String valueOrThrow = optional.orElseThrow(() -> new IllegalArgumentException("No value present!"));
            System.out.println(valueOrThrow);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

}

