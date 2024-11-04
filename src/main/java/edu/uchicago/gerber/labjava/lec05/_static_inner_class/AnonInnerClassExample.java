package edu.uchicago.gerber.labjava.lec05._static_inner_class;

public class AnonInnerClassExample {
    public static void main(String[] args) {
        // Create a new thread using an anonymous inner class implementing Runnable
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running in a separate thread using an anonymous inner class!");
            }
        });

        // Start the thread
        thread.start();
    }
}
