package edu.uchicago.gerber.labjava.lec10.glab._01_basics.create;



public class _01_ExtendThreadDriver {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setPriority(Thread.MAX_PRIORITY); //optional
        thread.setName("MyThread"); // Set thread name
        thread.start(); // Start the thread
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        // Thread's logic goes here
        System.out.println("I'm using the ORIGINAL ENGINE of this thread...");
    }
}
