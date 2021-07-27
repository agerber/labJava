package edu.uchicago.gerber.labjava.lec03.glab.race;

import java.util.Random;

public interface Raceable {

	
	// #################################################
	// ##### CONSTANTS
	// #################################################

	public static final int DIM = 20; //dimension of ascii image
	
	public static final int PACE_HUMAN = 4;  //yards per second
	public static final int PACE_KANGAROO = 5; 
	public static final int PACE_GAZELLE = 8; 
	
	public static final int VAR_HUMAN = 1;  //variability per stride
	public static final int VAR_KANGAROO = 4; 
	public static final int VAR_GAZELLE = 9; 
	
	public static final Random RAN = new Random(); //a random to use
	
	// #################################################
	// ##### CONTRACTED METHODS OF INTERFACE
	// #################################################

	public String display(int nIndent);
	public void stride();
	public String vocalize();
	public int getDistance();

}


