package edu.uchicago.gerber.labjava.lec10.glab._01_basics.daemon;

public class NonDaemonThreadExample {
    public static void main(String[] args) {
        Thread nonDaemonThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Non-daemon thread is running...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Notice that we do not set it as daemon
        nonDaemonThread.start();

        try {
            Thread.sleep(5000);
            System.out.println("Main thread is ending.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
