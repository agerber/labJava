package edu.uchicago.gerber.labjava.lec07.glab.stream.create.from_functions;
import java.util.stream.Stream;
/*  ww w  .ja  v  a 2s  . c  om*/
public class Ex4 {
    public static void main(String[] args) {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }
}