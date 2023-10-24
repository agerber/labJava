package edu.uchicago.gerber.labjava.lec10._01_basics.create;


public class RunnableObjectThreadDriver {
    public static void main(String[] args) {

        MyRunnable runnable = new MyRunnable(); //this is the engine
        Thread thread = new Thread(runnable); //put the engine in the car
        thread.start(); // turn the key
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

