package lec01.glab;

public class PromotionAndCastingPrimitives {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        //BASIC RULES OF INTEGER DIVISION
        //keep in mind that integer division produces a TRUNCATED result, not rounded
        int nResult = 14 / 5 ;  //the result is 2, not 3

        //if you want to know the remainder of integer division, use the modulus operator
        int nRemainder = 14 % 5;   //remainder is 4

        //AUTOMATIC PROMOTION (AKA UPCASTING) -- will not reduce precision of result
        //in the following example, 51 (an int) will be cast to a double
        double dVal = 51 / 24.89989;


        //EXPLICIT CASTING (AKA DOWNCASTING) --will result in loss of precision
        //int nVal =  51 / 24.89989;

        //long lNum = Math.max(3654.856, 568211);

        //in Java floating point operations result in double, so you must cast to a float
        //float fVal =  50.9854 / 24.89989;



	}

}
