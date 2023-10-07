package edu.uchicago.gerber.labjava.lec10.glab._04_modern.streams;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class StreamVsCollection {
    public static void main(String[] args) {


        //DECLARATIVE: Using streams. Streams are arrayed in TIME and produce in real-time
        Stream.of(1,2,1,3,3,2,4)
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);


        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");


        //IMPERATIVE: initial array / collection which is arrayed in memory space.
        int[] numbers = {1,2,1,3,3,2,4};
        //accumulator
        Set<Integer> set = new TreeSet<>();
        //iterate once
        for (int number : numbers) {
            if (number % 2 == 0){
                set.add(number);
            }
        }
        //iterate twice
        for (Integer val : set) {
            System.out.println(val);
        }


    }
}
