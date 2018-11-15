package lec01.glab;

import java.util.Scanner;

//import ParserUtils;


/**
 * 
 * @author Adam Gerber
 *
 */
public class DigitalToBinary {


 /**
  * 
  * @param args main meth args
  */
	public static void main(String[] args) {
		
		


			
		//do loop
	        //ask the user for some byte value or type exit to quit
		    //if the value is 'exit'
				//"Thank you for playing"
		        //break
	        //convert that String value to a Byte (handle any exceptions)
		    //processValue() and print out results
		
		
		
		//processValue()
		//given the bitLength of a byte and the value
		//build a string representation; use String[] length of Byte.SIZE
		//set the strChars[bitLength -1] = "0"
		//for some counter init to bitLength - 2 and decremented to zero inclusive
			//if the value is greater than= 2^counter
				//put "1" to the String Array at that location
				//subtract 2^counter from the value
		    //else
				//put "0" to the String Array
		
		
		//iterate the array while array index < length of array
			//if divisible by 4, 
				//then space +  index value
			//else
			    //index value
		
		//return string

		

		
		
		
		Scanner scn = new Scanner(System.in);
	   //alt is public Scanner(File source)  throws FileNotFoundException

		String sValue;
		
	

		do {

					System.out.println("Enter an integer between 0 and 127 to convert from digital" +
							" to binary: (or type exit to quit.)");
			
					sValue = scn.nextLine();
						if (sValue.equals("exit")) {
							
					      System.out.println("Thanks for playing. Good bye.");
							 break;
						}
						
				    try{
				    	//this could throw an execption
				    	byte yNum = Byte.parseByte(sValue);
				    	
				    	if (yNum < 0)
				    		throw new NumberFormatException("Your byte is negative, sorry positive numbers only.");
				    	
				 
				        System.out.println(convertDigitalToBinary(Byte.SIZE, Byte.parseByte(sValue)));
				    }
				    catch(Exception e){
				    	e.printStackTrace(System.out);
				    	System.out.println("try again..or type exit to quit. Error:" + e.getMessage());
				    	continue;
				    }

		} while(true); //infinite loop. Will only break upon entering 'exit'
		

		
		

	}
	
	//given the bitLength of the primitive type and the value
	/**
	 * 
	 * @param nBitLength the length of the integer type that you pass in
	 * @param lValue   value of the string you want to convert to binary 
	 * @return returns a string formatted with spaces representing a binary number
	 */
	public static String convertDigitalToBinary(int nBitLength, long lValue){
		
		
		//build a string representation; possible prims are byte, short, int, and long
		//define some variables; the string to output/return; a String[] 
		String strOut = "";
		String[] strChars = new String[nBitLength];

		
		strChars[nBitLength - 1] = "0";
		//for some counter init to bitLength - 1 and decremented to zero inclusive
		for(int nCounter = nBitLength - 2; nCounter >= 0; nCounter--){
			//if the value is greater than= 2^counter
			if(lValue >= (long)Math.pow(2, nCounter) ){
				
				//put "1" to the String Array at that location
				strChars[nCounter] = "1";
				//subtract 2^counter from the value
				lValue -= (long)Math.pow(2, nCounter);
			}
		    //else
			else {
				//put "0" to the String Array
				strChars[nCounter] = "0";
			}
				
		
		}	
		
       //put some spaces --for maximum effect
		for(int nC =0; nC < strChars.length; nC++ ){
		
			//if divisible by 4,
			if(nC % 4 == 0){
			
				strOut =strChars[nC] + " " + strOut ;
			}
			else {
			
				strOut =strChars[nC] + strOut ;
			}
				
			
			
		}
		
		//return string
		
		return strOut;
		
		
		
	}
	
	

}
