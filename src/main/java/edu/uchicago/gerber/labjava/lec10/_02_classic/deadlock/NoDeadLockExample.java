package edu.uchicago.gerber.labjava.lec10._02_classic.deadlock;

public class NoDeadLockExample {

    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread1 acquired lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                synchronized (lockB) {
                    System.out.println("Thread1 acquired lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread2 acquired lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                synchronized (lockB) {
                    System.out.println("Thread2 acquired lock2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
