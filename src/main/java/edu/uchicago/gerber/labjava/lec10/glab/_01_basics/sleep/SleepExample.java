package edu.uchicago.gerber.labjava.lec10.glab._01_basics.sleep;

public class SleepExample {

    public static void main(String[] args) {
        Thread waitingThread = new Thread(() -> {
            try {
                System.out.println("Waiting thread: Sleeping for up to 3 seconds...");
                Thread.sleep(3000);
                System.out.println("Waiting thread: Resumed after sleeping.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread notifyingThread = new Thread(() -> {
            try {
                System.out.println("Notifying thread: Sleeping for 5 seconds...");
                Thread.sleep(5000);
                System.out.println("Notifying thread: Finished sleeping.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        waitingThread.start();
        notifyingThread.start();
    }
}
