
/*
 * This class is used in conjunction with CollectionMain.java
 */

package edu.uchicago.gerber.labjava.lec10.glab.more;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionTask implements Runnable {

    CopyOnWriteArrayList list;
    
    // When this task is created, we receive the communal list
    
    public CollectionTask(CopyOnWriteArrayList list){
        this.list = list;
    }

   
    @Override
    public void run() {

        // >> This is where you would put in your actionable code << 
        
        Random random = new Random();
        
        for(int i = 0; i < 10; i++){

            // We put the thread to sleep for a short period of time
            // to allow for the opportunity of thread overalp on our list.
            
            try {
                Thread.sleep((long) Math.random() * 50 + 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            // We add our randomly generated number to the list
            // If we were using a regular array list, we'd have to use
            // if(!ArrayList.contains(value)) { ArrayList.add(value); }
            
            list.addIfAbsent(random.nextInt(10));

        }
  
       
    }
 
}
