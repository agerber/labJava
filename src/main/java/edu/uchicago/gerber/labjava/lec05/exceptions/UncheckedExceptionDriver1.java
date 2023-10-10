package edu.uchicago.gerber.labjava.lec05.exceptions;

public class UncheckedExceptionDriver1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	

		
		System.out.println(getValue(null));
		

	}

    /**
     *
     * @param intParam
     * @return
     * @pre intParam is not null
     */
	private static int getValue(Integer intParam){

        //this does not really buy us much.
        //Let the JVM throw the unchecked exceptions
//        if(intParam == null){
//            throw new PreconditionNotMet("intParam was null in method getValue in" + UncheckedExceptionDriver1.class.toString());
//        }

        //if you get uchecked (RuntimeExceptions) then, typically, it's your fault.
        //If you are getting data from a user and that data is erronous, throw a checkedException so that you can deal with it early.


		//this will throw NullPointerExcpetion because
		//intParam is null

		//very common exception
		//this is OUR fault and definitely within our control
		
		//solution; put in a check first
		//if(intParam == null)
		
	     return intParam.intValue();
	}
	
	
	
	
	
	

}
