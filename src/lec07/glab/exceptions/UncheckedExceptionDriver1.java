package lec07.glab.exceptions;

public class UncheckedExceptionDriver1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	

		
		System.out.println(getValue(null));
		

	}
	
	
	private static int getValue(Integer intParam){


		//this will throw NullPointerExcpetion because
		//intParam is null

		//very common exception
		//this is OUR fault and definitely within our control
		
		//solution; put in a check first
		//if(intParam == null)
		
	     return intParam.intValue();
	}
	
	
	
	
	
	

}
