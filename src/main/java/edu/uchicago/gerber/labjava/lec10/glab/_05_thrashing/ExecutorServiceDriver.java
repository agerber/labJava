package edu.uchicago.gerber.labjava.lec10.glab._05_thrashing;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDriver {

    public static void main(String[] args) {
        // Create a thread pool with a fixed number of threads (in this case, 3).
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //create a random for generating random sleep times.
        Random random = new Random();

        // Submit 9 tasks to the executor.
        for (int count = 0; count < 9; count++) {
            final int taskNumber = count;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Executing task " + taskNumber + " on thread " + Thread.currentThread().getName());
                    try {
                        // Simulate some work with Thread.sleep for up to 1 second
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Finished task " + taskNumber);
                }
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
