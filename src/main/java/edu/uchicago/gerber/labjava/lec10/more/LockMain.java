
/*****************************************************************
 * 
 * Program:     LockMain.java
 * 
 * Purpose:     To demonstrate the ease and utility of using the
 *              java.concurrent.lock mechanism to ensure data
 *              integrity
 * 
 *****************************************************************/

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockMain {
    
    public static void main (String args[]){
        
        // We first create a LockTarget object, which has its own lock
        // that must be acquired by a thread before it can do its job.
        
        LockTarget lockTarget = new LockTarget();
        ExecutorService executor = (ExecutorService)Executors.newFixedThreadPool(10);
                
        // We then create 10 LockJobs that will attempt to access the LockTarget
        // (and its single lock) to complete their jobs.
        
        for(int i = 0; i < 10; i++){
           executor.execute(new LockJob(lockTarget));
        }
        
        executor.shutdown();
        
    }
}
