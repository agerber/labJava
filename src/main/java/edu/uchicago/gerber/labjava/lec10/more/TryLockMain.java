
/*******************************************************************************
 *
 * Program:         TryLockMain.java
 * 
 * Purpose:         To show how to use the TryLock method to avoid blocking
 *                  when attempting to access a shared resource across multiple
 *                  threads.  In this example, we pass a lock to three instances
 *                  of a runnable task, each of which attempt to complete a 5
 *                  second task by unlocking the lock. If they are unable to 
 *                  unlock the lock, they indicate so and try again in 1 second.
 *  * 
 * Source:          This example was adapted from code found at:
 *                  http://robaustin.wikidot.com/reentrantlock. 
 * 
 *******************************************************************************/

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockMain {

    // We create a new lock that we're going to pass to each job.
    
    final Lock passLock = new ReentrantLock();
    
    public static void main(String args[]){
        new TryLockMain().go();
    }
    
    private void go() {
        
        System.out.println("\n*********************");
        System.out.println("*   STARTING DEMO   *");
        System.out.println("*********************\n");
                
        ExecutorService executor = (ExecutorService)Executors.newFixedThreadPool(3);
        
        for(int i = 0; i < 3; i++){
            TryLockJob job = new TryLockJob(passLock);
            executor.execute(job);
        }

        executor.shutdown();
        
    }
    
}
