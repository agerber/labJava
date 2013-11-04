package lec06.glab.mortalkombat;

import java.util.Random;

public interface Boxable {
	
	
	
	// #################################################
	// ##### CONSTANTS
	// #################################################

	public static final int ACC_FREEZ = 50;  //percent accuracy each swing
	public static final int ACC_SCORP = 75; 

	
	public static final int POW_FREEZ = 60;  //power per punch in hit-points
	public static final int POW_SCORP = 45; 
	
	
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

	
	
	

}
