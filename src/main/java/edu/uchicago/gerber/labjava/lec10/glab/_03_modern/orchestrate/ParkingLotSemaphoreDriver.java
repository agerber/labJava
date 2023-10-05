package edu.uchicago.gerber.labjava.lec10.glab._03_modern.orchestrate;

import java.util.concurrent.Semaphore;

public class ParkingLotSemaphoreDriver {

    /*
    Imagine a parking lot with a limited number of parking spaces. Multiple cars (threads) want to park in this parking lot. Once the parking lot is full, the next car has to wait until a parking spot becomes available.
     */
    private static final int MAX_PARKING_SPOTS = 5;
    private final Semaphore semaphore = new Semaphore(MAX_PARKING_SPOTS);

    public void park() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " trying to park");
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName() + " parked");
        Thread.sleep(2000); // simulate the car being parked for 2 seconds
        System.out.println(Thread.currentThread().getName() + " leaving");
        semaphore.release();
    }

    public static void main(String[] args) {
        ParkingLotSemaphoreDriver parkingLot = new ParkingLotSemaphoreDriver();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    parkingLot.park();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Car " + (i + 1)).start();
        }
    }
}
