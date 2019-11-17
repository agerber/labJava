package lec03.glab.boxing;


public class DeathMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	
		

		
		Boxable boxPuncher   = new Human(

				"//src//lec03//glab//resources//box_human.jpg",
			60, 	
			"I'm the greatest, float like a butterfly, sting like a bee!", 
			1000,
			Boxable.ACC_HUMAN,
			Boxable.POW_HUMAN
				);
		
		
//		Boxable boxPunchee = new Kangaroo(
//                "//src//lec03//glab//resources//box_roo.gif",
//				60,
//				1000,
//				Boxable.ACC_KANGAROO,
//				Boxable.POW_KANGAROO
//					);
//
//		
		Boxable	boxPunchee = new Robot(

				"//src//lec03//glab//resources//box_robot.jpg",
				60,
				1000,
				Boxable.ACC_ROBOT,
				Boxable.POW_ROBOT
				);


		
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
		
		
	

		while (true) {
			
			//used to calculate the severity of the potential blow
			int nOrigHealth = boxPunchee.healthStatus();
		
			if (boxPuncher.punch(boxPunchee)){
			    System.out.print(boxPuncher.display());	
			   
			    //some sounds for max effect
			    System.out.println(
			    		Boxable.SOUNDS[Boxable.RAN.nextInt(Boxable.SOUNDS.length)]);
			
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
			
			
			
			
		}
			
		
		
		if (boxPuncher instanceof Human)
			System.out.println(((Human) boxPuncher).getInterview());
			
		
		

	}

}
