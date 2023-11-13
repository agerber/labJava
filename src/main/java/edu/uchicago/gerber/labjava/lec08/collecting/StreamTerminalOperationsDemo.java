package edu.uchicago.gerber.labjava.lec08.collecting;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminalOperationsDemo {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("stream", "lambda", "optional", "class", "object", "inheritance");

        // forEach - perform an action for each element of the stream
        System.out.println("Printing each element in the stream:");
        strings.stream().forEach(System.out::println);



        // collect - collect the elements of the stream into a list
        List<String> filteredList = strings.stream()
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList());

        System.out.println("Filtered list: " + filteredList);

        // match - determine if the predicate matches any elements of the stream
        boolean anyMatchResult = strings.stream().anyMatch(s -> s.startsWith("o"));
        System.out.println("Any string starts with 'o': " + anyMatchResult);

        //returns a boolean
        boolean allMatchResult = strings.stream().allMatch(s -> s.length() > 3);
        System.out.println("All strings have length greater than 3: " + allMatchResult);

        // count - count the number of elements in the stream
        long count = strings.stream().filter(s -> s.contains("a")).count();
        System.out.println("Number of strings that contain 'a': " + count);


        // findFirst - find the first element of the stream
        Optional<String> firstString = strings.stream().findFirst();
        System.out.println("First string in the list: " + firstString.orElse("None"));


        // reduce - sum all the values
        Stream<Integer> numbers = Stream.of(1,2,3,4,5);
        Optional<Integer> sum = numbers.reduce(Integer::sum);
        System.out.println(sum.orElse(0));


        // reduce - perform a reduction on the elements of the stream to produce a single result
        Optional<String> concatenatedString = strings.stream().reduce((a, b) -> a + "-" + b);
        concatenatedString.ifPresent(s -> System.out.println("Concatenated String: " + s));





    }
}
