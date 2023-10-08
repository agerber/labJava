package edu.uchicago.gerber.labjava.lec10.glab._04_modern.virtual;

public class VirtualThreadsMultipleExample {

    public static void main(String[] args) {

        // Number of virtual threads to create
        final int NUM_THREADS = 500;

        // Start multiple virtual threads
        for (int i = 0; i < NUM_THREADS; i++) {
            int finalI = i;
            Thread.ofVirtual().start(() -> {
                System.out.println("Running inside virtual thread #" + finalI + ": " + Thread.currentThread().getName());
                // Simulate some work
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Give virtual threads some time to finish
        try {
            Thread.sleep(5000); // This is just to ensure main doesn't exit too quickly. Ideally, you'd have a better synchronization mechanism.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}
