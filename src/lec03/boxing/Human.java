package lec03.boxing;

import edu.uchicago.cs.java.lec03.race.Raceable;


public class Human extends Animal implements Raceable, Boxable {

	
	//instance fields for racing
	private int nDistance;
	
	//instance fields for boxing
	private String strInterview;
	private int nHealthPoints;
	private int nAccuracy;
	private int nPower;
	
	

	
	
	//constructor for racing
	public Human(String strUrlAscii, int nDim) {
		super(strUrlAscii, nDim);
	
		nDistance = 0;
	}
	
	
	
	//constructor for boxing
	public Human(String strUrlAscii, int nDim, String interview,
			int healthPoints, int accuracy, int power) {
		super(strUrlAscii, nDim);
		strInterview = interview;
		nHealthPoints = healthPoints;
		nAccuracy = accuracy;
		 nPower = power;
	}
	


	public String getInterview() {
		return strInterview;
	}
	public void setInterview(String interview) {
		strInterview = interview;
	}
	public int getHealthPoints() {
		return nHealthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		nHealthPoints = healthPoints;
	}
	public int getAccuracy() {
		return nAccuracy;
	}
	public void setAccuracy(int accuracy) {
		nAccuracy = accuracy;
	}
	
	public int getDistance() {
		return nDistance;
	}


	public void setDistance(int distance) {
		nDistance = distance;
	}


	
	public int getPower() {
		return nPower;
	}



	public void setPower(int power) {
		nPower = power;
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


	//this method signature satisfies the raceable interface
	//overridden and overloaded
	@Override
	public String display(int nIndent) {
		// TODO Auto-generated method stub
		return super.display(nIndent);
		
	}
	
	//this method signature satisfies the boxable interface
	//overridden and overloaded
	@Override
	public String display() {
		// TODO Auto-generated method stub
		return super.display(0);
	}



	@Override
	public void stride() {
		
		//increment the distance by pace - variablity
		
		setDistance(getDistance() + Raceable.PACE_HUMAN - Raceable.RAN.nextInt(Raceable.VAR_HUMAN));
		
		
		
	}



	@Override
	public String vocalize() {
	
		return "Yes, I win!";
		
	}



	
	
}
