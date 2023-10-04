package edu.uchicago.gerber.labjava.lec10.glab._02_coordination.wait_notify_yield;

public class YieldDemo {

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(), "Producer");
        Thread consumer = new Thread(new Consumer(), "Consumer");

        producer.setPriority(Thread.MAX_PRIORITY);  // set to max priority
        consumer.setPriority(Thread.MIN_PRIORITY);  // set to min priority

        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is producing item: " + i);

            // Hint to the scheduler that the current thread is willing to yield its current use of CPU
            Thread.yield();
        }
    }
}

class Consumer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is consuming item: " + i);

            // Even though the consumer thread has a lower priority than the producer,
            // it can still get a chance to execute because the producer thread is yielding.
            // However, the behavior still remains platform-dependent.
        }
    }
}
