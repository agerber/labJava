package edu.uchicago.gerber.labjava.lec10.glab._01_basics.daemon;

public class DaemonThreadExample {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Daemon thread is running...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true); // Set the thread as daemon
        daemonThread.start();

        try {
            Thread.sleep(5000);
            System.out.println("Main thread is ending.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
