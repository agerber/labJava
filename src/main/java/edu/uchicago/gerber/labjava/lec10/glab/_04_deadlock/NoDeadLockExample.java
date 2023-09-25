package edu.uchicago.gerber.labjava.lec10.glab._04_deadlock;

public class NoDeadLockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread1 acquired lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                synchronized (lock2) {
                    System.out.println("Thread1 acquired lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread2 acquired lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                synchronized (lock2) {
                    System.out.println("Thread2 acquired lock2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
