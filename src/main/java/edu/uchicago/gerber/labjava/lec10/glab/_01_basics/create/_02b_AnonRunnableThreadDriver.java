package edu.uchicago.gerber.labjava.lec10.glab._01_basics.create;

public class _02b_AnonRunnableThreadDriver {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Thread's logic goes here
                System.out.println("I'm using my own CUSTOM ENGINE...");
            }
        });
        thread.start(); // Start the thread
    }
}
