package edu.uchicago.gerber.labjava.lec10._03_util_concurrent.orchestrate;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ParkingLotSemaphoreDriver {

    Random random = new Random();
    private static final int MAX_PARKING_SPOTS = 5;
    private final Semaphore semaphore = new Semaphore(MAX_PARKING_SPOTS);

    public void park() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " trying to park");
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName() + " parked");
        Thread.sleep(random.nextInt(2000)); // simulate the car being parked for up to 2 seconds
        System.out.println(Thread.currentThread().getName() + " leaving");
        semaphore.release();
    }

    public static void main(String[] args) {
        ParkingLotSemaphoreDriver parkingLot = new ParkingLotSemaphoreDriver();
        int count = 0;
        while (count++ < 10) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        parkingLot.park();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Car " + (count)).start();
        }
    }
}
