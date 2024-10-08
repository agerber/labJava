package edu.uchicago.gerber.labjava.lec10._XX_extra.vol_broken;

class SharedCounter {
    /*
    volatile provides visibility guarantees, it doesn't guarantee atomicity.
    The increment operation here (counter++) is not atomic, so if multiple threads were
    incrementing the counter simultaneously, you could still encounter race conditions.
     */
    private volatile int counter = 0;

    public int incrementAndGet() {
     return  ++counter;
    }

    public int getCounter() {
        return counter;
    }
}

public class VolatileIntExampleBroken {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        // Thread to increment the counter
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(":::::Increment counter value: " + sharedCounter.incrementAndGet());

                try {
                    Thread.sleep(1); // Adding a delay for demonstration purposes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Thread to increment the counter
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(":::::Increment counter value: " + sharedCounter.incrementAndGet());

                try {
                    Thread.sleep(1); // Adding a delay for demonstration purposes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
