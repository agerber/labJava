package lec03.race;

import lec03.boxing.Human;
import lec03.boxing.Kangaroo;

public class SprintRace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		  
		Raceable[] racRacers = new Raceable[3];
		
		
		
		racRacers[0] = new Human("file:\\\\\\C:\\dev\\lec03\\src\\edu\\uchicago\\cs\\java\\lec03\\resources\\run_human.gif",
				Raceable.DIM);
		
		racRacers[1] = new Gazelle("file:\\\\\\C:\\dev\\lec03\\src\\edu\\uchicago\\cs\\java\\lec03\\resources\\run_gazelle.jpg",
				Raceable.DIM);
		

		racRacers[2] = new Kangaroo("file:\\\\\\C:\\dev\\lec03\\src\\edu\\uchicago\\cs\\java\\lec03\\resources\\run_roo.png",
				Raceable.DIM);
		  
		
		
//		for (Raceable rac : racRacers) {
//			
//			System.out.println(rac.toString());
//			
//		}
		

		//make a lane marker
			StringBuilder stbLane = new StringBuilder();
			for (int nC = 0; nC < 120; nC++)
				 stbLane.append("#");
		
		
			Raceable racFarthest;
		
			
			do {
				
				for (Raceable rac : racRacers) {
					rac.stride();
					
					System.out.print(rac.display(rac.getDistance()));
					System.out.println(stbLane.toString());

					
				}
				
				//print out a lane marker

				
				System.out.println(stbLane.toString());
		
				
				//test to see who won
				racFarthest = racRacers[0];
		
				for (int nC = 1; nC < racRacers.length; nC++) {
					
					if (racFarthest.getDistance() < racRacers[nC].getDistance()){
						racFarthest = racRacers[nC];
					}

				}
				
				if(racFarthest.getDistance() >= 100){
					
					System.out.print(racFarthest.vocalize());
					break;
				
				}
		
				
			} while (true); //infinite loop, break condition must be met
			
	
			

	}

}
