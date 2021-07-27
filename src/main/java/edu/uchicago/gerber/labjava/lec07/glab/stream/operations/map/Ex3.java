package edu.uchicago.gerber.labjava.lec07.glab.stream.operations.map;

import java.util.stream.Stream;
/*  ww w .  j a  v a 2 s.co  m*/
public class Ex3 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(n -> Stream.of(n, n+1))
                .forEach(System.out::println);

    }
}