package lec04.glab.fight;


import lec04.glab.race.Raceable;

public class Human extends Animal implements Raceable, Boxable {

	
	//instance fields for racing
	private int mDistance;
	
	//instance fields for boxing
	private String mInterview;
	private int mHealthPoint;

    public static final int ACC_HUMAN = 50;  //percent accuracy each swing
    public static final int POW_HUMAN = 30;  //power per punch in hit-points
	
	
	//constructor used for racing
	public Human(String strUrlAscii, int nDim) {
		super(strUrlAscii, nDim);
	
		mDistance = 0;
	}

	//constructor used for boxing
	public Human(String strUrlAscii, int nDim, String interview,
			int healthPoints) {
		super(strUrlAscii, nDim);
		mInterview = interview;
		mHealthPoint = healthPoints;

	}
	


	public String getInterview() {
		return mInterview;
	}
	public void setInterview(String interview) {
		mInterview = interview;
	}
	public int getHealthPoints() {
		return mHealthPoint;
	}
	public void setHealthPoints(int healthPoints) {
		mHealthPoint = healthPoints;
	}

	
	public int getDistance() {
		return mDistance;
	}


	public void setDistance(int distance) {
		mDistance = distance;
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
