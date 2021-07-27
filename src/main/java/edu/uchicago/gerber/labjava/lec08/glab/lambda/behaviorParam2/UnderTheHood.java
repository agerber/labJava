package edu.uchicago.gerber.labjava.lec08.glab.lambda.behaviorParam2;

import java.util.stream.Stream;

/**
 * Created by Adam on 7/15/2015.
 */
public class UnderTheHood {

    public static void main(String[] args) {


        System.out.println("&&&&&&&&&&&&&&& first loop &&&&&&&&&&&&&&&&&&&&&");

        int[] idx = { 0 };

       Stream<String> myStream =  Stream.of("d2", "a2", "a6", "a3", "b1", "b3", "c4", "a9");
             myStream
                .sorted((s1, s2) -> {  //intermediate operation
                    System.out.printf(++idx[0] + ": sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {  //intermediate operation
                    System.out.println(++idx[0] + ": filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {  //intermediate operation
                    System.out.println(++idx[0] + ": map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println(++idx[0] + ": forEach: " + s));  //terminal opeeration


        System.out.println("&&&&&&&&&&&&&&& second loop &&&&&&&&&&&&&&&&&&&&&");

        int[] idy = { 0 };

        //switch the order to optimize by filtering first
        Stream.of("d2", "a2",  "a6",  "a3", "b1", "b3", "c4", "a9")
                .filter(s -> {  //intermediate operation
                    System.out.println(++idy[0] + ": filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {  //intermediate operation
                    System.out.printf(++idy[0] + ": sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })

                .map(s -> {  //intermediate operation
                    System.out.println(++idy[0] + ": map: " + s);
                    return s.toUpperCase();
                })

             .forEach(s -> System.out.println(++idy[0] + ": forEach: " + s));  //terminal opeeration
    }


}


