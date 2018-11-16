package lec08.glab.stream.create.from_functions;

import java.util.stream.Stream;
//  w ww.  jav  a  2s  .c  o  m
public class Ex1 {
    public static void main(String[] args) {
        Stream<Long> tenNaturalNumbers = Stream.iterate(1L, n  ->  n  + 1)
                .limit(10);

        tenNaturalNumbers.forEach(System.out::println);
    }
}