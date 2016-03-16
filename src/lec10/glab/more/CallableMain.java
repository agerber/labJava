
/************************************************************
 * 
 * Program:     CallableMain
 * 
 * Purpose:     To show how to use a ThreadPoolExecutor to
 *              launch, cancel and retrieve data from a series of
 *              threads using the Executor and Future class framework.
 * 
 ************************************************************/

package lec10.glab.more;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableMain {
    
    public static void main (String args[]) throws InterruptedException {
        
        System.out.println("\n*************************");
        System.out.println("*   System Starting     *");
        System.out.println("*************************\n");
        
        // First, we create our Executor, which is used to execute and monitor callable objects. 
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
        
        // In this case, we created an Executor that will utilize a pool of 5 threads.
        // For example, we could have also used a .newCachedThreadPool() which re-uses threads 
        // once they are done and is useful for short-term asynchronous tasks.        
        
        // Next, we create a list of Future objects of the type <Integer>, since that's what
        // the CallableGenrator class returns.  This will allow us to monitor and manage the
        // thread's execution.
        
        List<Future<Integer>> resultList = new ArrayList<>();
        
        // For demonstration purposes, we create a random number generator
        
        Random random = new Random();
        
        // We then create 5 CallableGenerators (which implement the interface Callable<Integer>)
        // and seed them with a random number between 5000 to 8000.  This number tells the
        // CallableGenerator to sleep that many milliseconds before returning a random integer 
        // between 0 and 99. 
        
        for(int i = 0; i < 5; i++){
            
            Integer number = 5000 + random.nextInt(3000);
            CallableGenerator generator = new CallableGenerator(number);

            // When submitting the Callable Generator to the Executor, we receive back
            // a Future of the type <Integer> that we can use to both monitor the status of,
            // and get the value from, our generator. We can also use the Future to cancel
            // a running task.
            
            Future<Integer> result = executor.submit(generator);
                
            // We then add this future to our list of futures.  We will refer to this list
            // later on in this program.
            
            resultList.add(result);
        
        }
        
        System.out.println("All five threads have been created and started...");
        System.out.println("We'll wait three seconds to cancel third task ...");
        
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // We then ruthlessly cancel the third task in our list of futures, 
        // using the future object
        
        Future<Integer> noFuture = resultList.get(3);
        noFuture.cancel(true);
        
        TimeUnit.SECONDS.sleep(1);
        
        // With our thirst sated, we will wait until the rest of our tasks complete.
        
        do {
            
           System.out.println("Waiting for other tasks to complete ...");
           TimeUnit.SECONDS.sleep(1);
           
           
           // Because we used the ThreadPoolExecutor to construct our thread pool,
           // we can monitor the number of tasks that have completed before 
           // we continue processing.  This is not possible with the Executor or
           // ExecutorService interfaces.
           
         } while (executor.getCompletedTaskCount() < resultList.size());
     
        System.out.println("All remaining tasks are now completed!");
        
        // We then go through each future object on our list and retrieve the 
        // result from the associated CallableGenerator object.
        
        for (int i = 0; i < resultList.size(); i++){
            
            Future<Integer> finishedFuture = resultList.get(i);
            
            // We check to see if this particular future is cancelled; if so, 
            // we do not want to use the .get()method, as this will generate 
            // a CancellecedException error.
            
            try {
                 System.out.println("Task ID #: " + (i) + ") Cancelled? " + finishedFuture.isCancelled() + " Result = " + finishedFuture.get());
            } catch (CancellationException ex) {
                 System.out.println("Task ID #: " + (i) + ") Cancelled? " + finishedFuture.isCancelled() + " Result = 0"); 
            } catch (InterruptedException | ExecutionException ey){
                 ey.printStackTrace();                 
            } 
        }
        
        // Finally, we shut down the executor.  If we fail to do this, it may continue
        // running and cause us problems when we attempt to run this program again.

        // Note that when this is called, the executor waits for the completion of tasks that are running or waiting
        // for execution, and then finishes its execution. 
        
        executor.shutdown();

    }
}
