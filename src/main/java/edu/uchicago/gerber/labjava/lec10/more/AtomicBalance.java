
/*
 * This class is used in conjunction with the AtomicMain.java class to demonstrate
 * how to use Atomic variables in order to ensure data integrity.
 *
 * Note that in the code below, I have // remarked out code that can be swapped with
 * the code above it to show how the program would work WITHOUT atomic variables 
 * (hint: the ending result would be wrong).
 */

package edu.uchicago.gerber.labjava.lec10.more;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicBalance {
    
    AtomicInteger balance;
    AtomicInteger tempBalance = new AtomicInteger();
       
    // int balance;
    // int tempBalance;
    
    public AtomicBalance(int startingBalance){
        this.balance = new AtomicInteger(startingBalance);
        // this.balance = startingBalance;
    }
    

    public void transact(int amount) throws InterruptedException{
 
        // >> This is where you would put in your actionable code << 
        
        int readTemp = tempBalance.get();
        
        while(!tempBalance.compareAndSet(readTemp, balance.intValue()))
           readTemp = tempBalance.get();
          
        // tempBalance = balance;

        try {
           Thread.sleep(20); // Instead of 'sleeping', a thread could be doing I/O functions that cause a delay, for example   
        } catch (InterruptedException e) {
        
        }
               
        // The 'AddAndGet' is unique to atomic variables.  This method encapsulates the retrieval of and addition
        // to a particular variable in a manner that is uninterruptible. Therefore, because we're using this method as
        // opposed to tempBalance = tempBalance + amount, no other thread can be altering the tempBalance variable while
        // we're working with it. 
        
        tempBalance.addAndGet(amount);
        int readBalance = balance.get();        
        
        // The 'compareAndSet' command is based on compare and set feature found in modern microprocessors which provide for 
        // the uninterruptible check and replace function of specific data in memory.  It follows the format:
        
        // variableToChange.compareAndSet(expectedCurrentValue,valueWeWantToChangeTo);
        
        // The program comfirms that the variableToChange value equals the expectedCurrentValue, and if it does, then 
        // it replaces the current value of the VariableToChange to the valueWeWantToChangeTo.  If the variableToChange's value
        // is NOT equal to expectedCurrentValue, then the current value is returned.
        
        while(!this.balance.compareAndSet(readBalance, tempBalance.intValue()))
           readBalance = balance.get();
           
        /* 
         tempBalance += amount;
         this.balance = tempBalance;
        */
        
    }
    
    public int currentAmount(){
        return balance.intValue();
        //return balance;
    }
    
}
