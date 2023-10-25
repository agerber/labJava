package edu.uchicago.gerber.labjava.lec10._03_util_concurrent.data_structs;

import java.nio.channels.AcceptPendingException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerWithThreadPool {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(7);

        AtomicInteger atomicCounter = new AtomicInteger(0);

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        blockingQueue.put("Gerber");
                        System.out.println("put " +  atomicCounter.incrementAndGet());
                        Thread.sleep(100);  // simulating some time taken to produce an item
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        //we could get the String object from this blocking-queue
                        blockingQueue.take();
                        System.out.println("take " +  atomicCounter.decrementAndGet());
                        Thread.sleep(150);  // simulating some time taken to consume an item
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        // Submitting three producers and three consumers to the executor
        executorService.submit(producer);
        executorService.submit(consumer);

        executorService.shutdown(); // No more tasks will be accepted, but already submitted tasks will be executed
    }
}
