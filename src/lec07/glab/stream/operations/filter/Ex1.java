package lec07.glab.stream.operations.filter;

import java.util.stream.Stream;
//ww w  . j a v a 2  s  .co  m
public class Ex1 {
    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3, 4, 5)
                .peek(e -> System.out.println("Taking integer: " + e))
                .filter(n -> n % 2 == 1)
                .peek(e -> System.out.println("Filtered integer: " + e))
                .map(n -> n * n).peek(e -> System.out.println("Mapped integer: " + e))
                .reduce(0, Integer::sum);
        System.out.println("Sum = " + sum);

    }
}