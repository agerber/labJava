package edu.uchicago.gerber.labjava.lec07.stream.create.normal;

import java.util.stream.Stream;

public class Ex6 {
    public static void main(String[] args) {
        Stream<String> stream  = Stream.empty();
        stream.forEach(System.out::println);
    }
}
