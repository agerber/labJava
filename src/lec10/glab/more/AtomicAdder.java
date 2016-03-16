
/*
 * This class is used in conjunction with the AtomicMain.java class to demonstrate
 * the use of Atomic variables to maintain data integrity.
 */

package lec10.glab.more;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AtomicAdder implements Runnable {
    
    private final int addAmount = 100;
    private AtomicBalance atomicBalance;
    
    public AtomicAdder(AtomicBalance targetBalance){
        this.atomicBalance = targetBalance;
    }
    
    @Override
    public void run() {
        
        try {
            atomicBalance.transact(addAmount);
            System.out.println("We added " + addAmount + " to the balance");
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchAdder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
