package lec03.glab.boxing;

import java.util.Random;

public interface Boxable {
	
	
	
	// #################################################
	// ##### CONSTANTS
	// #################################################

	int ACC_HUMAN = 50;  //percent accuracy each swing
	int ACC_KANGAROO = 24;
	int ACC_ROBOT = 95;
	
	int POW_HUMAN = 30;  //power per punch in hit-points
	int POW_KANGAROO = 60;
	int POW_ROBOT = 15;
	
	String[] SOUNDS = {
			
		"BaAAm!",
		"bIfff!@#",
		"cRACk#%*!",
		"smAAAAck^",
		"pop"
			
	};
	
	public static final Random RAN = new Random(); //a random to use
	
	// #################################################
	// ##### CONTRACTED METHODS OF INTERFACE
	// #################################################
	
	 boolean punch(Boxable boxOpponent);
	 void ouch(int nPoints);
	 int healthStatus();
	 String display();
	 String vocalize();
	
	
	

}
