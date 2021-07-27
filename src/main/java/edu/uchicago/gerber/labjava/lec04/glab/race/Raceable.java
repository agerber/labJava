package edu.uchicago.gerber.labjava.lec04.glab.race;

import java.util.Random;

public interface Raceable {

	
	// #################################################
	// ##### CONSTANTS
	// #################################################

	 int DIM = 20; //dimension of ascii image
	
	 int PACE_HUMAN = 4;  //yards per second
	int PACE_KANGAROO = 5;
	 int PACE_GAZELLE = 8;
	
	 int VAR_HUMAN = 1;  //variability per stride
	 int VAR_KANGAROO = 4;
	 int VAR_GAZELLE = 9;
	
	 Random RAN = new Random(); //a random to use
	
	// #################################################
	// ##### CONTRACTED METHODS OF INTERFACE
	// #################################################

	 String display(int nIndent);
	 void stride();
	 String vocalize();
	 int getDistance();

}


