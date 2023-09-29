package edu.uchicago.gerber.labjava.lec10.glab._01_basics.create;


public class _02a_RunnableObjectThreadDriver {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start(); // Start the thread
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Thread's logic goes here
        System.out.println("I'm using my own CUSTOM ENGINE...");
    }
}

