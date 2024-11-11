package edu.uchicago.gerber.labjava.lec07.spent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSpentExample {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "cherry");

        Stream<String> stream = items.stream();

        // First terminal operation - fully consume the stream
        stream.forEach(System.out::println);

        System.out.println("Trying to use the stream again:");

        // Attempting to use the stream again - this will throw an IllegalStateException
        try {
            stream.forEach(System.out::println); // Throws IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("Stream is already spent: " + e.getMessage());
        }
    }
}
