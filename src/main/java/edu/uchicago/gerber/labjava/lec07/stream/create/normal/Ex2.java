package edu.uchicago.gerber.labjava.lec07.stream.create.normal;

import java.util.stream.Stream;

public class Ex2 {
    public static void main(String[] args) {
        Stream<String> stream  = Stream.of("XML", "Java",  "CSS", "SQL");
        stream.forEach(System.out::println);
    }
}
