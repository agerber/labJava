package lec03.glab;
import java.awt.Rectangle;


public class VarsAndRefs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		intDivision();
		refNotInitialized();
		ternaryOperator();
        deMorgans();

	}
	
	private static void intDivision() {
		
		int nNumerator = 0;
		int nDenominator = 0;
		int nResult = 0;
		float fResult = 0;
		
		nNumerator = 5;
		nDenominator = 2;

		nResult = nNumerator / nDenominator;
		fResult = nNumerator / nDenominator;
		
		System.out.println(nResult);
		System.out.println(fResult);

	}
	
	private static void varNotInitialized() {

		
		int nNumber = 5;
		

		System.out.println(nNumber);

	}
	
	private static void refNotInitialized() {

		//Rectangle recRec1
		Rectangle recRec1 = null;
		

		System.out.println(recRec1);
	}
	
	
	private static void relationalOperators(){
		
		int nNumerator = 4;
		int nDenom = 13;
		
		if (nNumerator != nDenom)
			System.out.println("numerator != denominator");
		else if (nNumerator < nDenom)
			System.out.println("numerator > denominator");
		else if (nNumerator > nDenom)
			System.out.println("numerator < denominator");
		else
			System.out.println("numerator == denominator");
		
	}
	
	private static void booleanOperators(){
		
		int nNum = 4;
		int nDenom = 13;
		boolean bYes = true;
		boolean bNo = false;
		
		
		
		if (bYes &&  bNo)
			System.out.println("yes &&  no");
		 if (bYes || bNo)
			System.out.println("yes || no");
		if (bYes &&  bYes)
			System.out.println("yes &&  yes");
	     if (bNo ||  bYes)
			System.out.println("no ||  yes");
	     
	     if (nNum != nDenom || bNo)
	    	 System.out.println("numerator != denominator || no");

		
	}


    private static void deMorgans(){

        //when you see an boolean expression and you want to flip it, you can
        //1/ distribute the ! sign
        //2/ flip the && to || or vice versa

        //control
        System.out.println((true && false || false && true)  == (true && false || false && true));

        //deMorgans
        System.out.println(!(true && false || false && true)  == (!true || !false && !false || !true));
    }
	
	//order of precedence
	//http://download.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
	
	
	public static void ternaryOperator() {
		
		//boolean expression ? return1 : return2 
		int nOp1 = 5;
		int nOp2 = 7;
		
		System.out.println(nOp1 < nOp2 ? "yes" : "no");


		
	}


	
	
	
	
	

}
