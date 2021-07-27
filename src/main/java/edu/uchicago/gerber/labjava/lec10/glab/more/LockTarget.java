
/*
 * This class is used in conjunction with the LockMain.java class.
 */

package edu.uchicago.gerber.labjava.lec10.glab.more;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTarget {

    // The target has its own lock
    
    private final Lock targetLock = new ReentrantLock();
    
    public void doJob(Object target){

        // Before continuing, it acquires the lock
        // If it is unable to do so, it waits.
        
        targetLock.lock();
        
        try {
            
            // >> This is where you would put in your actionable code << 
            
            Long sleepInterval = ((long)Math.random()) * 5000 + 1000;
            
            // This could be accessing an output resource
            
            System.out.println("[LockTarget] Thread ID # " + Thread.currentThread().getId() + ": started job at " + new Date());
            Thread.sleep(sleepInterval);
            System.out.println("[LockTarget] Thread ID # " + Thread.currentThread().getId() + ": finished job at " + new Date());
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            targetLock.unlock(); 
            // It is a requirement to include the targetLock.unlock() call as part of "finally", so that
            // in the event that the thread crashes (or is interrupted), the lock is released no matter what.
        }
    
    }
    
}