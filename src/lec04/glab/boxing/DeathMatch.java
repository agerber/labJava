package lec04.glab.boxing;


import lec03.glab.boxing.*;
import lec03.glab.boxing.Boxable;
import lec03.glab.boxing.Human;

public class DeathMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	
		

		
		lec03.glab.boxing.Boxable boxPuncher   = new lec03.glab.boxing.Human(

				"//src//lec03//glab//resources//box_human.jpg",
			60, 	
			"I'm the greatest, float like a butterfly, sting like a bee!", 
			1000,
			lec03.glab.boxing.Boxable.ACC_HUMAN,
			lec03.glab.boxing.Boxable.POW_HUMAN
				);
		
		
		lec03.glab.boxing.Boxable boxPunchee = new lec03.glab.boxing.Kangaroo(
                "//src//lec03//glab//resources//box_roo.gif",
				60, 	
				1000,
				lec03.glab.boxing.Boxable.ACC_KANGAROO,
				lec03.glab.boxing.Boxable.POW_KANGAROO
					);
		
//		
//		Boxable	boxPunchee = new Robot("file:\\\\\\C:\\dev\\lec03\\src\\edu\\uchicago\\cs\\java\\lec03\\res\\box_robot.jpg",
//				60,
//				1000,
//				Boxable.ACC_ROBOT,
//				Boxable.POW_ROBOT
//				);
//		
		
		
//		System.out.println(boxPuncher);
//		System.out.println(boxPunchee);
		
		
		
		//alternate swings indefinitely swap
			//if swing connects
				//display puncher
				//ouch! extract health points from punchee
				//if punchee has less than zero health points
					//puncher vocalize
					//if puncher is human
						//give interview
		
		
	

		do {
			
			//used to calculate the severity of the potential blow
			int nOrigHealth = boxPunchee.healthStatus();
		
			if (boxPuncher.punch(boxPunchee)){
			    System.out.print(boxPuncher.display());	
			   
			    //some sounds for max effect
			    System.out.println(
			    		lec03.glab.boxing.Boxable.SOUNDS[lec03.glab.boxing.Boxable.RAN.nextInt(lec03.glab.boxing.Boxable.SOUNDS.length)]);
			
			    if (boxPunchee.healthStatus() <= 0){
			    	System.out.println(boxPuncher.getClass().getName() + " knocks out " + boxPunchee.getClass().getName() );
			    	System.out.println(boxPuncher.healthStatus() + " to " + boxPunchee.healthStatus() );
			    
			       	
			    	
			    	break;
			    }
			    else {
			    	System.out.println( boxPunchee.healthStatus() - nOrigHealth + " hit points!");
			    	System.out.println(boxPuncher.getClass().getName() + " " + boxPuncher.healthStatus() + " versus "  + 
			    			boxPunchee.getClass().getName() + " " + boxPunchee.healthStatus()); 	
			    }
			    
			}//end outer if
			
			//swap
			Boxable boxTemp = boxPuncher;
			boxPuncher = boxPunchee;
			boxPunchee = boxTemp;
			
			
			
			
		} while (true); //infi
			
		
		
		if (boxPuncher instanceof lec03.glab.boxing.Human)
			System.out.println(((Human) boxPuncher).getInterview());
			
		
		

	}

}
