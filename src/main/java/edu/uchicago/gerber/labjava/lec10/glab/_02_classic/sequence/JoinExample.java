package edu.uchicago.gerber.labjava.lec10.glab._02_classic.sequence;

public class JoinExample {
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

        try {
            workerThread.join();  // Main thread waits for workerThread to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completes after worker thread.");
    }
}
