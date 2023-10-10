
/*******************************************************************************
 * 
 * Program:         CollectionMain.java
 * 
 * Purpose:         To demonstrate the use of thread-safe collections.  
 * 
 *                  In this example, we are using the CopyOnWriteArrayList which
 *                  which allows for concurrent reading and writing on a list. 
 *                  Specifically, we create a new CopyOnWriteArrayList in our
 *                  main thread, and then pass this list to 25 instances of the
 *                  CollectionTask class, each of which in turn roll 10 random numbers
 *                  (values range from 0-9) and only add them to the list if they don't
 *                  already appear there.  We use the method ".addIfAbsent" which 
 *                  encapsulates the two commands .contains and .add to ensure that
 *                  no two threads simultaneously add the same value to the list.
 * 
 *                  Note that there are MANY other thread-safe collections in Java 
 *                  that perform a wide variety of functions.
 * 
 *******************************************************************************/

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CollectionMain {
    
    public static void main (String args[]){
     
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        
        ArrayList<Future<?>> futureList = new ArrayList<>();
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(25);
        
        // We create 25 instances of the CollectionTask object, pass our list to it
        // and start them running. Each will attempt to add random numbers to our list only
        // if those numbers aren't already there.
        
        for(int i = 0; i < 25; i++){
            CollectionTask task = new CollectionTask(list);
            futureList.add(executor.submit(task));
        }

        // We then wait for the process to complete
        
        do {
            
        } while (executor.getCompletedTaskCount() < futureList.size());
                
        executor.shutdown();
        
        // We then go through our list (which has been shared amongst 25 threads)
        // and list the contents.  We should not see any integer appear more than once.
        
        // Note that when using an interator with a CopyOnWriteArray,
        // you cannot remove an element.
        
        Iterator itr = list.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
                
    }
    
}
