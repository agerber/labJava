
/*******************************************************************************
 * 
 * Program:     LatchMain.Java
 * 
 * Purpose:     This program is designed to show the benefit of using a 
 *              CountDownLatch as a thread synchronized to better manage multiple 
 *              threads.  
 * 
 *              In this program, we pretend that we're setting up a multi-player 
 *              game. However, gameplay cannot commence until all 10 "warriors" 
 *              join the game. By using the CountDownLatch, we can more efficiently 
 *              manage thread execution to wait until all 10 players join and 
 *              the game can begin.
 * 
 *              If a multiplayer game doesn't seem appropriate to you, you can 
 *              imagine this same mechanism being used by a multi-threaded simulator
 *              that requires for a bunch of threads to be initialized before
 *              starting a complicated simulation.  Using the CountDownLatch 
 *              synchronizer, it's easy to set up such a program.
 * 
 * Source:      This code was adapted from an example using videoconferencing 
 *              as a metaphor in Gonzalez, Java 7 Concurrency Cookbook, (pp. 92-97).
 *
 *******************************************************************************/

package lec10.glab.more;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LatchMain {
       
    public static void main(String args[]){
       
       System.out.println("\n******************");
       System.out.println("*   DEMO BEGINS  *");
       System.out.println("******************\n");
        
       ExecutorService executor = (ExecutorService)Executors.newFixedThreadPool(11);
       
       LatchGame game = new LatchGame(10);
       executor.execute(game);
                    
       for (int i = 0; i < 10; i++) {
            LatchPlayer player = new LatchPlayer(game,"Warrior #" + i);
            executor.execute(player);
       }
    
       executor.shutdown();
       
    }
    
}
