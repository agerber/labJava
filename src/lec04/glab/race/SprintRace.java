package lec04.glab.race;

import lec03.glab.boxing.Human;
import lec03.glab.boxing.Kangaroo;
import lec03.glab.race.*;
import lec03.glab.race.Raceable;

public class SprintRace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		  
		lec03.glab.race.Raceable[] racRacers = new lec03.glab.race.Raceable[3];

		
		racRacers[0] = new Human("//src//lec03//glab//resources//run_human.gif",
				lec03.glab.race.Raceable.DIM);
		
		racRacers[1] = new lec03.glab.race.Gazelle("//src//lec03//glab//resources//run_gazelle.jpg",
				lec03.glab.race.Raceable.DIM);
		

		racRacers[2] = new Kangaroo("//src//lec03//glab//resources//run_roo.png",
				lec03.glab.race.Raceable.DIM);
		  
		
		
//		for (Raceable rac : racRacers) {
//			
//			System.out.println(rac.toString());
//			
//		}
		

		//make a lane marker
			StringBuilder stbLane = new StringBuilder();
			for (int nC = 0; nC < 120; nC++)
				 stbLane.append("#");
		
		
			lec03.glab.race.Raceable racFarthest;
		
			
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
