package edu.uchicago.gerber.labjava.lec01.glab;


import java.util.Scanner;

public class EnterSomething {


	public static void main(String[] args) {

		//declare a string to hold input
	    //while input != exit
			//ask for input and give instructions
			//print integer-values of chars
			
        Scanner in = new Scanner(System.in);
		String strInput;
		do
		{
             System.out.println("Enter something: (or exit to quit)");
             strInput = in.nextLine();



             //System.out.println("Echo:" + strInput );
			System.out.println(getIntegerVals(strInput));

		         
		} while(!strInput.equals("exit"));
		


	}

	private static  String getIntegerVals(String strSentence){

		StringBuilder stbReturn = new StringBuilder();

		for (int nC = 0; nC < strSentence.length(); nC++) {

			stbReturn.append("[" + Character.getNumericValue(strSentence.charAt(nC)) + " ]");
		}

	return 	stbReturn.toString();

	}


}

