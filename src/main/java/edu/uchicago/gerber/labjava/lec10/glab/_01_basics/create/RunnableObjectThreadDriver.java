package edu.uchicago.gerber.labjava.lec10.glab._01_basics.create;


public class RunnableObjectThreadDriver {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start(); // Start the thread
    }
}

//we defined an inner class that implements the Runnable interface.
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Thread's logic goes here
        System.out.println("I'm using my own CUSTOM ENGINE...");
    }
}

