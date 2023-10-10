
/*
 * This code is used in conjunction with the classes SynchMain.java and
 * SynchBalance.java.  This particular class, when called, subtracts 100
 * to the balance.
 *
 * Note that because this code implements the Runnable interface, it can be
 * placed within a thread.
 */

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchSubtractor implements Runnable {
    
    private final int reductionAmount = -100;
    private final SynchBalance synchBalance;
    
    public SynchSubtractor(SynchBalance targetBalance){
        this.synchBalance = targetBalance;
    }
    
    @Override
    public void run() {
        try {
            synchBalance.transact(reductionAmount);
             System.out.println("We reduced the balance by " + reductionAmount);
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchSubtractor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
