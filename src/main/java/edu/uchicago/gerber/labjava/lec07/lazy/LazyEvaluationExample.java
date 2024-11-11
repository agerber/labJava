package edu.uchicago.gerber.labjava.lec07.lazy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LazyEvaluationExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Intermediate operations (filter and map) are not executed until collect() is called
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A")) // Filter names that start with "A"
                .map(String::toUpperCase)             // Convert filtered names to uppercase
                .collect(Collectors.toList());        // Terminal operation triggers evaluation

        // Output result
        System.out.println(result); // Output: [ALICE]
    }
}
