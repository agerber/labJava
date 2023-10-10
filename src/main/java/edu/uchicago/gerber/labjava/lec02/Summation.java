package edu.uchicago.gerber.labjava.lec02;

import java.util.Scanner;


public class Summation {

	
	public static void main(String[] args){
		
       Scanner scn = new Scanner(System.in);
		System.out.println("Enter a positive value to sum all even numbers from zero to and" +
				" including " +
				"your max value, or type exit to quit");
		
		boolean bKeepGoing = true;	
		String sValue = "exit";
		
		
		sValue = scn.nextLine();
		bKeepGoing = isValidInput(sValue);

		
        while(bKeepGoing){
        	
    		
    	 if (sValue.equals("exit")){
    			System.out.print("Exiting; ");
        		 bKeepGoing = false;
        	}
        	else {
        		
        		long lSum = 0;
        		int nMax = Integer.parseInt(sValue);
        		for (int nCount = 0; nCount < nMax; nCount++){
        			
        			if (nCount % 2 == 0) {
        				System.out.println(nCount + "+");
        				lSum += nCount;
        			}
        	
        			
        			
        		}
        		
        		System.out.println("Total value is: " + lSum);
        		System.out.println();
        		System.out.println("Enter max value (or type exit to quit):");
        		
        		sValue = scn.nextLine();
        		
        		
        	}
        	
        	
        }
        System.out.println("Thanks for playing.");
        
       

	}
	

	

	
	private static boolean isValidInput(String strParam){
		
		if(strParam.equals("ERROR"))
			return false;
		
		
		if (strParam.equals("exit"))
			return true;

		
		try {
			
		int nTest =	Integer.parseInt(strParam);
		if (nTest < 0){
			System.out.print("Your number is less than zero; ");
			return false;
		}
		else
			return true;
		}
		catch (Exception e) {
			e.printStackTrace(System.out);
			return false;
			
		}
	}
	
	


}

