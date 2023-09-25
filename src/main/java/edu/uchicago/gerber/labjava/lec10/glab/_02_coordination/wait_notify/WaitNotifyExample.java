package edu.uchicago.gerber.labjava.lec10.glab._02_coordination.wait_notify;

class NumberPrinter {
    private int count = 1;
    private final int maxCount = 10;

    public synchronized void printEven() throws InterruptedException {
        while (count <= maxCount) {
            if (count % 2 == 0) {
                System.out.println("Even: " + count);
                count++;
                notify();
            } else {
                wait();
            }
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (count <= maxCount) {
            if (count % 2 != 0) {
                System.out.println("Odd: " + count);
                count++;
                notify();
            } else {
                wait();
            }
        }
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        final NumberPrinter printer = new NumberPrinter();

        Thread evenThread = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
