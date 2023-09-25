package edu.uchicago.gerber.labjava.lec10.glab._01_basics.create;

class MyThread extends Thread {
    @Override
    public void run() {
        // Thread's logic goes here
        System.out.println("Thread is running...");
    }
}

public class ExtendThreadExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setName("MyThread"); // Set thread name
        thread.start(); // Start the thread
    }
}
