package edu.uchicago.gerber.labjava.lec07.declarative;
import java.util.stream.Stream;

public class InlineInfiniteStreamExample {
    public static void main(String[] args) {
        // Create an inline infinite stream, limit, filter, map, and print each result
        Stream.iterate(1, n -> n + 1)
                .limit(10)              // Limit to the first 10 numbers
                .filter(n -> n % 2 == 0) // Filter even numbers
                .map(n -> n * 2)        // Multiply by 2
                .forEach(System.out::println); // Directly print each result

    }
}
