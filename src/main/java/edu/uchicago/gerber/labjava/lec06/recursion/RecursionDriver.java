package edu.uchicago.gerber.labjava.lec06.recursion;

public class RecursionDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		System.out.println(replaceRec("Java", 'a', 'o'));
		System.out.println(replaceIter("Java", 'a', 'o'));


		System.out.println(myFactorialRec(5L));
		System.out.println(myFactorialIter(5L));

        testIsPalindrome("A man, a plan, a canal, Panama!");
        testIsPalindrome("Madam, I'm Adam");
        testIsPalindrome("Whatever words you want!");
        testIsPalindrome("Marge let a moody baby doom a telegram.");



		System.out.println(replaceIter(replaceRec("adam", 'a', 'e'), 'm', 'n'));

		//http://www.cs.arizona.edu/icon/oddsends/palinsen.htm
		System.out.println( reverseCharsRec("Marge let a moody baby doom a telegram."));
		System.out.println( reverseCharsIter("Marge let a moody baby doom a telegram."));


		
	

	}


	// 1/ you must have at least one base case, and at least one recursive case.
	// 2/ your recursive case(s) must converge towards the base case(s)

	// recursion does not execute immediately, rather it places that method call on the
	// call-stack until it reaches the base case, at
	// which point, the stack unwinds.


    private static long myFactorialIter(long lVal){
		long lResult = 1L;

		for (long lC = lVal; lC > 0 ; lC--) {
			lResult *= lC;
		}
		return  lResult;
	}

	private static long myFactorialRec(long lVal){

		//base-case
		if (lVal < 1){
			throw new RuntimeException("sorry dude, your factorial must be gerater than 1");
		}

		//base-case(s)
		if(lVal == 1){
			return  1;
		}
		//recursive-case(s)
		else {
			return  lVal * myFactorialRec(lVal -1);
		}
	}


























	
	// ===============================================
	// ==a char replace function using recursion
	// ===============================================
	public static String replaceRec(String str, char cOld, char cNew) {
		//base-case
		if (str.length() == 0)
			return "";
		//recursive-case
		else if (str.charAt(0) == cOld)
			return cNew + replaceRec(str.substring(1), cOld, cNew);
		//recursive-case
		else
			return str.charAt(0) + replaceRec(str.substring(1), cOld, cNew);
	}
	
	// ===============================================
	// ==a char replace function using iteration
	// ===============================================
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
	private static String reverseCharsRec(String str) {
		//base case
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		//recursive case(s)
		return reverseCharsRec(str.substring(1)) + str.charAt(0);
	}




    // ===============================================
    // ==a char reverse function using recursion
    // ===============================================
    private static String reverseCharsAndRemoveRec(String str) {
        //base case
        if (str.length() == 1) {
            if (!Character.isLetter(str.charAt(0))){
                return "";
            } else {
                return String.valueOf(str.charAt(0));
            }
        }
        //recursive case(s)
        if (!Character.isLetter(str.charAt(0))){
            return reverseCharsAndRemoveRec(str.substring(1));
        } else {
            return reverseCharsAndRemoveRec(str.substring(1)) + str.charAt(0);
        }

    }

    private static String removeNotLettersRec(String str){
        //base case
        if (str.length() == 1) {

            if (!Character.isLetter(str.charAt(0))){
                return "";
            } else {
                return String.valueOf(str.charAt(0));
            }
        }
        //recursive case(s)
        if (!Character.isLetter(str.charAt(0))){
            return removeNotLettersRec(str.substring(1));
        } else {
            return str.charAt(0) + removeNotLettersRec(str.substring(1));
        }

    }

    private static void testIsPalindrome(String str){
        String strForward = removeNotLettersRec(str);
        String strBackward = reverseCharsAndRemoveRec(str);
        int n = 7;
        Integer intMe = new Integer(7);



        if (strForward.equalsIgnoreCase(strBackward)){
            System.out.println(strForward + " == " + strBackward + " : this is a palindrome.");

        } else {
            System.out.println(strForward + " != " + strBackward + " : this is NOT a palindrome.");

        }
    }



    // ===============================================
	// ==a char reverse function using iteration
	// ===============================================
	private static String reverseCharsIter(String str) {
		String strRet = "";
		//iterate over string backwards building return string
		for (int nC = str.length()-1; nC >=0 ; nC--) {
			//strRet += str.charAt(nC);
			strRet = appendChar(strRet,str.charAt(nC) );
			
		}
		return strRet;
	}
	
	
	private static String appendChar(String strBase, char cEnd){
		
		return strBase + String.valueOf(cEnd);
	}
	
	

	
	
	
}
