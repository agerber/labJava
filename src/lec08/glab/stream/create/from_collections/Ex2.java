package lec08.glab.stream.create.from_collections;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
/*from  w w w . j a  va 2  s . co m*/
public class Ex2 {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("XML");
        names.add("Java");

        Stream<String> sequentialStream  = names.stream();
        sequentialStream.forEach(System.out::println);

        Stream<String> parallelStream = names.parallelStream();
        parallelStream.forEach(System.out::println);
    }
}