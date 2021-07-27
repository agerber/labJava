
/*
 * This code is used in conjunction with the classes SynchMain.java and
 * SynchBalance.java.  This particular class, when called, adds 100
 * to the balance.
 *
 * Note that because this code implements the Runnable interface, it can be
 * placed within a thread.
 */

package edu.uchicago.gerber.labjava.lec10.glab.more;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchAdder implements Runnable {

    private final int addAmount = 100;
    private SynchBalance synchBalance;
    
    public SynchAdder(SynchBalance targetBalance){
        this.synchBalance = targetBalance;
    }
    
    @Override
    public void run() {
        
        try {
            synchBalance.transact(addAmount);
            System.out.println("We added " + addAmount + " to the balance");
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchAdder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
