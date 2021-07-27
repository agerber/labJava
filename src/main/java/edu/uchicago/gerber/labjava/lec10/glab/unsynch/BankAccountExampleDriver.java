package edu.uchicago.gerber.labjava.lec10.glab.unsynch;

public class BankAccountExampleDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BankAccount bnk = new BankAccount();
		final double AMOUNT = 100;
		final int REPS = 100;
		final int THREADS = 100;

		for (int nC = 0; nC < THREADS; nC++) {
			new Thread(new Depositer(bnk, AMOUNT, REPS)).start();
			new Thread(new Withdrawer(bnk, AMOUNT, REPS)).start();
		}

	}

}

class Depositer implements Runnable{

	private static final int DELAY = 1;
	private BankAccount bnk;
	private double dAmount;
	private int nCount;

	public Depositer(BankAccount bnk, double dAmount, int nCount) {
		super();
		this.bnk = bnk;
		this.dAmount = dAmount;
		this.nCount = nCount;
	}

	public void run(){

		try {
			for (int nC = 0; nC < nCount; nC++) {

				bnk.deposit(dAmount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
	}

}

class BankAccount {

	private double dBalance;

	public BankAccount() {

		this.dBalance = 0;
	}


	public  void deposit(double dAmount){
		System.out.print("Depositing " + dAmount);
		double dNewBal = getBalance() + dAmount;
		System.out.println(", the new balance is "+ dNewBal);
		setBalance(dNewBal);
	}

	public  void withdraw(double dAmount){
		System.out.print("Withdrawing " + dAmount);
		double dNewBal = getBalance() - dAmount;
		System.out.println(", the new balance is "+ dNewBal);
		setBalance(dNewBal);
	}


	public double getBalance() {
		return this.dBalance;
	}

	public void setBalance(double dBalance) {
		this.dBalance = dBalance;
	}



}

class Withdrawer implements Runnable{

	private static final int DELAY = 1;
	private BankAccount bnk;
	private double dAmount;
	private int nCount;

	public Withdrawer(BankAccount bnk, double dAmount, int nCount) {
		super();
		this.bnk = bnk;
		this.dAmount = dAmount;
		this.nCount = nCount;
	}

	public void run(){

		try {
			for (int nC = 0; nC < nCount; nC++) {

				bnk.withdraw(dAmount);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
	}

}
