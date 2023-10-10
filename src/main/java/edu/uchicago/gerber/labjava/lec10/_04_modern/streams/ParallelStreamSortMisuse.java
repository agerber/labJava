package edu.uchicago.gerber.labjava.lec10._04_modern.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamSortMisuse {

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 100_000)
                .boxed()
                .collect(Collectors.toList());

        long startTime = System.currentTimeMillis();

        // Misuse: Using parallelStream() for sorting a small list
        List<Integer> sortedNumbers = numbers.parallelStream()
                .sorted()
               // .peek(n ->  System.out.println("Processing " + n + " in thread: " + Thread.currentThread().getName()))
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallelStream: " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();

        // More appropriate: Using stream() for sorting a small list
        sortedNumbers = numbers.stream()
                .sorted()
                //.peek(n ->  System.out.println("Processing " + n + " in thread: " + Thread.currentThread().getName()))
                .collect(Collectors.toList());

        endTime = System.currentTimeMillis();
        System.out.println("Time taken with stream: " + (endTime - startTime) + " milliseconds");
    }
}
