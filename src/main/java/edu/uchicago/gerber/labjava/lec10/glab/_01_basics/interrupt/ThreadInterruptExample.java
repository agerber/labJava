package edu.uchicago.gerber.labjava.lec10.glab._01_basics.interrupt;

public class ThreadInterruptExample {

    public static void main(String[] args) {
        Thread longRunningThread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread was interrupted. Exiting...");
                    break; // Exit the loop and end the thread
                }

                System.out.println("Thread is running...");
                try {
                    // Simulate some work with sleep
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread sleep was interrupted. Handling interruption...");
                    // Important: Restore the interrupted status after catching the exception
                    Thread.currentThread().interrupt();
                }
            }
        });

        longRunningThread.start();

        // Let the thread run for a bit
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread: Interrupting the long running thread...");
        longRunningThread.interrupt(); // Interrupt the long-running thread
    }
}

