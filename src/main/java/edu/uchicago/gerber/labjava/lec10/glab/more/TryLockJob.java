
/*
 * Use this class in conjunction with TryLockMain.java
 */

package edu.uchicago.gerber.labjava.lec10.glab.more;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class TryLockJob implements Runnable {

    private final Lock passLock;
    
    // We receive the lock as part of the object construction process
    
    public TryLockJob(Lock passLock){
        this.passLock = passLock;
    }
    
    @Override
    public void run() {

        do {
            try {
                if(passLock.tryLock(1, TimeUnit.SECONDS)) {
                                                            
                    try {
                       System.out.println("Thread ID #" + Thread.currentThread().getId() + " successfully acquired thread lock.");
                       // ***** DO PROTECTED WORK HERE ****** //
                       Thread.sleep(5000);
                    } finally {
                       passLock.unlock();
                       System.out.println("Thread ID #" + Thread.currentThread().getId() + " is finished and unlocked thread lock.");
                    }
                    break;
                } else {
                  System.out.println("Thread ID #" + Thread.currentThread().getId() + " unable to acquire thread lock and will try again.");
                   // ****** DO OTHER WORK WHILE WAITING FOR LOCK RELEASE ******* //
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        } while (true);
    }
}
