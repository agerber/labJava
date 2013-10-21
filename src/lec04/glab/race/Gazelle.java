package lec04.glab.race;

import lec04.glab.fight.Animal;
import lec04.glab.race.Raceable;

public class Gazelle extends Animal implements Raceable {

	
	//instance fields for racing

	private int nDistance;
	


	//constructor for racing
	public Gazelle(String strUrlAscii, int nDim) {
		super(strUrlAscii, nDim);

		nDistance = 0;
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
		
		setDistance(getDistance() + Raceable.PACE_GAZELLE - Raceable.RAN.nextInt(Raceable.VAR_GAZELLE));
		
		
		
	}



	@Override
	public String vocalize() {
	
		return "snortttt!";
		
	}



	
	
}
