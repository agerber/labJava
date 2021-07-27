
/*
 * This class is used in conjunction with the AtomicMain.java class to demonstrate
 * the use of Atomic variables to maintain data integrity.
 */

package edu.uchicago.gerber.labjava.lec10.glab.more;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AtomicSubtractor implements Runnable {
    
    private final int reductionAmount = -100;
    private final AtomicBalance atomicBalance;
    
    public AtomicSubtractor(AtomicBalance targetBalance){
        this.atomicBalance = targetBalance;
    }
    
    @Override
    public void run() {
        try {
            atomicBalance.transact(reductionAmount);
             System.out.println("We reduced the balance by " + reductionAmount);
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchSubtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}