package lec07.glab.stream.create.normal;

import java.util.stream.Stream;

public class Ex3 {
    public static void main(String[] args) {
        String[] names = { "XML", "Java", "SQL", "CSS" };
        Stream<String> stream = Stream.of(names);
        stream.forEach(System.out::println);
    }
}