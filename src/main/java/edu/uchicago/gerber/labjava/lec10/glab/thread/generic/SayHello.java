package edu.uchicago.gerber.labjava.lec10.glab.thread.generic;

import java.util.Date;

public class SayHello implements Runnable {
	
	private static final int REPS = 10;
	private static final int DELAY = 500;
	
	
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
				Date datNow = new Date();
				System.out.println(datNow + " " + strGreet);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException exp) {
			// TODO Auto-generated catch block
		   	//exp.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	

}
