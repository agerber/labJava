package edu.uchicago.gerber.labjava.lec09.glab.datastructs;

import java.awt.*;

public class StackDriver {

	 public static void main(String[] args) {
			
		 Stack<String> strTeams  = new Stack<String>();
		 strTeams.push("Vikings");
		 strTeams.push("Browns");
		 strTeams.push("Jets");
		 strTeams.push("Cowboys");
		 strTeams.push("Patriots");
		 strTeams.push("Dolphins");
		 strTeams.push("Bears");
		 
		 
		 Stack<Rectangle> recSquares = new Stack<Rectangle>();
		 recSquares.push(new Rectangle(5,5));
		 recSquares.push(new Rectangle(6,6));
		 recSquares.push(new Rectangle(7,7));
		 

		 
		 while(!strTeams.isEmpty())
			 System.out.println(strTeams.pop());
		 
		 
		 while(!recSquares.isEmpty()){
			 Rectangle rec = recSquares.pop();
			 System.out.println("area: " + rec.width * rec.height);
		 }
			 
			 

		 
	}
		

}
