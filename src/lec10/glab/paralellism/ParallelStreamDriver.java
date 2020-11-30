package lec10.glab.paralellism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class ParallelStreamDriver {

    public static void main(String[] args) {
        List<Integer> intVals = new ArrayList<>();

        for (int i = 0; i < 100_000 ; i++) {
            intVals.add(i);
        }

        long startTime = System.currentTimeMillis();

       final AtomicInteger count = new AtomicInteger();
        //will not respect the order as this is done in parellel.
        intVals
                .parallelStream()
                .filter(n -> isPrime(n))
                .peek(n -> count.getAndAdd(1))
                .forEachOrdered(n -> System.out.println(n));

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("DURATION IS " + duration + " MILLISECONDS");
        System.out.println("There are " + count.get() + " prime numbers in this set.");
    }

    private static boolean isPrime(long number) {
        LongPredicate isDivisible = index -> number % index == 0;
        return number > 1 && LongStream.range(2, number - 1).noneMatch(isDivisible);
    }
}
