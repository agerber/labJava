package edu.uchicago.gerber.labjava.lec05.glab.exceptions;

class BadStleUncheckedExceptionDriver3 {
	public static void main(String[] args) {

		//although getHighValue3 throws an exception, it's an unchecked one
		try {
			System.out.println(getHighValue3("Northwestern", "UIC", "Loyala", "Unviersity of Chicago", "DePaul"));
			//System.out.println(getReverseHighValue());
		} catch (NullVarArgsPointerException exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
		}
		
		
	}
	
	
	//no need to advertise that we throw exception here
	private static String getHighValue3(String... strParams) {
		
		if (strParams.length == 0)
			throw new NullVarArgsPointerException();
		
		String strHigh = strParams[0];
		for (int nC = 1; nC < strParams.length; nC++) {
			if(strHigh.compareTo(strParams[nC]) < 0){
				strHigh = strParams[nC];
				
		    }
		}
			
		return strHigh;
		

		
	}
	
	
	private static String reverseCharsRec(String str) {
		//base case
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		//recursive case(s)
		return reverseCharsRec(str.substring(1)) + str.charAt(0);
	}
	
	
	
	private static String getReverseHighValue(String... strParams) {
		
		return reverseCharsRec(getHighValue3(strParams));
	}
	
	
	
	
}

// ===============================================
// == inner class
// ===============================================

class NullVarArgsPointerException extends NullPointerException {

	//generate constructor from superclass

	public NullVarArgsPointerException() {
		super("Your var-args arguments must not be null");
		// TODO Auto-generated constructor stub
	}

	public NullVarArgsPointerException(String s) {
		super("Your var-args arguments must not be null" + s);
		// TODO Auto-generated constructor stub
	}

}