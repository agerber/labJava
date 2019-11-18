package lec07.glab.stream.parallel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://www.mkyong.com/java8/java-8-parallel-streams-examples/
public class ParallelExample4 {

    public static void main(String[] args) {

        long count = Stream.iterate(0, n -> n + 1)
                .limit(100_000)
               // .parallel()   //with this 23s, without this 1m 10s
                .filter(ParallelExample4::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);

    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

}