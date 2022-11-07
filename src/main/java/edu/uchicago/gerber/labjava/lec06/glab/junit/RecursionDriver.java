package edu.uchicago.gerber.labjava.lec06.glab.junit;

public class RecursionDriver {


    //press Ctrl+Shift+T to generate a Test case.
    //http://junit.sourceforge.net/javadoc/org/junit/Assert.html

    //make sure to install
    //JUnitGenerator V2.0
    //then use the alt-insert

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(myFactorialRec(5));
		System.out.println(myFactorialIter(5));

		System.out.println(replaceRec("Java", 'a', 'o'));
		System.out.println(replaceIter("Java", 'a', 'o'));

		//http://www.cs.arizona.edu/icon/oddsends/palinsen.htm
		System.out.println( reverseCharsRec("Marge let a moody baby doom a telegram."));
		System.out.println( reverseCharsIter("Marge let a moody baby doom a telegram."));

        //examine each frame in the debugger
        System.out.println(reverseCharsRec("Bears"));


    }

	// ===============================================
	// ==a factorial function using recursion
	// ===============================================

    /**
     *
     * @param nVal
     * @return
     * @should return some factorial recrusively
     */
	public static int myFactorialRec(int nVal) {
		//base-cases
		if (nVal < 1){
			throw new RuntimeException("no good");
		}
		//base-case
		if (nVal == 1)
			return 1;
		//recursive case(s)
		else {
			return nVal * (myFactorialRec(nVal - 1));
		}
	}
	
	// ===============================================
	// ==a factorial function using iteration
	// ===============================================


    /**
     *
     * @param nVal
     * @return
     * @should create factorial iteratively
     */
	public static int myFactorialIter(int nVal){
		
		int nResult = 1;
		for(int nC = nVal; nC > 0; nC--){
			nResult *= nC; //nResult = nResult * nC;
		}
		
		return nResult;
	}
	
	// ===============================================
	// ==a char replace function using recursion
	// ===============================================

    /**
     *
     * @param str
     * @param cOld
     * @param cNew
     * @return
     * @should replace a char in a string recursively
     */
	public static String replaceRec(String str, char cOld, char cNew) {
		if (str.length() == 0)
			return "";
		else if (str.charAt(0) == cOld)
			return cNew + replaceRec(str.substring(1), cOld, cNew);
		else
			return str.charAt(0) + replaceRec(str.substring(1), cOld, cNew);
	}
	
	// ===============================================
	// ==a char replace function using iteration
	// ===============================================

    /**
     *
     * @param str
     * @param cOld
     * @param cNew
     * @return
     * @should replace some char in a string iteratively
     */
	public static String replaceIter(String str, char cOld, char cNew) {
		
		String strReturn = "";
		//for each char in str; replace
		for (int nC = 0; nC < str.length(); nC++) {
			if(str.charAt(nC) == cOld){
				strReturn += cNew;
			}
			else {
				strReturn += str.charAt(nC);
			}
				
			
		}//end for
		
		return strReturn;
		
		
	}

	

	//http://fractalfoundation.org/OFC/OFC-index.htm
	//Mandelbrot || Julia

	//Fractal applications || Bridging gap || Fractal Devices

	   
	
	// ===============================================
	// ==a char reverse function using recursion
	// ===============================================

    /**
     *
     * @param str
     * @return
     * @should reverse the chars
     */
	public static String reverseCharsRec(String str) {
		//base case
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		//recursive case(s)
		return reverseCharsRec(str.substring(1)) + str.charAt(0);
	}
	
	
	// ===============================================
	// ==a char reverse function using iteration
	// ===============================================
    /**
     *
     * @param str
     * @return
     * @should reverse the chars iteratively
     */
	public static String reverseCharsIter(String str) {
		String strRet = "";
		//iterate over string backwards building return string
		for (int nC = str.length()-1; nC >=0 ; nC--) {
			//strRet += str.charAt(nC);
			strRet = appendChar(strRet,str.charAt(nC) );
			
		}
		return strRet;
	}


    /**
     *
     * @param strBase
     * @param cEnd
     * @return
     * @should append a char to the end
     */
	private static String appendChar(String strBase, char cEnd){
		
		return strBase + String.valueOf(cEnd);
	}
	
	

	
	
	
}
