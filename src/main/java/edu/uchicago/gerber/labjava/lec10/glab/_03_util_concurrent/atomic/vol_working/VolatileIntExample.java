package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent.atomic.vol_working;

class SharedCounter {
    /*
    volatile provides visibility guarantees, it doesn't guarantee atomicity.
    The increment operation here (counter++) is not atomic, so if multiple threads were
    incrementing the counter simultaneously, you could still encounter race conditions.
     */
    private volatile int counter = 0;

    public int incrementAndGet() {
     return    ++counter;
    }

    public int getCounter() {
        return counter;
    }
}

public class VolatileIntExample {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        // Thread to increment the counter
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(":::::Increment counter value: " + sharedCounter.incrementAndGet());

                try {
                    Thread.sleep(100); // Adding a delay for demonstration purposes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Thread to monitor the counter
        new Thread(() -> {
            int lastValue = -1;
            while (true) {
                int currentValue = sharedCounter.getCounter();
                if (currentValue != lastValue) {
                    System.out.println("Monitor counter value: " + currentValue);
                    lastValue = currentValue;
                }
                if (currentValue == 10) { // Stops monitoring after reaching 10
                    break;
                }
            }
        }).start();
    }
}
