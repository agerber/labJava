package edu.uchicago.gerber.labjava.lec01.glab;


import java.util.Scanner;

public class BinaryToDigital {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		//while (true) infinite loop
			//ask the user for input (a string of one,zeros, and spaces representing a binary number)
			//if the input is 'exit'
				//print out "Thanks for playing. Good bye."
				//break
			//validate() that the input string is a valid binary with 8, 16, 32, or 64 bits represented not including any spaces
			//if the input is not valid 
				//print out "input is not a valid binary... (and then explain the rules.)"
				//continue
			
		//processString()
		//take the validated above string as parameter
		//iterate; start from the last character and work backwards
		//initialize an int nPow to zero
		//for each char in string (iterate over the string backwards)
		   //if char is not valid (1, 0  or space)
				//throw an exception
		   //if the char is 1 or zero
				//if 1
			        //increment a result by 2^nPow 
		       //increment nPow
		 //return result
		
		
		
		String strValue;
        Scanner in = new Scanner(System.in);

		do {

					System.out.println("Enter an string that represents a byte in binary" +
							" : (or type exit to quit.)");
					 strValue = in.nextLine();
						if (strValue.equals("exit")) {
							
					      System.out.println("Thanks for playing. Good bye.");
							 break;
						}
						
				    try{		
				     System.out.println(convertToNumeric(strValue));
				    }
				    catch(Exception e){
				    	e.printStackTrace(System.out);
				    	System.out.print(e.getMessage() + "try again; here's an example \"0101 1111\"");
				    	System.out.println(" or type exit to quit." );
				    	continue;
				    }

		} while(true); //infinite loop. Will only break upon entering 'exit'
		
		
		
	

	}
	
	public static long convertToNumeric(String sParam){
		

		//processString()
		//take the validated above string as parameter
		//iterate; start from the last character and work backwards
		//initialize an int nPow to zero
		//initialize a long lResult to zero
		int nPow = 0;
		long lResult = 0;
		String strChar;
	
		//for each char in string (iterate over the string backwards) and exclude the sign bit
		for(int nPos = sParam.length(); nPos > 0; nPos--) {
		
			//can't have more 0 to 6 (the 7th is the sign bit) will not read the rest if string contains too many zeros or ones. 
			if (nPow > 7 )
				throw new NumberFormatException("Too many ones or zeros for this to be a binary.");
		   //if char is either 
			strChar = sParam.substring(nPos - 1, nPos);
			if(!strChar.equals("0") && !strChar.equals("1") && !strChar.equals(" "))
					throw new NumberFormatException("You can only use zeros ones and spaces.");
		     	
			if (strChar.equals("0") || strChar.equals("1")){
				
				//check for sign bit
				if(!strChar.equals("0") && nPos  == 1 && sParam.length() > 1)
					throw new NumberFormatException("The sign bit must be zero.");
				
			    if (strChar.equals("1")){
				     lResult += (long) Math.pow(2, nPow );
			    }
			    
		        nPow++;
		         
			}
		}
		return lResult;
		

		
	}
	

}
