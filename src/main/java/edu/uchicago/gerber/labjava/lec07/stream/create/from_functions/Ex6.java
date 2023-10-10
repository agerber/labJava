package edu.uchicago.gerber.labjava.lec07.stream.create.from_functions;

import java.util.Random;
/* ww  w .  j  a v a 2  s  . c o m*/
public class Ex6 {
    public static void main(String[] args) {
        new Random().ints()
                .limit(5)
                .forEach(System.out::println);

    }
}
