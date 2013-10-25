package lec04.glab.fight;

import java.util.Random;

public interface Boxable {
	
	
	
	// #################################################
	// ##### CONSTANTS
	// #################################################




	
	public static final String[] SOUNDS = {
			
		"BaAAm!",
		"bIfff!@#",
		"cRACk#%*!",
		"smAAAAck^",
		"pop"
			
	};
	
	public static final Random RAN = new Random(); //a random to use
	

	
	public boolean punch(Boxable boxOpponent);
    public void ouch(int nPoints);
    public int healthStatus();
    public String display();
    public String vocalize();
	
	
	

}
