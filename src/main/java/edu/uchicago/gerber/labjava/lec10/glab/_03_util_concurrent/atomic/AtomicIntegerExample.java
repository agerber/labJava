package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    /*
       Atomic classes provide both visibility and atomicity. Use them in place of volatile.
     */
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static int incrementCounter() {
       return counter.incrementAndGet();  // Atomically increment the current value by 1
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println( incrementCounter());

                try {
                    Thread.sleep(1); // Adding a delay for demonstration purposes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println( incrementCounter());

                try {
                    Thread.sleep(1); // Adding a delay for demonstration purposes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Counter Value: " + counter.get());  // Expected: 2000
    }
}
