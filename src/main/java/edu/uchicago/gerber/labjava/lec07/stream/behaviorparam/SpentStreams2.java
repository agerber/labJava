package edu.uchicago.gerber.labjava.lec07.stream.behaviorparam;

import java.util.stream.Stream;

public class SpentStreams2 {

    public static void main(String[] args) {
        // Create a Stream
        Stream<String> stream = Stream.of("a", "b", "c", "d");

        // Use the Stream in a terminal operation: forEach
        stream.forEach(x -> System.out.println(x));

        // Try to use the consumed Stream again
        try {
            // This will throw an IllegalStateException because the stream is spent
            long count = stream.count();

            System.out.println("Stream count: " + count);
        } catch (IllegalStateException e) {
            System.err.println("Exception caught: " + e.getMessage());
        }
    }
}
