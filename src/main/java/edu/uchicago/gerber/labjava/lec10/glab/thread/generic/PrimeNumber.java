package edu.uchicago.gerber.labjava.lec10.glab.thread.generic;

public class PrimeNumber implements Runnable {

	private static final int REPS = 10;
	private static final int DELAY = 1000;


	private String strGreet;


	public PrimeNumber(String strGreet) {
		super();
		this.strGreet = strGreet;
	}


	public String getStrGreet() {
		return this.strGreet;
	}


	public void setStrGreet(String strGreet) {
		this.strGreet = strGreet;
	}


	@Override
	public void run() {


		try {
			for (int nC = 0; nC < REPS; nC++) {
				long start = System.currentTimeMillis();
				for (int nD = 0; nD < 50_000; nD++){
					calcPrime(nD);
				}

				Thread.sleep(DELAY);
				System.out.println((System.currentTimeMillis() - start) + " " + strGreet);
			}
		} catch (InterruptedException exp) {
			// TODO Auto-generated catch block
		   	//exp.printStackTrace();
		}
		
	}

	private boolean calcPrime(int num){
		for (int i = 2; i <= num / 2; ++i) {
			// condition for nonprime number
			if (num % i == 0) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	

}
