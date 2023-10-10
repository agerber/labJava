package edu.uchicago.gerber.labjava.lec06.mortalkombat;




public class SuperHero extends Mortal implements Boxable {

	

	//instance fields for boxing
	private String strInterview;
	private int nHealthPoints;
	private int nAccuracy;
	private int nPower;
	private String strName;
	

	//constructor for boxing
	public SuperHero(String strFile, String strWav, String interview,
			int healthPoints, int accuracy, int power, String strName) {
		super(strFile, strWav);
		strInterview = interview;
		nHealthPoints = healthPoints;
		nAccuracy = accuracy;
		 nPower = power;
		 this.strName = strName;
	}
	


	public String getName() {
		return this.strName;
	}



	public void setName(String strName) {
		this.strName = strName;
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
		int nSwing = (int) ( Math.random() * 100);
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
