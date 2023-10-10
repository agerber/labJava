package edu.uchicago.gerber.labjava.lec04.fight;

import java.util.Random;

public interface Boxable {
	
	
	
	// #################################################
	// ##### CONSTANTS
	// #################################################




	
	 String[] SOUNDS = {
			
		"BaAAm!",
		"bIfff!@#",
		"cRACk#%*!",
		"smAAAAck^",
		"pop"
			
	};
	
   Random RAN = new Random(); //a random to use
	
	// #################################################
	// ##### CONTRACTED METHODS OF INTERFACE
	// #################################################
	
	 boolean punch(Boxable boxOpponent);
	 void ouch(int nPoints);
	 int healthStatus();
	 String display();
	 String vocalize();
	
	
	

}
