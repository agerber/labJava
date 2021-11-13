package edu.uchicago.gerber.labjava.lec07.glab.stream.behaviorparam;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class SpentStreams {

    public static void main(String[] args) {


        List<String> stringList = new LinkedList<>();
        stringList.add("Adam");
        stringList.add("Bart");
        stringList.add("Carl");


        Iterator<String> iterator = stringList.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //System.out.println(iterator.next());


        //this won't produce anything
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
       // System.out.println("the next element is  " + iterator.next());



//
//        //if you're going to use primitives, use the IntStram, DoubleStream, etc. These are more efficient than Stream for those operations
       IntStream stream = IntStream.range(1, 10);
//
//
       final IntPredicate intPredicate = n -> n % 2 == 0;
//
        stream
                .filter(intPredicate)
                .map(n -> n * n)
                .forEach(n -> System.out.println(String.valueOf(n)));
//

        stream = IntStream.range(1, 100);

            stream
                .filter(intPredicate)
                .map(n -> n * n)
                .forEach(n -> System.out.println(String.valueOf(n)));

//        //already spent
//        //stream = IntStream.range(1, 1000);
//        stream
//
//                .filter(n -> n % 2 == 0)
//                .map(n -> n * n)
//                .forEach(n -> System.out.println(String.valueOf(n)));
//
//
//
//

    }
}
