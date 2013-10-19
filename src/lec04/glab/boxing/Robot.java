package lec04.glab.boxing;

import lec03.glab.ascii.Asciify;
import lec03.glab.boxing.Boxable;
import lec03.glab.race.Raceable;

public class Robot implements Boxable {

	
	// #################################################
	// ##### INSTANCE FIELDS
	// #################################################

	
	private char[][] cAsciis;
	
	//instance fields for boxing
	//private String strInterview;
	private int nHealthPoints;
	private int nAccuracy;
	private int nPower;
	
	// #################################################
	// ##### CONSTRUCTORS
	// #################################################


//	
//	public Robot(String strUrlAscii, int nDim) {
//		
//		
//		cAsciis = Asciify.getAsciiChars(strUrlAscii, nDim, nDim);
//		//the distanced is automatically set to zero
//		
//	}
//
//	
//	
//	
	
	
	
	public Robot(String strUrlAscii, int nDim, int healthPoints, int accuracy, int power) {
		//super();
		cAsciis = Asciify.getAsciiChars(strUrlAscii, nDim, nDim);
		//this.cAsciis = asciis;
		this.nHealthPoints = healthPoints;
		this.nAccuracy = accuracy;
		this.nPower = power;
	}







	// #################################################
	// ##### GETTERS/SETTERS
	// #################################################


	
	
	
	
	public char[][] getAsciis() {
		return cAsciis;
	}

	public int getHealthPoints() {
		return this.nHealthPoints;
	}


	public void setHealthPoints(int healthPoints) {
		this.nHealthPoints = healthPoints;
	}


	public int getAccuracy() {
		return this.nAccuracy;
	}


	public void setAccuracy(int accuracy) {
		this.nAccuracy = accuracy;
	}


	public int getPower() {
		return this.nPower;
	}


	public void setPower(int power) {
		this.nPower = power;
	}


	public void setAsciis(char[][] asciis) {
		cAsciis = asciis;
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


	public String display() {
		
		StringBuilder stb = new StringBuilder();
		
		//for each row of the ascii
			//for counter = 0; counter < distance ; counter++
				//print a space
			//for each col of the current row
				//print the char in the char[][]
			//print newline
		//return a string
		
		for (int nRow = 0; nRow < cAsciis.length; nRow++) {
			
//			for(int nSpaces = 0; nSpaces < nIndent; nSpaces++)
//				stb.append(' ');
			
			for(int nCol = 0; nCol < cAsciis[nRow].length; nCol++)
			     stb.append(cAsciis[nRow][nCol]);
			
			stb.append('\n');
		}
		
		return stb.toString();
		
		
	}//end display

	@Override
	public String vocalize() {
		// TODO Auto-generated method stub
		return "I robot.";
	}

}
