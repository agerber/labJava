package edu.uchicago.gerber.labjava.lec10.glab._04_modern;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcurrentStreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> squaredNumbers = numbers.parallelStream()
                .map(n -> {
                    System.out.println("Processing " + n + " in thread: " + Thread.currentThread().getName());
                    return n * n;
                })
                .collect(Collectors.toList());

        System.out.println(squaredNumbers);
    }
}
