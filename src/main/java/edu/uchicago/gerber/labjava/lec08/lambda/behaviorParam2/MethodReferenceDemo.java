package edu.uchicago.gerber.labjava.lec08.lambda.behaviorParam2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MethodReferenceDemo {


    // Method with one parameter
    private static String upperCaseMe(String str) {
        return str.toUpperCase();
    }

    // Method with two parameters that returns a boolean
    private static boolean isGreaterThan(Integer a, Integer b) {
        return a > b;
    }

    private static boolean isNotEmpty(String str) {
        return !str.isEmpty();
    }





    public static void main(String[] args) {

        List<String> cities = Arrays.asList("Boston", "New York", "", "Shanghai", "London", "Chicago");


        cities.stream()
                .filter(city -> isNotEmpty(city))
                //.filter(MethodReferenceDemo::isNotEmpty)
                .map(city -> upperCaseMe(city))
                //.map(MethodReferenceDemo::upperCaseMe)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String str1, String str2) {
                        return str1.compareTo(str2);
                    }
                })
                .forEach(System.out::println);


        System.out.println("&&&&&&&&&&&&&&&&&&& ANOTHER EXAMPLE &&&&&&&&&&&&&&&&&&&&&&&&&&&");


        // Create a list of Integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final int THRESHOLD = 5;

        //Notice that method-references don't help us in this scenario b/c we have two params
        System.out.println("Numbers greater than five: ");
        // Stream over the collection of Integers, using the method reference in a filter operation
        numbers.stream()
                .filter(n -> isGreaterThan(n, THRESHOLD))
                .forEach(System.out::println);


    }
}
