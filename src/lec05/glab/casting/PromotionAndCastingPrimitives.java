package lec05.glab.casting;


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
		//the primitive operand on the left of the assignment operator is of greater precision than the result of the right expression
		//in this case, the result of integer division is 2.66666 trucated to 2, then the result is assigned as (2.0)
		float fResult = nOperand2 / 3;
		//you concatenate a string with a primitive, the primitive is promoted to a string
		String strResult = "Hello" + dOperand1;
		
		System.out.println(dResult);
		System.out.println(fResult);
		System.out.println(strResult);
		
		//you can downcast a primitive. 
		//upcasting happens automatically; it's called promotion and you lose no precision
		//downcasting loses precsion
		
		int nAnswer1 = (int)56.9356974;
		
		//long lAnswer1 = Math.max(3.856, 98798798);
		long lAnswer1 = Math.max((long)3654.856, 568211);
		//you must cast and casting primitives sometimes loses precision
		
		System.out.println(nAnswer1);
		System.out.println(lAnswer1);
	}

}
