package edu.uchicago.gerber.labjava.lec04.fight;


import edu.uchicago.gerber.labjava.lec04.race.Raceable;

public class Kangaroo extends Animal implements Raceable, Boxable {

	
	//instance fields for racing
	private int nDistance;
	

	
	//instance fields for boxing

	private int nHealthPoints;
	//private int nAccuracy;
	//private int nPower;

    public static final int ACC_KANGAROO = 24;
    public static final int POW_KANGAROO = 60;
	
	
	//constructor for racing
	public Kangaroo(String strUrlAscii, int nDim) {
		super(strUrlAscii, nDim);
	
		nDistance = 0;
	}
	
	
	//constructor for boxing
	public Kangaroo(String strUrlAscii, int nDim, 
			int healthPoints) {
		super(strUrlAscii, nDim);
		//strInterview = interview;
		nHealthPoints = healthPoints;
		//nAccuracy = accuracy;
		// nPower = power;
	}
	
	
	
	public int getHealthPoints() {
		return nHealthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		nHealthPoints = healthPoints;
	}
	public int getAccuracy() {
		return ACC_KANGAROO;
	}

	
	


	public int getPower() {
		return POW_KANGAROO;
	}



	public int getDistance() {
		return nDistance;
	}


	public void setDistance(int distance) {
		nDistance = distance;
	}



	//this method signature satisfies the raceable interface
	//overridden and overloaded
	@Override
	public String display(int nIndent) {
		// TODO Auto-generated method stub
		return super.display(nIndent);
		
	}
	


	@Override
	public void stride() {
		
		//increment the distance by pace - variablity
		
		setDistance(getDistance() + Raceable.PACE_KANGAROO - Raceable.RAN.nextInt( Raceable.VAR_KANGAROO));
		
		
		
	}



	@Override
	public String vocalize() {
	
		return "kangaroo sound !";
		
	}



	
	@Override
	public String display() {
		// TODO Auto-generated method stub
		return super.display(0);
	}


	@Override
	public boolean punch(Boxable boxOpponent) {
		
		//swing
		//if swing meets mark
			//extract some health from opponent
		int nSwing = Raceable.RAN.nextInt(100);
		if (nSwing < getAccuracy()){
			boxOpponent.ouch(getPower());
			return true;
		}
		return false;
	}
	
	@Override
	public void ouch(int nPoints) {
		
		setHealthPoints(getHealthPoints() - nPoints);
		
	}




	@Override
	public int healthStatus() {
		
		return getHealthPoints();
	}

	
	
}
