package edu.uchicago.gerber.labjava.lec02;

public class PromotionAndCastingPrimitives {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		double dOperand1 = 5.897;
		int nOperand2 = 8;
		
		//promotion works when:
		//there are two operands of different primtive types; the smaller precision operand will get promoted to larger precision operand
		double dResult = dOperand1 / nOperand2; //here nOperand2 is promoted to double

		//integer division - will truncate, not round! The result will be 2
		int nResultIntDivision =  23/ 8;



		//the primitive result on the left of the assignment operator is of greater precision than the result of the right expression
		//in this case, the result of integer division is 2.66666 trucated to 2, then the result is assigned as (2.0)
		float fResult = nOperand2 / 3;

		//you concatenate a string with a primitive, the primitive is promoted to a string
		String strResult = "Hello" + dOperand1;

		System.out.println("nResultIntDivision: " +nResultIntDivision);
		System.out.println("dResult: " +dResult);
		System.out.println("fResult: " +fResult);
		System.out.println("strResult: " +strResult);
		
		//you can downcast a primitive. 
		//upcasting happens automatically; it's called promotion and you lose no precision
		//downcasting loses precsion

		//truncate - not round
		int nAnswer1 = (int)56.9356974;
//
//
//		//long lAnswer1 = Math.max(3.856, 98798798);
//		long lAnswer1 = Math.max((long)3654.856, 568211);
//		//you must cast and casting primitives sometimes loses precision
//
     	System.out.println("truncate, not round: " + nAnswer1);
//		System.out.println(lAnswer1);

        //BASIC RULES OF INTEGER DIVISION
        //keep in mind that integer division produces a TRUNCATED result, not rounded
        int nResult = 14 / 5 ;  //the result is 2, not 3

        //if you want to know the remainder of integer division, use the modulus operator
        int nRemainder = 14 % 5;   //remainder is 4

        //AUTOMATIC PROMOTION (AKA UPCASTING) -- will not reduce precision of result
        //in the following example, 51 (an int) will be cast to a double
        double dVal = 51 / 24.89989;

        float fValue =   89393.0008F;
        long lValme = 89393898L;


        //EXPLICIT CASTING (AKA DOWNCASTING) --will result in loss of precision
      //  int nVal =  51 / 24.89989;

        //long lNum = Math.max(3654.856, 568211);

        //in Java floating point operations result in double, so you must cast to a float
        //float fVal =  50.9854 / 24.89989;




//		int to byte downcasting
//		0000 0000 0000 0000 0000 0000 0100 1001
//		                              0100 1001


//				-119
//
//		http://www.binaryhexconverter.com/binary-to-decimal-converter
//		(256 + 128 + 8 + 1) = 393
//      -128 + 8 + 1 = -119
//		to byte


		int nNumber = 393;
		byte yNumber = (byte) nNumber;
		System.out.println(yNumber);

		System.out.println(Integer.toBinaryString(nNumber));




	}

}
