package edu.uchicago.gerber.labjava.lec10.glab._01_basics.lifecycle;

public class ThreadLifeCycleWithMortality {

    public static void main(String[] args) {
        // Create a new thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("RUNNING: Inside the thread.");
            }
        });

        System.out.println(thread.getState() + ": Thread state after creation.");  // NEW

        // Start the thread
        thread.start();
        System.out.println(thread.getState() + ": Thread state after start.");  // RUNNABLE

        // Wait for the thread to finish to check its state
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getState() + ": Thread state after completion.");  // TERMINATED
    }
}
