
/*****************************************************************************
 *
 * Program:     ExectutorMain
 * 
 * Purpose:     This program shows how to initiate and use an Executor to
 *              run multiple threads.  
 * 
 *              To see how to use an ExecutorService to initiate threads and
 *              process the results following each thread's completion, see
 *              the CallableMain.java class.
 * 
 *****************************************************************************/

package lec10.glab.more;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorMain {
    
    public static void main (String args[]){
     
        // To see the performance tuning opportunities with the newFixedThreadPool method,
        // try adjusting the total number of threads avaiable in a pool - try 2 threads, 10, 50 and 100.
        // Also compare the result by using a newCachedThreadPool, which will reuse threads when they are done.
        
        // Note that an executor is limited in what it can do - for example, with an executor you cannot
        // shut down an executor or determine whether a task is finished. You can't cancel a running task.
        // For those things, you need an Executor Service.
        
        Executor executor = Executors.newFixedThreadPool(10);
        // ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        
        for(int i = 0; i < 100; i++){
            ExecutorTask targetTask = new ExecutorTask("Thread ID " + i);
            executor.execute(targetTask);
        }
      
    }
    
}
