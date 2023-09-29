package edu.uchicago.gerber.labjava.lec10.glab._01_basics.interrupt;

import java.util.Random;

public class InterruptCheckCorrectDriver {
    public static void main(String[] args) {
        Thread workerThread = new Thread(new Runnable() {
            private final Random random = new Random();

            //some long-running cpu-intensvie operation
            @Override
            public void run() {
                while (true) {
                    if (!Thread.interrupted()) {
                        long num = random.nextLong();
                        System.out.print("Checking if prime:  " + num + " -> prime? ");
                        System.out.println( isPrime(num));
                    } else {
                        System.out.println("Thread was interrupted!...");
                        System.out.println("Closing any open connections or cleaning up resources");
                        //perform any clean up of resources here.
                        return;  // Exit the thread
                    }
                }
            }
        });

        workerThread.start();

        // Let the thread run for two seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the worker thread
        workerThread.interrupt();
    }


    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        long i = 5, w = 2;
        while (i * i <= n) {
            if (n % i == 0) return false;

            i += w;
            w = 6-w;
        }
        return true;
    }
}

