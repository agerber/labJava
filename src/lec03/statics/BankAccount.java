package lec03.statics;

public class BankAccount {

	// ===============================================
	// ==STATIC FIELDS
	// ===============================================
	
	 private static int nLastAssignedNumber = 1000; 
	 public static final double OVERDRAFT_FEE = 5.0;
	 
	 
	 
	 // ===============================================
	// ==NON-STATIC FIELDS
	// ===============================================
	
    private double dBalance;   
    private int nAccountNumber;
    
    
    
    
    // ===============================================
	// ==CONSTRUCTORS
	// ===============================================
	
    
	public BankAccount(double balance) {
		//super();
		this.dBalance = balance;
		this.nAccountNumber = nLastAssignedNumber++;
	}    
    
    @Override
    public String toString(){
    	
    	return this.getClass().getName() + " : " 
    	+ nAccountNumber + "; balance: " + dBalance;
    	
    }
    
    
    public void overdraft(double dParam){
    	dBalance -= dParam;
    }
    
    
   
}
