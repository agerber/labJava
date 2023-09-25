package edu.uchicago.gerber.labjava.lec10.glab._01_basics.wait_notify;

public class WaitTimeoutExample {
    private final Object lock = new Object();

    public void waitingThread() {
        synchronized (lock) {
            System.out.println("Waiting for notification or timeout...");
            try {
                lock.wait(3000); // wait up to 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Resumed after waiting!");
        }
    }

    public void notifyingThread() {
        synchronized (lock) {
            System.out.println("Performing some work...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sending notification...");
            lock.notify();
        }
    }

    public static void main(String[] args) {
        WaitTimeoutExample example = new WaitTimeoutExample();

        Thread t1 = new Thread(example::waitingThread);
        Thread t2 = new Thread(example::notifyingThread);

        t1.start();

        try {
            Thread.sleep(500); // Ensure t1 starts before t2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}
