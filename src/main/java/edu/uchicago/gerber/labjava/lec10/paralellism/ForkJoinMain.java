
/*******************************************************************************
 * 
 * Program:         ForkJoinMain.java
 * 
 * Purpose:         To demonstrate the fork/join framework.  In this program, 
 *                  we create an array of 100,000 random integers ranging from  
 *                  0 to 99,999 and we seek to find the lowest value.  
 * 
 *                  To do this, we create a task that does this by breaking up
 *                  the data in half, recursively, until less than 5 elements
 *                  appear in the data list, and then finds the lowest
 *                  integer value iteratively.  It uses the fork/join framework
 *                  to allocate portions of this task to background threads.
 *                  Be sure to check out the code in "ForkJoinTask.java" for
 *                  more information on how this is done.
 * 
 * Source:          This program is based on code found at:
 *                  http://www.javacodegeeks.com/2013/02/java-7-forkjoin-framework-example.html
 *
 *******************************************************************************/

package edu.uchicago.gerber.labjava.lec10.paralellism;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinMain {

    public static void main(String args[]){
        
        // We first create a data array of 100,000 random integers
        // ranging from 0 to 99,999
        
        final int data[] = new int[100_000];
        final Random random = new Random();
        
        for(int i = 0; i < data.length; i++){
            data[i] = random.nextInt(100_000);
        }
        
        // We then create a Fork/Join pool with 4 threads in it
        // and pass along the task for it to run.
        
        final ForkJoinPool pool = new ForkJoinPool(4);
        final ForkJoinTask task = new ForkJoinTask(data);
        
        System.out.println("The lowest number found is " + pool.invoke(task));
                
    }
    
}
