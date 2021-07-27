
/*
 * This class should be used in conjunction with the SemaphoreMain.java class.
 */

package edu.uchicago.gerber.labjava.lec10.glab.more;

import java.util.concurrent.Semaphore;

public class SemaphoreQueue {

    private final Semaphore semaphore;
    
    public SemaphoreQueue() {
        
        // We initialize our semaphore with a value of 2.  We could initialize it
        // with a value greater of 1 -- which would make the semaphore akin to a lock,
        // (or N), which would allow 'N' threads to access the queue simultaneously. 
        
        semaphore = new Semaphore(2);
    }
    
    public void doJob (Object targetObject){
        
        try {
            semaphore.acquire();
            
            // >> This is where you would put in your actionable code << 
            
            System.out.println("Job commenced");
            Thread.sleep((long)Math.random() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
                      
    }
    
}
