package edu.uchicago.gerber.labjava.lec10.thread.pool;


import java.util.Random;

public class PrintIntegerRunner implements Runnable{

	private Integer intNum;
	private static Random R = new Random();

	public PrintIntegerRunner() {
		

		intNum = new Integer(R.nextInt(40) + 1);

	  }

	@Override
	public void run() {
		
		try {
			for (int nC = 0; nC < 5; nC++) {
			
				
				Thread.sleep(R.nextInt(1000));
				printHisto();
				
			}
		} catch (InterruptedException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		
	
		
	}
	
	private void printHisto(){
        synchronized (System.out) {
            for (int nC = 0; nC < intNum; nC++) {
                System.out.print("#");
            }
            System.out.println(intNum);

        }
	}
	
	
	
	
}
