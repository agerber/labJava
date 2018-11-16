package lec08.glab.stream.operations.map;

import java.util.stream.Stream;
// w  w  w .  j  a v a 2s . com
public class Ex4 {
    public static void main(String[] args) {
        Stream.of("XML", "Java",  "CSS")
                .map(name  ->  name.chars())
                .flatMap(intStream ->  intStream.mapToObj(n ->  (char)n))
                .forEach(System.out::println);

    }
}