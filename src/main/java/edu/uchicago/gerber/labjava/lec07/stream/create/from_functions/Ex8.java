package edu.uchicago.gerber.labjava.lec07.stream.create.from_functions;

import java.util.Random;
import java.util.stream.IntStream;
//from  w  ww . j  a  v a2s  .co  m
public class Ex8 {
    public static void main(String[] args) {
        IntStream.generate(new Random()::nextInt)
                .limit(5)
                .forEach(System.out::println);

    }
}
