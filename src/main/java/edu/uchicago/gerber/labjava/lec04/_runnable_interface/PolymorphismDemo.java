package edu.uchicago.gerber.labjava.lec04._runnable_interface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PolymorphismDemo {

    public static void main(String[] args) {
        // Create a fixed thread pool with 1 thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit various tasks to the executor
        executor.submit(new HelloTask());
        executor.submit(new CountingTask());
        executor.submit(new SumTask());
        executor.submit(new GoodbyeTask());

        // Shutdown the executor
        executor.shutdown();
    }

    // A simple task that prints "Hello"
    static class HelloTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello");
        }
    }

    // A task that counts from 1 to 10
    static class CountingTask implements Runnable {
        @Override
        public void run() {
            final int count = 10;
            for (int i = 1; i < count; i++) {
                System.out.print(i + ",");
            }
            System.out.println(count);
        }
    }

    static class SumTask implements Runnable {
        @Override
        public void run() {
             int sum = 0;
            final int count = 10;
            for (int i = 1; i < count; i++) {
                sum += count;
            }
            System.out.println("The Sum of 1 to 10 is " + sum);
        }
    }


    // A simple task that prints "Goodbye"
    static class GoodbyeTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Goodbye");
        }
    }
}
