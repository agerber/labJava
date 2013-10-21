package lec04.glab.fight;


import lec04.glab.race.Raceable;

public class Human extends Animal implements Raceable, Boxable {

	
	//instance fields for racing
	private int nDistance;
	
	//instance fields for boxing
	private String strInterview;
	private int nHealthPoints;
	//private int nAccuracy;
	//private int nPower;



    public static final int ACC_HUMAN = 50;  //percent accuracy each swing
    public static final int POW_HUMAN = 30;  //power per punch in hit-points
	
	
	//constructor for racing
	public Human(String strUrlAscii, int nDim) {
		super(strUrlAscii, nDim);
	
		nDistance = 0;
	}
	
	
	
	//constructor for boxing
	public Human(String strUrlAscii, int nDim, String interview,
			int healthPoints) {
		super(strUrlAscii, nDim);
		strInterview = interview;
		nHealthPoints = healthPoints;
		//nAccuracy = accuracy;
		 //nPower = power;
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

	
	public int getDistance() {
		return nDistance;
	}


	public void setDistance(int distance) {
		nDistance = distance;
	}





	@Override
	public boolean punch(Boxable boxOpponent) {
		
		//swing
		//if swing meets mark
			//extract some health from opponent
		int nSwing = Raceable.RAN.nextInt(100);
		if (nSwing < ACC_HUMAN){
			boxOpponent.ouch(POW_HUMAN);
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
