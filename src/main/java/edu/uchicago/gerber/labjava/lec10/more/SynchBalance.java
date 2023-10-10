
/*
 * This class is used in conjunction with the SynchMain.java class.
 * 
 * To demonstrate the utility of the synchronization keyword, we have created
 * a (somewhat contrived) method that shows the dangers when threads are able to access data
 * concurrently without any preventative steps taken to ensure data integrity.
 *
 * In this case, because the thread sleeps for a small amount of time before completing the 
 * transaction, it's possible for multiple threads to start transactions concurrently before
 * previous transactions are completed.  This can lead to corrupt data.
 *
 * To minimize this, you can place the 'synchronized' keyword between 'public' and 'void'
 * in the transact method, which will prevent a later thread from accessing this method
 * until a prior thread completes the method, thereby ensuring data integrity.
 *
 */

package edu.uchicago.gerber.labjava.lec10.more;

public class SynchBalance {

    int balance = 0;
    int tempBalance = 0;
    
    public SynchBalance(int startingBalance){
        this.balance = startingBalance;
    }
    
    // With the term 'synchronized' remarked out, this program will not
    // generate the correct sequence of transactions, leading to an incorrect
    // balance at the end.
    
    public /* synchronized */ void transact(int amount) throws InterruptedException{
                
        // >> This is where you would put in your actionable code << 
               
        tempBalance = balance;

        try {
           Thread.sleep(20); // Instead of 'sleeping', a thread could be doing I/O functions that cause a delay   
        } catch (InterruptedException e) {
        
        }
        
        tempBalance += amount;
        
        this.balance = tempBalance;
    
    }
    
    public int currentAmount(){
        return balance;
    }
    
}
