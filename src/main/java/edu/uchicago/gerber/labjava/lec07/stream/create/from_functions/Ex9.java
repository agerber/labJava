package edu.uchicago.gerber.labjava.lec07.stream.create.from_functions;
import java.util.stream.IntStream;

public class Ex9 {
    public static void main(String[] args) {
        IntStream.generate(() ->  0)
                .limit(5)
                .forEach(System.out::println);
    }
}
