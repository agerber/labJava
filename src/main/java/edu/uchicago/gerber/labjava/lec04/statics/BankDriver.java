package edu.uchicago.gerber.labjava.lec04.statics;

public class BankDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		
		BankAccount banOne = new BankAccount(55.12);
		BankAccount banTwo = new BankAccount(814.36);
		
		
		System.out.println(banOne);
		System.out.println(banTwo);
		
		System.out.println("#####################################");
		banOne.overdraft(BankAccount.OVERDRAFT_FEE);
		
		
		
		System.out.println(banOne);
		System.out.println(banTwo);
		

		
		//everytime you load this program into the VM  of this program will reset to 1000
		//if you need every instance  of a class in your program to have a unique ID, then this is a good idea
		
	}

}
