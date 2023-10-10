package edu.uchicago.gerber.labjava.lec07.stream.intro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StreamVsCollection {

    public static void main(String...args){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Iction");
        Stream<String> stream = names.stream();

        stream
                .filter(u -> u.startsWith("I"))  //intermediate
                .map(y -> y.length()) //intermediate
                .forEach(System.out::println);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once

        List<String> names2 = Arrays.asList("Java8", "Lambdas", "In", "Iction");
        Stream<String> s2 = names2.stream();
        s2.forEach(System.out::println);
    }
}
