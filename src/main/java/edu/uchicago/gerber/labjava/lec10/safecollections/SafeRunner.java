package edu.uchicago.gerber.labjava.lec10.safecollections;

public class SafeRunner implements Runnable {

	
	private ThreadSafeArrayList tsa;
	
	public SafeRunner(ThreadSafeArrayList tsa) {
		this.tsa = tsa;
		
	}

	@Override
	public void run() {
		
		
		for (int nC = 0; nC < 1000; nC++) {
			tsa.add((new Integer(nC)).toString());
			System.out.println("adding " + (new Integer(nC)).toString() );
		}
		
		
	}



}
