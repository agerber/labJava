package edu.uchicago.gerber.labjava.lec07.glab.stream.operations.reduce;

import java.util.Arrays;
import java.util.List;
// ww w. j av a 2 s. c  o  m
public class Ex1 {
    public static void main(String[] args) {
        List<Integer> numbers  = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}