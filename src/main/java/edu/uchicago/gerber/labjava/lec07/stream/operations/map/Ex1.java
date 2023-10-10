package edu.uchicago.gerber.labjava.lec07.stream.operations.map;

import java.util.stream.IntStream;
//from  w  w w. j a v  a  2 s.c  o m
public class Ex1 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .forEach(System.out::println);

    }
}
