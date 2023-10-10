package edu.uchicago.gerber.labjava.lec04.statics;

public class BankAccount {

	// ===============================================
	// ==STATIC FIELDS
	// ===============================================
	
	 private static int sLastNumberAssigned = 1000;
	 public static final double OVERDRAFT_FEE = 5.0;
	 
	 
	 
	 // ===============================================
	// ==NON-STATIC FIELDS
	// ===============================================
	
    private double mBalance;
    private int mAccountNumber;

    // ===============================================
	// ==CONSTRUCTORS
	// ===============================================
	
    
	public BankAccount(double balance) {
		//super();
		this.mBalance = balance;
		this.mAccountNumber = sLastNumberAssigned++;
	}    
    
    @Override
    public String toString(){
    	
    	return this.getClass().getName() + " : " 
    	+ mAccountNumber + "; balance: " + mBalance;
    	
    }
    
    
    public void overdraft(double dParam){
    	mBalance -= dParam;
    }
    
    
   
}
