package edu.uchicago.gerber.labjava.lec10.glab._03_util_concurrent;

import java.util.concurrent.CountDownLatch;

public class RacingGameCountDownLatchDriver {

    /*
    Suppose we have a racing game where we want all players to start at the same time. We can use a CountDownLatch to ensure that all players are ready before the race starts and then begin the race simultaneously.

     Synchronization point: All threads are blocked until each of them completes its preparation, ensuring simultaneous start.
     */
    private static final int NUMBER_OF_PLAYERS = 5;
    private final CountDownLatch readyLatch = new CountDownLatch(NUMBER_OF_PLAYERS);

    public void playerReady(String player) throws InterruptedException {
        System.out.println(player + " is ready!");
        readyLatch.countDown();
        readyLatch.await(); // wait for all players to be ready
        System.out.println(player + " started racing!");
    }

    public static void main(String[] args) {
        RacingGameCountDownLatchDriver game = new RacingGameCountDownLatchDriver();
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            final String playerName = "Player " + (i + 1);
            new Thread(() -> {
                try {
                    game.playerReady(playerName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
