package edu.uchicago.gerber.labjava.lec10.glab._01_basics.terminate;

import java.util.Random;

public class InterruptUserThreadDriverGood {

    public static void main(String[] args) {
        Thread childThread = new Thread(new Runnable() {
            private final Random random = new Random();

            //some long-running cpu-intensive operation
            @Override
            public void run() {
                while (true) {
                    if (!Thread.interrupted()) {
                        long num = random.nextLong();
                        System.out.print("Checking if prime:  " + num + " -> prime? ");
                        System.out.println( isPrime(num));
                    } else {
                        System.out.println("Thread was interrupted!...");
                        System.out.println("perform any clean up of resources here like close a socket on a server, or close a connection to a database");
                        //perform any clean up of resources here.
                        return;  // Exit the thread
                    }
                }
            }
        });


        childThread.setDaemon(false);
        childThread.start();

        // Let the main-thread sleep for one second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }

        // Interrupt the main-thread
        Thread.currentThread().interrupt();
        //childThread.interrupt();

        System.out.println("Exiting main thread");

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

