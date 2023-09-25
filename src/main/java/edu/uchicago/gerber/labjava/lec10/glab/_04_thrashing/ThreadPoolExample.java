package edu.uchicago.gerber.labjava.lec10.glab._04_thrashing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {

    public static void main(String[] args) {
        // Create a thread pool with a fixed number of threads (in this case, 3).
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 10 tasks to the executor.
        for (int i = 0; i < 10; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskNumber + " on thread " + Thread.currentThread().getName());
                try {
                    // Simulate some work with Thread.sleep.
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished task " + taskNumber);
            });
        }

        // Shutdown the executor gracefully.
        executor.shutdown();

        try {
            // Wait for all tasks to finish (with a timeout).
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Some tasks did not finish within the timeout!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executor.shutdownNow();
        }
    }
}
