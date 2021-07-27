/*******************************************************************************
 * 
 * Program:     SemaphoreMain.java
 * 
 * Purpose:     To demonstrate the use of semaphores to allow for shared
 *              but managed access to a shared resource.  In this program, we
 *              create a "semaphorequeue" (which we could imagine to be any
 *              shared resource, like an output device, etc.) and we create
 *              10 jobs that seek to use this queue.  As each job starts,
 *              we see that only the first 2 jobs finish immediately, and then
 *              the other jobs in turn are able to start and finish. This is 
 *              because we initialized our semaphore (in class SemaphoreQueue)
 *              with a value of 2.
 * 
 *              We could have also used the tryAcquire method to gain the semaphore,
 *              much as with a lock, which would give us the ability to do other
 *              business while we await for the semaphore to become free again.
 * 
 * Source:      This code was adapted from Gonzalez, Java 7 Concurrency Cookbook, pp. 84-87.
 * 
 *******************************************************************************/

package edu.uchicago.gerber.labjava.lec10.glab.more;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreMain {

    public static void main(String args[]){
        
        SemaphoreQueue semaphorequeue = new SemaphoreQueue();
        ExecutorService executor = (ExecutorService)Executors.newFixedThreadPool(10);
        
        for(int i = 0; i < 10; i++){
            SemaphoreJob job = new SemaphoreJob(semaphorequeue);
            executor.execute(job);
        }

        executor.shutdown();
        
    }
    
}
