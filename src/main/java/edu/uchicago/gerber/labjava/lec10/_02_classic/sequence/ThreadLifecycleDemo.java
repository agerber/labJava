package edu.uchicago.gerber.labjava.lec10._02_classic.sequence;

public class ThreadLifecycleDemo {

    public static void main(String[] args) throws InterruptedException {
        // Create a new thread (State: NEW)
        Thread thread = new Thread(() -> {
            // This print will represent the RUNNABLE state
            System.out.println("Thread state inside the thread: " + Thread.currentThread().getState().toString().toUpperCase());

            synchronized (ThreadLifecycleDemo.class) {
                try {
                    // Wait indefinitely (State: WAITING)
                    ThreadLifecycleDemo.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Thread state after creation: " + thread.getState().toString().toUpperCase()); // NEW

        // Start the thread (State: RUNNABLE)
        thread.start();

        // Sleep the main thread for a short time to ensure the new thread starts executing
        Thread.sleep(100);
        System.out.println("Thread state after sleep method: " + thread.getState().toString().toLowerCase()); //
        // RUNNABLE

        // Notify the waiting thread so that it can continue its execution and eventually terminate
        synchronized (ThreadLifecycleDemo.class) {
            ThreadLifecycleDemo.class.notify();
        }

        // Wait for the thread to finish its execution
        thread.join();
        System.out.println("Thread state after completion: " + thread.getState().toString().toUpperCase()); // TERMINATED
    }
}
