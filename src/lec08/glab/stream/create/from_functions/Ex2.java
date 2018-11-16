package lec08.glab.stream.create.from_functions;

import java.util.stream.Stream;
//from w w w  . j a v a2 s  .c  om
public class Ex2 {
    public static void main(String[] args) {
        Stream.iterate(2L, n  ->  n  + 1)
                .filter(Ex2::isOdd)
                .limit(5)
                .forEach(System.out::println);
    }
    public static boolean isOdd(long number) {
        if (number % 2 == 0) {
            return false;
        }
        return true;
    }
}