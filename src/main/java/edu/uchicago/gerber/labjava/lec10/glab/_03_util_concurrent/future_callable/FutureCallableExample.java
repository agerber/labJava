package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent.future_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureCallableExample {

    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // List to hold Future objects
        List<Future<Integer>> futureList = new ArrayList<>();

        // Enqueue 10 Callable tasks
        for (int i = 1; i <= 10; i++) {
            final int number = i;
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("Calculating square of " + number + " by " + Thread.currentThread().getName());
                    Thread.sleep(500);  // Simulating work
                    return number * number;
                }
            };

            // Submit the task to the thread pool and store the Future object
            Future<Integer> futureResult = executorService.submit(task);
            futureList.add(futureResult);
        }

        // Retrieve the results from the Future objects
        for (int i = 0; i < futureList.size(); i++) {
            try {
                Integer result = futureList.get(i).get();
                System.out.println("Square of " + (i + 1) + " is: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor service
        executorService.shutdown();
    }
}

