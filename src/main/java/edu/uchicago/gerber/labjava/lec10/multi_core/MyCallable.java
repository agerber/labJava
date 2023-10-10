package edu.uchicago.gerber.labjava.lec10.multi_core;

/**
 * Created by ag on 11/30/2014.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//http://www.journaldev.com/1090/java-callable-future-example
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(10);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

    public static void main(String args[]){

        int nNumProcessor = Runtime.getRuntime().availableProcessors();
        System.out.println("number of available cores: " + nNumProcessor);
        ExecutorService executor = Executors.newFixedThreadPool(nNumProcessor);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        //Create MyCallable instance
        Callable<String> callable = new MyCallable();
        for(int i=0; i< 100; i++){
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }
        for(Future<String> fut : list){
            try {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(new Date()+ "::"+fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
        System.out.println("done");
    }

}
