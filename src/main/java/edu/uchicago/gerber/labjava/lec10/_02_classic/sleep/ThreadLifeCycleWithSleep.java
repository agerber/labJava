package edu.uchicago.gerber.labjava.lec10._02_classic.sleep;

public class ThreadLifeCycleWithSleep {


    //there is no wait() and notify() call with sleep(). The O/S Thread schedule pauses the thread and wakes it up on
    //The Thread Schedulers own timer.  This thread is consuming zero resources while its sleeping.
    public static void main(String[] args) {
        // Create a new child Thread
        Thread child = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("RUNNING: Inside the child. Going to sleep for 2 seconds.");
                System.out.println("....SLEEPING for 2 seconds ...");

                try {
                    // Make the child sleep for 2 seconds
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("RUNNING: Thread waking up and ending.");
            }
        });

        System.out.println(child.getState() + ":Thread state after creation.");  // NEW

        // Start the child
        child.start();

        System.out.println(child.getState() + ":Thread state after start.");  // RUNNABLE

        // Wait for the child to finish to check its state
        try {
            child.join();
        } catch (InterruptedException e) {
            System.out.println("Cleaning up " + e.getMessage());
        }
        System.out.println(child.getState() + ": Thread state after completion.");  // TERMINATED

    }
}
