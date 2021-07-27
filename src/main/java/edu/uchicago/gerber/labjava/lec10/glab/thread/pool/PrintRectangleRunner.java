package edu.uchicago.gerber.labjava.lec10.glab.thread.pool;

import java.awt.Rectangle;
import java.util.Random;

public class PrintRectangleRunner implements Runnable{

	private Rectangle rec;
	private static Random R = new Random();

	public PrintRectangleRunner() {
		

		
		rec = new Rectangle(
				R.nextInt(10) + 1, 
				R.nextInt(10) + 1,
				R.nextInt(10) + 1,
				R.nextInt(10) + 1);

	  }

	@Override
	public void run() {

        synchronized (System.out) {
            try {
              //  for (int nC = 0; nC < 20; nC++) {

                System.out.println(rec);
                Thread.sleep(20);

            //    }
            } catch (InterruptedException exp) {
                // TODO Auto-generated catch block
                exp.printStackTrace();
            }
        }
	
		
	}
	
	
	
	
}
