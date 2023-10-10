package edu.uchicago.gerber.labjava.lec07.stream.create.from_functions;

import java.util.stream.Stream;

public class Ex1 {
    public static void main(String[] args) {
        Stream<Long> tenNaturalNumbers = Stream.iterate(1L, n  ->  n  + 1)
                .limit(10);

        tenNaturalNumbers.forEach(System.out::println);
    }
}
