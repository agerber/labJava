package edu.uchicago.gerber.labjava.lec10._03_util_concurrent.future_callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class FutureCallableExample {

    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // List to hold Future objects
        List<Future<Integer>> futureList = new ArrayList<>();

       final Random random = new Random();

        // Enqueue 10 Callable tasks
        for (int count = 1; count <= 10; count++) {
            final int number = count;
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println("Callable: calculating square of " + number + " by " + Thread.currentThread().getName());
                    Thread.sleep(random.nextInt(2000));  // Simulating work
                    return number * number;
                }
            };

            // Submit the task to the thread pool and store the Future object
            Future<Integer> futureResult = executorService.submit(task);
            futureList.add(futureResult);
        }

        // Retrieve the results from the Future objects
        for (int count = 0; count < futureList.size(); count++) {
            try {
                //this will simply block until the Future has a value, at which point it will execute and return value.
                Integer result = futureList.get(count).get();
                System.out.println("Future result: square of " + (count + 1) + " is: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        //notice that we don't need to use join here to wait for runnables to finish to check the results in a
        //local variable or a local data-structure.

        // Shutdown the executor service
        executorService.shutdown();
    }
}

