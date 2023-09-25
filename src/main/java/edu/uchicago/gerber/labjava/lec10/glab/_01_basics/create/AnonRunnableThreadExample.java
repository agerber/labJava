package edu.uchicago.gerber.labjava.lec10.glab._01_basics.create;

public class AnonRunnableThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread's logic goes here
                System.out.println("Thread is running...");
            }
        });
        thread.start(); // Start the thread
    }
}
