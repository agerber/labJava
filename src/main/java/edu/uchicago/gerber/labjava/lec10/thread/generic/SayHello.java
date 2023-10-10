package edu.uchicago.gerber.labjava.lec10.thread.generic;

public class SayHello implements Runnable {
	
	private static final int REPS = 10;
	private static final int DELAY = 1000;
	
	
	private String strGreet;


	public SayHello(String strGreet) {
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

				Thread.sleep(DELAY);
				System.out.println((System.currentTimeMillis() - start) + " " + strGreet);
			}
		} catch (InterruptedException exp) {
			// TODO Auto-generated catch block
		   	//exp.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	

}
