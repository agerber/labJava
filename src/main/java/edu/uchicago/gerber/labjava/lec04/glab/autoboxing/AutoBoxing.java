package edu.uchicago.gerber.labjava.lec04.glab.autoboxing;

import java.util.ArrayList;

public class AutoBoxing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> intNums = new ArrayList<>();
        intNums.add(98);
        intNums.add(98);



        Double dub = 3.4;
        Integer intme = 4;
        
        double dub2 = new Integer(6);
        double dub3 = 6;


		Integer intNum1 = new Integer(5);
		Integer intNum2 = 5;  // autoboxing; released in Java5
		
		if(intNum1.equals(intNum2))
			System.out.println("Integer values are the same: " + intNum1 + " equals " +  intNum2);
		else
			System.out.println("Integer values are NOT the same: " + intNum1 + " not equals " +  intNum2);




		int nNum1 = -271;
		//nNum1 = intNum1; //auto-unboxing
		int nNum2 = new Integer(81); // auto-unboxing; released in Java5
		
		if(nNum1 == nNum2)
			System.out.println("int values are the same: " + nNum1 + " == " +  nNum2);
		else
			System.out.println("int values are NOT the same: " + nNum1 + " != " +  nNum2);

	}

}
