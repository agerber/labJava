package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent.executor;

public class ThrashingExample {

    public static void main(String[] args) {
        // Create a large number of threads (e.g., 10,000)
        // This number may need to be adjusted based on the specific machine on which this is run.
        int numberOfThreads = 10_000;
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new ComputationTask()).start();
        }
    }

    static class ComputationTask implements Runnable {
        @Override
        public void run() {
            double sum = 0;
            // Performing some computation
            for (int i = 0; i < 1_000_000; i++) {
                sum += Math.sin(i) * Math.cos(i);
            }
            System.out.println(Thread.currentThread().getName() + ": " + sum);
        }
    }
}
