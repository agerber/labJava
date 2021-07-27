package edu.uchicago.gerber.labjava.lec05.glab.exceptions;

public class UncheckedExceptionDriver2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		System.out.println(getHighValue("Bears", "Vikings", "Browns", "Dophins"));
		System.out.println(getHighValue2());
	}

	private static String getHighValue(String... strParams){
		
		
	
		//this will throw ArrayIndexOutOfBoundsException because
		//strParams.length + 1
		//notice that it is NOT checked
		//this is OUR fault and definitely within our control
		//solution: better coding
		
		String strHigh = strParams[0];
		for (int nC = 1; nC < strParams.length + 1; nC++) {
			if(strHigh.compareTo(strParams[nC]) < 0){
				strHigh = strParams[nC];
				
		    }
		}
			
		return strHigh;
		

		
	}
	
	
	private static String getHighValue2(String... strParams){
		
		
		//even if our code seems perfect
		//this may throw ArrayIndexOutOfBoundsException 
		//if we pass in no strings
		//System.out.println(strParams);
		
		//solution: check for length of zero
		//if (strParams.length == 0)
			//return "";
		
		String strHigh = strParams[0];
		for (int nC = 1; nC < strParams.length; nC++) {
			if(strHigh.compareTo(strParams[nC]) < 0){
				strHigh = strParams[nC];
				
		    }
		}
			
		return strHigh;
		

		
	}
	
	
	
	
	

}
