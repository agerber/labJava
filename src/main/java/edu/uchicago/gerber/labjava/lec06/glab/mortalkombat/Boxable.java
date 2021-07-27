package edu.uchicago.gerber.labjava.lec06.glab.mortalkombat;

public interface Boxable {
	
	
	
	// #################################################
	// ##### CONSTANTS
	// #################################################

	public static final int ACC_FREEZ = 50;  //percent accuracy each swing
	public static final int ACC_SCORP = 75; 

	
	public static final int POW_FREEZ = 60;  //power per punch in hit-points
	public static final int POW_SCORP = 45; 
	
	

	
	// #################################################
	// ##### CONTRACTED METHODS OF INTERFACE
	// #################################################
	
	public boolean punch(Boxable boxOpponent);
	public void ouch(int nPoints);
	public int healthStatus();

	
	
	

}
