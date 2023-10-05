package edu.uchicago.gerber.labjava.lec10.glab._05_loom;

import java.util.concurrent.*;

public class VirtualThreadExecutorExample {

    public static void main(String[] args) {

        //fibers and virtual threads are conceptually same. elaborate

        // Create an Executor for virtual threads
        ExecutorService virtualThreadExecutor = Executors.newVirtualThreadPerTaskExecutor();

        // Submit tasks to the Executor
        for (int i = 0; i < 50; i++) {
            int taskId = i;
            virtualThreadExecutor.submit(() -> {
                System.out.println("Running task #" + taskId + " in virtual thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);  // Virtual threads can be blocked without major overhead
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Shutdown the executor after tasks are completed
        virtualThreadExecutor.shutdown();
        try {
            if (!virtualThreadExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
                virtualThreadExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            virtualThreadExecutor.shutdownNow();
        }

        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
