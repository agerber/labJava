package lec08.glab.stream.create.from_functions;

import java.util.stream.Stream;
/*from   ww  w .j a v a 2s. com*/
public class Ex3 {
    public static void main(String[] args) {
        Stream.iterate(2L, n  ->  n  + 1)
                .filter(Ex3::isOdd)
                .skip(100)
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