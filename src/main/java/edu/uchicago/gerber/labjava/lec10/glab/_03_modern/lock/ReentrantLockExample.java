package edu.uchicago.gerber.labjava.lec10.glab._03_modern.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    //private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock lock = new ReentrantLock(true);
    private static int counter = 0;

    public static void incrementCounter() {
        lock.lock();  // Acquire the lock
        try {
            counter++;
        } finally {
            lock.unlock();  // Always ensure the lock is unlocked in a finally block
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                incrementCounter();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Counter Value: " + counter);  // Expected: 2000
    }
}
