package edu.uchicago.gerber.labjava.lec10.glab.deadlock;

/**
 * Created by ag on 11/30/2014.
 */
public class DeadLockDriver {
    //notice that grandaddy Object has an implicit lock
    public static Object sLock1 = new Object();
    public static Object sLock2 = new Object();

    public static void main(String args[]) {

        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        threadDemo1.start();
        threadDemo2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (sLock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (sLock2) {
                    //this line is never reached because sLock2 is currently held
                    //and sLock1 is never released either because this does not terminate.
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (sLock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (sLock1) {
                    //this line is never reached because sLock1 is currently held
                    //and sLock2 is never released either because this does not terminate.
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}