package edu.uchicago.gerber.labjava.lec10._XX_extra;

import java.util.Random;

public class InterruptUserThreadRogueDriver {

    public static void main(String[] args) {
        Thread userThread = new Thread(new Runnable() {
            private final Random random = new Random();

            //some long-running cpu-intensvie operation
            @Override
            public void run() {
                while(true){
                    long num = random.nextLong();
                    System.out.print("Checking if prime:  " + num + " -> prime? ");
                    System.out.println( isPrime(num));
                }
            }
        });

        userThread.start();

        // Let the main-thread run for two seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the user thread
        userThread.interrupt();
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

