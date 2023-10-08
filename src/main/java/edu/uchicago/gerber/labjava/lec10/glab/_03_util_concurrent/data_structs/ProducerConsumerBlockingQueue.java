package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent.data_structs;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {

    /*
    Because the consumer is slower than the producer, the queue will eventually fill up, and the producer will block waiting for space to become available in the queue.
     */
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(7);

        //producer is 3x faster than consumer, so blocking queue will fill up
        Thread producerThread = new Thread( new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        //put is blocking
                        if (i % 2 != 0) throw new InterruptedException("something went wrong on " + i + " : " + Thread.currentThread().getName());
                        blockingQueue.put("Item " + i);
                        System.out.println("Produced item " + i);
                        Thread.sleep(50);  // simulating some time taken to produce an item
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "producer");

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        if (i % 2 == 0)  throw new InterruptedException("something went wrong on " + i + " : " + Thread.currentThread().getName());
                        //take() is blocking
                        String item = blockingQueue.take();
                        System.out.println("Consumed " + item);
                        Thread.sleep(150);  // simulating some time taken to consume an item
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } ,"consumer");

        producerThread.start();
        consumerThread.start();
    }
}
