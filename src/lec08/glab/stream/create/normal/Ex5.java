package lec08.glab.stream.create.normal;

import java.util.stream.IntStream;

public class Ex5 {
    public static void main(String[] args) {
        IntStream oneToFive  = IntStream.range(1, 6);
        //IntStream oneToFive  = IntStream.rangeClosed(1, 5);
        oneToFive.forEach(System.out::println);
    }
}