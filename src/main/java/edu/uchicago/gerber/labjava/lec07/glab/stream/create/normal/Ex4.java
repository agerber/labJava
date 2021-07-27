package edu.uchicago.gerber.labjava.lec07.glab.stream.create.normal;

import java.util.stream.Stream;
//from w  ww. j a v  a  2 s.c om
public class Ex4 {
    public static void main(String[] args) {
        Stream<String> stream  = Stream.<String>builder()
                .add("XML")
                .add("Java")
                .add("CSS")
                .add("SQL")
                .build();
        stream.forEach(System.out::println);
    }
}