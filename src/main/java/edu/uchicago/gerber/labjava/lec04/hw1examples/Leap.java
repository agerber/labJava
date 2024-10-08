package edu.uchicago.gerber.labjava.lec04.hw1examples;


import java.util.Scanner;
import java.util.StringTokenizer;

public class Leap {

	/*
	9. Using no date-specific Java libraries, write a program that computes
   the number of days between any two dates (inclusive). You must take
   into account leap years. The rule for computing a leap year is as
   follows: 
   
   If the year is divisible by 4 it is a Leap Year ...
   Unless the year is divisible by 100, then it is _not_ a Leap Year
   ...  Unless the year is divisible by 400, then it _is_ a Leap Year.
   
   During a Leap year, an extra day is added at the end of the month
   of Feb.

   ex. 1000 is not a Leap Year
       2000 is a Leap year

   Your program must be run as follows:
   PROMPT>> java DaysBetween 11/11/2002 11/12/2002
   1 day
   (program ends)

   Error checking. Be sure to handle at least the following:
     - if there is too few or too many input parameters
     - if the date strings are not in the proper format
        (simply echo usage statement);
     - if date 1 is not earlier than date 2
	 */
	
	
	
	
	//NOT A COMMAND-LINE; SYSTEM.IN ONLY
	public static void main(String[] args) {

		int nCount = 0;
		Scanner scn = new Scanner(System.in);
		System.out.println("What are your dates in forat mm/dd//yyyy mm/dd/yyyy:");
		
		StringTokenizer stoDates = new StringTokenizer(scn.nextLine());
		
		if (stoDates.countTokens() !=2)
			return;
		
		
		MyDate[] mdtDates = new MyDate[stoDates.countTokens()]; 
		
		try{
		
		StringTokenizer stoNums;
		int nC = 0;
		while(stoDates.hasMoreTokens()){
			
			stoNums = new StringTokenizer(stoDates.nextToken(), "/");
			String strM = stoNums.nextToken();
			String strD = stoNums.nextToken();
			String strY = stoNums.nextToken();
			
			int nM = Integer.parseInt(strM);
			int nD = Integer.parseInt(strD);
			int nY = Integer.parseInt(strY);
			
			nM--;
			
			mdtDates[nC] = new MyDate(nD, nM, nY);
			
			nC++;
			
		}
	
		} catch(NumberFormatException nfe){
			System.out.println("nfe");
			return;
		}
		
		MyDate mdtBegin = mdtDates[0];
		MyDate mdtEnd = mdtDates[1];
		
		String strDateBegin = mdtBegin.toString();
		
		if(mdtBegin.compareTo(mdtEnd) >= 0){
			System.out.println("end smaller than begin");
			return;
		}
		
		
		
		while(mdtBegin.compareTo(mdtEnd) <0){
			mdtBegin.addDay();
			nCount++;
		}
		

		System.out.println("Days between " + strDateBegin + " and " + mdtEnd + " are " + nCount);
		

	}
	


}
