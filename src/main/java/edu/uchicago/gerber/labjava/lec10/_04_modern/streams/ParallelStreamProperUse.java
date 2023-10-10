package edu.uchicago.gerber.labjava.lec10._04_modern.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamProperUse {

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 1_000_000)
                .boxed()
                .collect(Collectors.toList());

        long startTime = System.currentTimeMillis();

        // Using regular stream
        List<Integer> primesWithStream = numbers.stream()
                .filter(ParallelStreamProperUse::isPrime)
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with stream: " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();

        // Using parallelStream
        List<Integer> primesWithParallelStream = numbers.parallelStream()
                .filter(ParallelStreamProperUse::isPrime)
                .collect(Collectors.toList());

        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallelStream: " + (endTime - startTime) + " milliseconds");
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        int i = 5;
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
            i += 6;
        }
        return true;
    }
}
