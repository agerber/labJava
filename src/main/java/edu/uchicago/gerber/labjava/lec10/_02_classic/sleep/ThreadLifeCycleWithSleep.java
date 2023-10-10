package edu.uchicago.gerber.labjava.lec10._02_classic.sleep;

public class ThreadLifeCycleWithSleep {


    //there is no wait() and notify() call with sleep(). The O/S Thread schedule pauses the thread and wakes it up.
    public static void main(String[] args) {
        // Create a new thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("RUNNING: Inside the thread. Going to sleep for 2 seconds.");
                System.out.println("....SLEEPING....");

                try {
                    // Make the thread sleep for 2 seconds
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("RUNNING: Thread waking up and ending.");
            }
        });

        System.out.println(thread.getState() + ":Thread state after creation.");  // NEW

        // Start the thread
        thread.start();

        System.out.println(thread.getState() + ":Thread state after start.");  // RUNNABLE

        // Wait for the thread to finish to check its state
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getState() + ": Thread state after completion.");  // TERMINATED
    }
}
