package edu.uchicago.gerber.labjava.lec02;

import java.util.Random;

public class RandomNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//notice that randome is not static, it must be instantiated to use it.
		Random ran = new Random();
		
		//what random object returns
		for(int nC = 0; nC < 100; nC++)
		    System.out.println(ran.nextDouble());
		
		//declare an empty array of bytes
		byte[] yFacets = new byte[6];
		
		//init the array of bytes with the 1-6
		//need to cast an int to a byte
		for (int nC= 0; nC < yFacets.length; nC++)
			yFacets[nC] = (byte)(nC + 1);
		
		
		
		System.out.println("--------------------------");
		
		//roll the die 20 times
		for (int nRoll = 0; nRoll < 20; nRoll++)
			System.out.print(" >" + yFacets[ran.nextInt(6)] );

		
	

		
	}

}
