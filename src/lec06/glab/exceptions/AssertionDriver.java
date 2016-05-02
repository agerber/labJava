package lec06.glab.exceptions;

public class AssertionDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		printDoubleValue(null);
		//printDoubleValue(new Double(0));

	}
	
	//use assertsions to check for preconditions
	//they can illuminate possible glitches in your code and 
	//opportunities to place checking code or throw exceptions
	
	
	//preconditions
	//param is not null
	//parm is not zero
	
	private static void printDoubleValue(Double dubParam){
		
		//use assertions for pre-conditions of methods
		//you will need to use -enableassertions in your run configs
		//assert dubParam != null;
        assert dubParam != null : "your param is null";

		assert dubParam.doubleValue() != 0 : "your param is zero";
		
//		if (dubParam == null)
//			return;
		
		System.out.println(100/dubParam.doubleValue());
		
	}
	
	
	

}
