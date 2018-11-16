package lec08.glab.stream.create.from_functions;

import java.util.Random;
import java.util.stream.Stream;
/*from   w  w w . jav a 2 s  .  c  o  m*/
public class Ex7 {
    public static void main(String[] args) {
        Stream.generate(new Random()::nextInt)
                .limit(5)
                .forEach(System.out::println);
    }
}