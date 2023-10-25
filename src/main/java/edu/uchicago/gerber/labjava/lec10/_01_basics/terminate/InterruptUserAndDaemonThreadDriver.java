package edu.uchicago.gerber.labjava.lec10._01_basics.terminate;

import java.util.Random;

public class InterruptUserAndDaemonThreadDriver {

    /*
    Scenario 1: Rogue child User-Thread
    //child.setDaemon(true);
    //child.interrupt();

     Scenario 2: child User-Thread interrupted (you must remember to call interrupt)
    //child.setDaemon(true);
    child.interrupt();

    Scenario 3: child Daemon-Thread terminates at the end of the lifecycle of its parent-Thread
    child.setDaemon(true);
    //child.interrupt(); //no need to interrupt


    Scenario 4: child Daemon-Thread terminates at the end of the lifecycle of its parent-Thread
    child.setDaemon(true);
    child.interrupt(); //this is ignored :(


     */


    public static void main(String[] args) {
        Thread child = new Thread(new Runnable() {
            private final Random random = new Random();

            //some long-running cpu-intensive operation
            @Override
            public void run() {
                //this is an infinite loop!
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


        child.setDaemon(true);
        child.start();

        // Let the main-thread sleep for one second
        try {
            Thread.sleep(1000);
            child.interrupt();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


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

