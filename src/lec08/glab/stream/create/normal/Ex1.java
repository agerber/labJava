package lec08.glab.stream.create.normal;
import java.util.stream.Stream;
public class Ex1 {
    public static void main(String[] args) {
        Stream<String> stream  = Stream.of("java2s.com");
        stream.forEach(System.out::println);
    }
}
