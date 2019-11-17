package lec02.glab;

import lec03.glab.boxing.Boxable;

public class MyDieDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyDie die1 = new MyDie(5.0, 5.0, 5.0, new String[] 
				{"one","two", "three", "four", "five", "six"} );
		
		MyDie die2 = new MyDie(2.0, 2.0, 2.0, new String[] 
				{"spades", "hearts","diamonds", "clubs", "joker", "trump"} );
		
		
		//what is happening here? 
		die1 = die2;

		
		System.out.println(die1);
		

	}

}
