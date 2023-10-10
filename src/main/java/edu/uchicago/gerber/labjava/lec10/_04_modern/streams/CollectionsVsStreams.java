package edu.uchicago.gerber.labjava.lec10._04_modern.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CollectionsVsStreams {

    public static void main(String[] args) {

        final int TOTAL = 500;

        // Collection Example: Arrayed in Memory Space
        List<Integer> numbers = new ArrayList<>();
        for (int count = 0; count < TOTAL; count++) {
            numbers.add(count);  // All elements are computed and stored in memory
        }
        // [0, 1, 2, 3, 4, ...]
        //notice that I need the entire Collection before I can begin iterating.
        for (Integer number : numbers) {
            System.out.println(number);
        }

        // Stream Example: Arrayed in Time
        //I'm printing the values as they are generated in real-time.
        //since the objects are never stored on the heap, we don't have to worry about side-effects
        IntStream intStream = IntStream.range(0, TOTAL);
        intStream
//                .filter(n -> n % 2 == 0)
//                .map(n -> n * 3)
                .forEach(System.out::println);  // Elements are computed and processed on-the-fly
    }
}
