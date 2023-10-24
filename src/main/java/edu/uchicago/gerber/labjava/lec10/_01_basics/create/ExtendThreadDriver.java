package edu.uchicago.gerber.labjava.lec10._01_basics.create;



public class ExtendThreadDriver {
    public static void main(String[] args) {

        MyThread thread = new MyThread(); //use the original engine
        thread.start(); // turn the key
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        // Thread's running logic goes here. Anything in this method will happen on the MyThread thread.
        System.out.println("I'm using the ORIGINAL ENGINE of this thread...");
    }
}
