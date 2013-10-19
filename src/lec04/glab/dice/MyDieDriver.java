package lec04.glab.dice;

import lec03.glab.dice.*;

public class MyDieDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		lec03.glab.dice.MyDie die1 = new lec03.glab.dice.MyDie(5.0, 5.0, 5.0, new String[]
				{"one","two", "three", "four", "five", "six"} );
		
		lec03.glab.dice.MyDie die2 = new lec03.glab.dice.MyDie(2.0, 2.0, 2.0, new String[]
				{"spades", "hearts","diamonds", "clubs"} );
		
		
		//what is happening here? 
		die1 = die2;
		
		
		System.out.println(die1);
		

	}

}
