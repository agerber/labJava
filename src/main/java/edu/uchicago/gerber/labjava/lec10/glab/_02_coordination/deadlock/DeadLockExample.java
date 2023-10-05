package edu.uchicago.gerber.labjava.lec10.glab._02_coordination.deadlock;

public class DeadLockExample {

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
            synchronized (lockB) {
                System.out.println("Thread2 acquired lock2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}

                synchronized (lockA) {
                    System.out.println("Thread2 acquired lock1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
