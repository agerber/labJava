package edu.uchicago.gerber.labjava.lec10._02_classic.sequence;

public class NoJoinExample {
    public static void main(String[] args) {
        Thread workerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Worker Thread: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        workerThread.start();

        // No join() here

        System.out.println("Main thread might complete before or during the worker thread execution.");
    }
}
