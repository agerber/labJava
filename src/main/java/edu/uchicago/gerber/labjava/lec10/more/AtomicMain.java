
/*******************************************************************************
 *
 * Program:     AtomicMain
 * 
 * Purpose:     Demonstrate the implementation of Atomic variables in Java.  This
 *              code is essentially a revision of the program "SynchMain" which
 *              shows how to correctly structure a program so that attempts by
 *              concurrent threads to change a data value do not interfere with
 *              one another.   
 * 
 *              In this program, we set up a "balance" object and then launch
 *              "adders" and "subtractors" to add and subtract value from this 
 *              balance.  As these objects run on separate threads, there's a risk
 *              of data contention - that is, two threads could read the value
 *              simultaneously and adjust it, leading to an incorrect outcome.
 * 
 *              When the program is running "correctly", the starting balance and
 *              the ending balance should be 100.  If we decide to remove the
 *              use of atomic variables (see the AtomicBalance class for info on how
 *              to do this), we will end up with an incorrect ending balance.
 * 
 ******************************************************************************/

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtomicMain {

    public static void main (String args[]) {
    
        AtomicBalance balance = new AtomicBalance(100);
        ArrayList<Thread> threadList = new ArrayList<>();
        
        System.out.println("Beginning amount = 100");
        
        for(int i = 0; i < 10; i++){
            
            AtomicAdder adder = new AtomicAdder(balance);
            AtomicSubtractor subtractor = new AtomicSubtractor(balance);

            Thread addThread = new Thread(adder);
            Thread subThread = new Thread(subtractor);
            
            threadList.add(addThread);
            threadList.add(subThread);
            
            addThread.start();
            subThread.start();
           
        }
        
        // After we have launched all of our threads, we call the "join" method
        // so that the program's flow will wait until all of the threads are completed.
        // At this point, we can present the ending balance.
        
        for (Thread thread : threadList) {
            
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(SynchMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Ending amount = " + balance.currentAmount());
        
    
    }
}
