package edu.uchicago.gerber.labjava.lec10.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolDriver {


	public static void main(String[] args) {
	
		ExecutorService excPool = Executors.newFixedThreadPool(3);
		
		
		//creates a queue if excess threads
        //in this case we are constraining this so that only the first two are running in parallel
        //the other 13 are queued-up

		for (int nC = 0; nC < 15; nC++){ 
			excPool.execute(new PrintIntegerRunner());
			excPool.execute(new PrintRectangleRunner());
		}

	}

}
