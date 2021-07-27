package edu.uchicago.gerber.labjava.lec02.glab;


import java.awt.Rectangle;
import java.util.Date;


public class StringManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//this is a String literal  "Hello World";
		//a String literal has no object reference, so unless it's assined to
		   //a reference or a passed into a method, and then assined, it's unfindable

		//1. Strings are immutable objects, which means that once initialized, their values can NOT be changed - ever.
		//2. The + operator is overloaded to concatenate strings.
		//3. Strings may be pooled.
		//4. Use the .equals or .compareTo methods to check for lexicographical equality.




		//strResult refers to "Hello World." now. 
		String strResult1 = "Hello " + "World.";
		System.out.println(strResult1);


		//Ox32BC
		String strOne = "MPCS";
		String strTwo = strOne;

		
		String strState = "Mississippi";
		System.out.println(strState);
		strState = strState.replaceFirst("issipp", "our");
		System.out.println(strState);
		System.out.println(strState.length());
		
		System.out.println("Pardon me " + strState.substring(0,4));
		
		String strNeedsTrim = "    some string     ";
		System.out.println(strNeedsTrim);
		strNeedsTrim = strNeedsTrim.trim();
		System.out.println(strNeedsTrim);
		
		System.out.println(strOne.compareTo(strTwo));
		
		System.out.println("Hello".compareTo("Hello"));
		
		int nPos = strNeedsTrim.indexOf(' ');
		System.out.println(nPos);
		
		System.out.println(strState.endsWith("i"));


        //string pools

        String strBig0 = new String("Illinois");
        String strBig1 = new String("Indiana");
        String strBig2 = new String("Iowa");
        String strBig3 = new String("Michigan");
        String strBig4 = new String("Michigan State");
        String strBig5 = new String("Minnesota");
        String strBig6 = new String("Nebraska");
        String strBig7 = new String("Northwestern");
        String strBig8 = new String("Ohio State");
        String strBig9 = "Pennsylvania";
        String strBig10 = "Purdue";
        String strBig11 = "Wisconsin";

        String strNoLake0 = new String("Iowa");
        String strNoLake1 = new String("Nebraska");


		String strMostCorruptState0 = new String("Nevada");
		String strMostCorruptState1 = new String("Illinois");

		System.out.println("Illinois == Illinois? " + (strBig0 == strMostCorruptState1));
		System.out.println(strBig0.equals(strMostCorruptState1));



        System.out.println(56.21 == 56.21);

        //the == sign is comparing memory address
		//Ox1234
        Rectangle recOne = new Rectangle(2,3,4,5);
        //Ox2345
        Rectangle recTwo = new Rectangle(2,3,4,5);

        //this is false

        System.out.println(recOne == recTwo);


        recOne = recTwo;
        //this is true
        System.out.println(recOne == recTwo);


        //this should be false, but sometimes it's true??
        System.out.println(strNoLake1 == strBig6);

        String strSum = new String("");
        StringBuilder stringBuilder = new StringBuilder();

		for (int nC = 0; nC < 100; nC++) {
			stringBuilder.append(nC);
		}
		System.out.println(stringBuilder.toString());

		Rectangle rectangle = new Rectangle(1,3,56, 34);

		Date myDate = new Date();
		java.sql.Date myDate2 = new java.sql.Date(123132123342L);






    }
	
	
	
	

}
