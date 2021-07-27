package edu.uchicago.gerber.labjava.lec02.glab;

import java.util.ArrayList;
import java.awt.Rectangle;

public class ArrayListManipulation {


	public static void main(String[] args) {



		//delcare a new arrayList and import from java.util
		//here we're using the generic form so we're tellign the compiler that
		//this data structure can ONLY hold strings
		ArrayList<String> strNames = new ArrayList<>();
		
		
		//the nice thing about arrayLists is that their length is indeterminate
		//this type of data structure is known as a vector; it can grow and shrink -- very useful
		strNames.add("Carol");
		strNames.add("Marcia");
		strNames.add("Jan");
		strNames.add("Cindy");





		
//		//let's iterate over this ArrayList
//		for (String str : strNames) {
//			System.out.println(str);
//		}




        System.out.println("-----------------------------");
		
		String[] strMikesFamilyMembers = {"Mike", "Gregg", "Peter", "Bobby"};
		
		//let's add them to our arraylist
		//start at position zero 
		//traverse the String[] and insert at even positions
		for (int nC = 0; nC < strMikesFamilyMembers.length; nC++) {
			strNames.add(nC * 2, strMikesFamilyMembers[nC]);
		}

		//let's iterate over this ArrayList
		for (String str : strNames) {
			System.out.println(str);
		}
		
		System.out.println("-----------------------------");
		strNames.add("Alice");
		strNames.add("Tiger");
		
		//wait...get rid of Tiger, Jan is allergic.
		strNames.remove(strNames.size()-1);

		//let's iterate over this ArrayList
		for (String str : strNames) {
			System.out.println(str);
		}

		System.out.println("-----------------------------");
		
		//Using ArrayLists without Generics 
		//This ArrayList can take any object
		ArrayList objObjects = new ArrayList();
		
		objObjects.add(new Integer(5));
		objObjects.add(new Double(5.5));
		objObjects.add(56L);




//		objObjects.add(new Boolean(true));
//		objObjects.add(new Rectangle(1,5,15,78));
		
		
		
		for (Object obj : objObjects) {
			System.out.println(obj.getClass().getCanonicalName());
		}
		
		System.out.println("-----------------------------");
		
		//let's use the fully qualified Class name; rather than import; just for fun
		ArrayList<Rectangle> recShapes = new ArrayList<>();
		recShapes.add(new java.awt.Rectangle(2,3,4,5));
		recShapes.add(new java.awt.Rectangle(16,8,9,12));
		recShapes.add(new java.awt.Rectangle(14,8,15,11));
		
		for (java.awt.Rectangle rec : recShapes) {
			System.out.println(rec.getSize().toString());
		}

	}//end main

}
