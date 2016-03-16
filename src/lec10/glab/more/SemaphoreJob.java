
/*
 * This class should be used in conjunction with the SemaphoreMain.java class.
 */

package lec10.glab.more;

public class SemaphoreJob implements Runnable {
    
    private SemaphoreQueue semaphorequeue;
    
    public SemaphoreJob(SemaphoreQueue semaphorequeue){
        this.semaphorequeue = semaphorequeue;
    }

    public void run() {
        System.out.println("Thread ID# " + Thread.currentThread().getId() + " starting job");
        
        // At this point, the job attempts to use the queue but it may have to wait, if more than
        // the allowed number of threads is seeking to use this resource.
        
        semaphorequeue.doJob(new Object());
        
        System.out.println("Thread ID# " + Thread.currentThread().getId() + " job has finished.");
    }
    
}
