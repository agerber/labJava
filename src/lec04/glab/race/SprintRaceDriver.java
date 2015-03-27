package lec04.glab.race;



import lec04.glab.fight.Human;
import lec04.glab.fight.Kangaroo;

public class SprintRaceDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		  
		Raceable[] racRacers = new Raceable[3];

		
		racRacers[0] = new Human("//src//lec04//glab//resources//run_human.gif",
				Raceable.DIM);
		
		racRacers[1] = new Gazelle("//src//lec04//glab//resources//run_gazelle.jpg",
				Raceable.DIM);
		

		racRacers[2] = new Kangaroo("//src//lec04//glab//resources//run_roo.png",
				Raceable.DIM);



			

	}//end main

}
