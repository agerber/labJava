package edu.uchicago.gerber.labjava.lec10._03_util_concurrent.data_structs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerWithThreadPool {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(7);

        Runnable producer = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    blockingQueue.put("Produced by " + Thread.currentThread().getName() + ": item " + i);
                    System.out.println("Produced by " + Thread.currentThread().getName() + ": item " + i);
                    Thread.sleep(100);  // simulating some time taken to produce an item
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    String item = blockingQueue.take();
                    System.out.println("Consumed by " + Thread.currentThread().getName() + ": " + item);
                    Thread.sleep(150);  // simulating some time taken to consume an item
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        // Submitting three producers and three consumers to the executor
        for (int i = 0; i < 3; i++) {
            executorService.submit(producer);
            executorService.submit(consumer);
        }

        executorService.shutdown(); // No more tasks will be accepted, but already submitted tasks will be executed
    }
}
