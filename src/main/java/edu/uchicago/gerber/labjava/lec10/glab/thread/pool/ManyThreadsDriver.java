package edu.uchicago.gerber.labjava.lec10.glab.thread.pool;



public class ManyThreadsDriver {


    /*

    Notice that the output is intersperced.

     */
	public static void main(String[] args) {


		for (int nC = 0; nC < 15; nC++) {
			new Thread(new PrintIntegerRunner()).start();
			new Thread(new PrintRectangleRunner()).start();
		}

    }

}
