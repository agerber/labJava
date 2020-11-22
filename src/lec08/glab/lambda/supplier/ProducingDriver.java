package lec08.glab.lambda.supplier;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProducingDriver {
    public static void main(String[] args) {

        //How to produce a stream from a collection
        List<String> myList = new ArrayList<>();
        myList.add("Adam");
        myList.add("Bobby");
        myList.add("Charlie");

        myList
                .stream()
                .forEach(s -> System.out.println(s));



        //from an Array
        Number[] numbers = {

                2,
                5.6,
                new Byte((byte)34),
                new Short((short)927),
                12,
                Integer.parseInt("45"),
                78.9
        };

        Arrays.stream(numbers)
                .forEach(n -> System.out.println(n.doubleValue()));



        //From scratch
        Stream.of(1, 2, 6, 98, 34, 35, 35,243,1)
                .forEach(i -> System.out.println(i));

        IntStream.range(0,100)
                .forEach(i -> System.out.println(i));

        Stream.iterate(0, n -> n +2)
                .limit(100)
                .forEach(n -> System.out.println(n));


        //From a supplier
        Stream<Double> myRandomSupplier = Stream.generate(() -> Math.random());

        myRandomSupplier
                .limit(100)
                .forEach(d -> System.out.println(d));









    }
}
