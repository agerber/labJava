package lec07.glab.stream.operations.filter;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyPredicates {
    public static void main(String[] args) {

        Stream.of("Adam", "Bobby", "Carla", "Danny", "Ellie", "Frank", "Gregg")
                .filter(s -> String.valueOf(s.charAt(0)).compareTo("C") >= 0)
                .forEach(s -> System.out.println( s.toUpperCase()));


        final Predicate<String> stringPredicate = s -> String.valueOf(s.charAt(0)).compareTo("C") >= 0;
        Stream.of("Adam", "Bobby", "Carla", "Danny", "Ellie", "Frank", "Gregg")
                .filter(stringPredicate)
                .forEach(s -> System.out.println( s.toUpperCase()));



    }
}
