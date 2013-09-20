package lec03.glab.boxing;

import java.util.Random;

public interface Boxable {
	
	
	
	// #################################################
	// ##### CONSTANTS
	// #################################################

	public static final int ACC_HUMAN = 50;  //percent accuracy each swing
	public static final int ACC_KANGAROO = 24; 
	public static final int ACC_ROBOT = 95; 
	
	public static final int POW_HUMAN = 30;  //power per punch in hit-points
	public static final int POW_KANGAROO = 60; 
	public static final int POW_ROBOT = 15; 
	
	public static final String[] SOUNDS = {
			
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
	
	public boolean punch(Boxable boxOpponent);
	public void ouch(int nPoints);
	public int healthStatus();
	public String display();
	public String vocalize();
	
	
	

}
