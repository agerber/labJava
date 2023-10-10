
/*
 * Used in conjunction with the ExecutorMain.java class.
 * This class implements the Runnable interface, and therefore can be 
 * executed and monitored by an Executor.
 */

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.Date;

public class ExecutorTask implements Runnable {

    final private String name;
    
    public ExecutorTask(String targetName){
        this.name = targetName;
    }
    
    @Override
    public void run() {
        
        // >> This is where you would put in your actionable code << 
        
        System.out.println(this.name + " starting at " + new Date());
        
        try{
            Thread.sleep((long)(Math.random() * 3000));
        } catch (InterruptedException e) {
            
        }
        
        System.out.println(this.name + " ending at " + new Date());
        
    }
    
}
