
/* 
 * This code is to be used in conjunction with the LatchMain.java class. 
 */

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.concurrent.TimeUnit;

public class LatchPlayer implements Runnable  {
    
    private final LatchGame latchGame;
    private final String playerName;
    
    // When we create our player, we tell it which game to join and give a name
    
    public LatchPlayer(LatchGame latchGame, String name){
        this.latchGame = latchGame;
        this.playerName = name;
    }
    
    @Override
    public void run() {
        
        // Before joining the game, the player sleeps between 5 and 15 seconds
        
        try {
            TimeUnit.SECONDS.sleep(5 + (long)(Math.random()*10));
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        
        // The player then joins the game
        
        latchGame.arrive(playerName);
        
    }
    
    
}
