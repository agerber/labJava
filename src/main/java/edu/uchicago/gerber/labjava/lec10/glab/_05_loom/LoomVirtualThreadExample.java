package edu.uchicago.gerber.labjava.lec10.glab._05_loom;

import java.util.concurrent.*;

public class LoomVirtualThreadExample {

    public static void main(String[] args) {

        // Use a virtual thread executor
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            // Number of virtual threads to create
            final int NUM_THREADS = 50;

            // Submit tasks to be executed by virtual threads
            for (int i = 0; i < NUM_THREADS; i++) {
                int finalI = i;
                executor.submit(() -> {
                    System.out.println("Running inside virtual thread #" + finalI + ": " + Thread.currentThread().getName());
                });
            }

        } // The executor is closed automatically after this try-with-resources block, so no explicit shutdown is needed

        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
