package edu.uchicago.gerber.labjava.lec10.glab._01_basics.interrupt;

public class InterruptExample {
    public static void main(String[] args) {
        // Create a new thread
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();

        // Sleep the main thread for 3 seconds and let myThread run concurrently
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the thread background thread
        myThread.interrupt();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("Running... " + (i += 10));

            // Sleep for 1 second
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
                break; // Break out of the loop and end the thread
            }
        }
    }
}
