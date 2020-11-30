
/*
 * This class should be viewed in conjunction with ForkJoinMain.java
 * 
 * It is based on code found at:
 * http://www.javacodegeeks.com/2013/02/java-7-forkjoin-framework-example.html
 */

package lec10.glab.paralellism;

import java.util.concurrent.RecursiveTask;

// Note that as a designated recursiveTask, this class must implement the
// "compute()" method below and return an integer.  If we had, instead,
// worked on a project that did not need us to return a value, we could extend
// the RecursiveAction class.

// In this case, we are returning an integer.

public class ForkJoinTask extends RecursiveTask<Integer> {

    // This value tells us that if we are examining a list that has less
    // than 5 elements in it, we will search for the lowest value by simply
    // looping through the list and identifying the lowest value.
    
    private static final int THRESHOLD = 10;
        
    private final int[] data;
    private final int start;
    private final int end;
    
    // We actually have two constructors, one of which takes just a list of 
    // data while the other takes the data, plus a start and end point.
    
    public ForkJoinTask(int[] data, int start, int end){
        this.data = data;
        this.start = start;
        this.end = end;
    }
    
    public ForkJoinTask(int[] data){
        this(data,0,data.length);
    }
    
    // This method is required by the fact that we're extending the RecursiveTask<Integer>
    // class.  This method checks to see if our current list is less than 'Threshold'
    // elements, and if so, passes it to the computeDirectly() method; otherwise, it splits
    // the task into two subtasks which each begin this process again.
    
    @Override
    protected Integer compute() {
        
        // >> This is where you would put in your actionable code << 
        // >> if you were performing a different task. <<
        
        final int length = end - start;
        
        if (length < THRESHOLD) {
            return computeDirectly();
        }
        
        final int split = length / 2;
        final ForkJoinTask left = new ForkJoinTask(data, start, start + split);
        
        left.fork(); // We send it off to be executed on a separate thread
        
        final ForkJoinTask right = new ForkJoinTask(data, start + split, end);
        
        // By calling the left.join() method, we retrieve the value from the 
        // left fork after it is completed.
        
        return Math.min(right.compute(), left.join());
    }
    
    // This simple method finds the lowest value in a list by looping through
    // each element.  It is only used on lists that have fewer than 'THRESHOLD'
    // elements in it (default value is 5).
    
    private Integer computeDirectly() {

        System.out.print(Thread.currentThread() +  " computing elements " + start + " to " + end + " : ");
        for (int nC = start; nC <end ; nC++) {
            System.out.print(data[nC] + " ");
        }
        System.out.println();
      //  System.out.println(" computing elements " + start + " to " + end);
        int min = Integer.MAX_VALUE;
        
        for (int i = start; i < end; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }
      
}
