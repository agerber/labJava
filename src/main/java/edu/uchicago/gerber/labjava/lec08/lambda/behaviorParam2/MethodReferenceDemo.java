package edu.uchicago.gerber.labjava.lec08.lambda.behaviorParam2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
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
        return str.length() > 0;
    }





    public static void main(String[] args) {

        List<String> cities = Arrays.asList("Boston", "New York", "", "Shanghai", "London", "Chicago");

        //we can toggle among anonymous inner classes, lambdas, and method references.

        cities.stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String city) {
                        return !city.isEmpty();
                    }
                })
//                .filter(city -> !city.isEmpty())
//                .filter(MethodReferenceDemo::isNotEmpty)
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String city) {
                        return city.toUpperCase();
                    }
                })
                //.map(city -> city.toUpperCase())
                //.map(String::toUpperCase)
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
