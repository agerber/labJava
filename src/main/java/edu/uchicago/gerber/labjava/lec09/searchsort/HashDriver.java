package edu.uchicago.gerber.labjava.lec09.searchsort;

import java.util.Random;

public class HashDriver {

	
	//private static final int SIZE = 157;
	private static final int SIZE = 60;
	private static HashTable htb;
	private static Random ran; 
	
	
	public static void main(String[] args) {
		ran = new Random();
		htb = new HashTable(SIZE);
		
		for (int nC = 0; nC < 128; nC++) 
			htb.add(new Integer(ran.nextInt(100)));
		
		 for (int nC = 0; nC < 30; nC++) 
			  System.out.println(htb.contains(ran.nextInt(100)));
		
		
		
		


	}

}
