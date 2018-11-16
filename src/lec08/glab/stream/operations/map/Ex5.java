package lec08.glab.stream.operations.map;

import java.util.stream.IntStream;
import java.util.stream.Stream;
// www  .  j  a  v a 2s.  c  o  m
public class Ex5 {
    public static void main(String[] args) {
        Stream.of("XML", "Java",  "CSS")
                .flatMap(name ->  IntStream.range(0, name.length())
                        .mapToObj(name::charAt))
                .forEach(System.out::println);
    }
}