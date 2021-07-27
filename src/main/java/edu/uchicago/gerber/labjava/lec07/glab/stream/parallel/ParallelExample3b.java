package edu.uchicago.gerber.labjava.lec07.glab.stream.parallel;

import java.util.stream.IntStream;
//https://www.mkyong.com/java8/java-8-parallel-streams-examples/
public class ParallelExample3b {

    public static void main(String[] args) {

        System.out.println("Normal...");

        IntStream range = IntStream.rangeClosed(1, 1000);
        range.forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });

        System.out.println("Parallel...");

        IntStream range2 = IntStream.rangeClosed(1, 1000);
        range2.parallel().forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });

    }

}