package edu.uchicago.gerber.labjava.lec10._02_classic.sleep;

public class CreateSimpleThread {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });

        thread.start();

    }
}
