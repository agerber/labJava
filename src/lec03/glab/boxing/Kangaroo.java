package lec03.glab.boxing;

import lec03.glab.race.Raceable;


public class Kangaroo extends Animal implements Raceable, Boxable {

	
	//instance fields for racing
	private int nDistance;
	

	
	//instance fields for boxing

	private int nHealthPoints;
	private int nAccuracy;
	private int nPower;
	
	
	
	//constructor for racing
	public Kangaroo(String strUrlAscii, int nDim) {
		super(strUrlAscii, nDim);
	
		nDistance = 0;
	}
	
	
	//constructor for boxing
	public Kangaroo(String strUrlAscii, int nDim, 
			int healthPoints, int accuracy, int power) {
		super(strUrlAscii, nDim);
		//strInterview = interview;
		nHealthPoints = healthPoints;
		nAccuracy = accuracy;
		 nPower = power;
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
	
	


	public int getPower() {
		return this.nPower;
	}


	public void setPower(int power) {
		this.nPower = power;
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
