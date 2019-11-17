package lec03.glab.statics;

public class BankTester {

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
		


		
	}

}
