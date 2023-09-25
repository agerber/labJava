package edu.uchicago.gerber.labjava.lec10.glab._01_basics.naming;

public class ThreadNamingExample {

    public static void main(String[] args) {
        // Creating a thread using an anonymous inner class and naming it
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printThreadName();
            }
        }, "First Thread");  // Set the name of the thread via param

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printThreadName();
            }
        });
        // Set the name of the thread via method
        thread2.setName("Second Thread");

        // Start the threads
        thread1.start();
        thread2.start();
    }

    // Utility function to print the name of the current thread
    public static void printThreadName() {
        String threadName = Thread.currentThread().getName();
        System.out.println("This is: " + threadName);
    }
}

