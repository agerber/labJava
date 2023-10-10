package edu.uchicago.gerber.labjava.lec10.safecollections;

import java.util.concurrent.CopyOnWriteArrayList;

public class SafeRunnerEasy implements Runnable {

	
	private CopyOnWriteArrayList<String> strVals;
	
	public SafeRunnerEasy(CopyOnWriteArrayList<String> strVals) {
		this.strVals = strVals;
		
	}

	@Override
	public void run() {


            for (int nC = 0; nC < 1000; nC++) {
                strVals.add((new Integer(nC)).toString());
                System.out.println("adding " + (new Integer(nC)).toString());
            }

		
	}



}
