package lec04.varargs;

import java.lang.String;import java.lang.System;public class Elipses {


	public static void main(String[] args) {


		sum("The sum of",8,2,5,7, 6, 8, 101, -9);

	}
	
	//elipses aka varargs, introduced in Java5
	private static void sum(String strSum, int... nParams){
		int nResult = 0;
		System.out.print(strSum + " ");
		//notice that the int... is converted to int[] inside the method
		for (int nC = 0; nC < nParams.length; nC++) {
			if (nC == nParams.length - 1)
				System.out.print("and " + nParams[nC]);
			else
			     System.out.print(nParams[nC] + ", ");
			
			nResult += nParams[nC]; 
		}
		
		System.out.print(" is: " + nResult);
		
	}

}
