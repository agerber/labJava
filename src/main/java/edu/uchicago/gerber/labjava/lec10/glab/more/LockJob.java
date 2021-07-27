
/*
 * This class is used in conjunction with the LockMain.java class.
 */

package edu.uchicago.gerber.labjava.lec10.glab.more;

// The LockJob is constructed with a LockTarget which is a task that whose 
// internal lock must be acquired by this LockJob before this LockJob can
// complete its job.

public class LockJob implements Runnable {

    private final LockTarget lockTarget;
    
    public LockJob(LockTarget lockTarget){
        this.lockTarget = lockTarget;
    }
    
    @Override
    public void run() {
        
        System.out.println("[LockJob   ] Thread ID # " + Thread.currentThread().getId() + ": going to start new job");
        
        // Tries to do the job (which requires acquiring the target's lock).  If the lock is
        // unavailable, the program blocks and waits.
        
        lockTarget.doJob(new Object());
        
        // Once the lock is freed, the job is completed and the program can continue.
        
        System.out.println("[LockJob   ] Thread I D# " + Thread.currentThread().getId() + ": job is finished");
    }
    
}
