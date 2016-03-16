
/* 
 * This code is to be used in conjunction with the LatchMain.java class. 
 */

package lec10.glab.more;

import java.util.concurrent.CountDownLatch;

public class LatchGame implements Runnable {
    
    private final CountDownLatch controller; // This is our latch

    // When our game is constructed, we tell it how many players will be joining
    
    public LatchGame(int number){
        
        System.out.println("A new game has been initialized ...");
        controller = new CountDownLatch(number);
    }
    
    public void arrive(String name){
        System.out.printf("%s has arrived ... \n",name);
        controller.countDown(); // This is critical as it tells the latch that we're getting closer to goal
        System.out.printf("still waiting for %d participants.\n",controller.getCount());
    }
 
    @Override
    public void run() {
        
        // >> This is where you would put in your actionable code << 
        
        System.out.println("Launching game with " + controller.getCount() + " players ... \n");
        
        try {
            controller.await(); // We pause this thread until our latch has reached zero
            System.out.println("\nAll the players have arrived!");
            System.out.println("Let the games begin!");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        
    }
       
}
