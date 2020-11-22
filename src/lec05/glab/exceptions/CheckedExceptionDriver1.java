package lec05.glab.exceptions;

import java.net.MalformedURLException;

public class CheckedExceptionDriver1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//callMethodThatThrowsCheckedExcpetion();
		
		callMethodThatThrowsCheckedExcpetionFinally();
		
	}
	
	//can't do this
//	private static void getURL(){
//		
//		throw new InappropriateURLException();
//	}
//	

	
	//let it pass through your layer purposefully (you have a pass)
	private static void getURLPropogate() throws InappropriateURLException {
	
		//do some stuff
		//if condition is met
	        throw new InappropriateURLException();
     }
	
	//catch it and do somehting with it. 
	private static void getURLHandle() {
	
		//do some stuff
		//if condition is met
	       try {
				throw new InappropriateURLException();
			} catch (InappropriateURLException exp) {
				System.out.println(exp.getMessage());
			}
     }
	
	
	
	
	private static void callMethodThatThrowsCheckedExcpetion(){
		
		System.out.println("Step One");
		//getURLHandle(); no problem 
		//show quick-fixes
		try {
			System.out.println("Step Two");
			getURLPropogate();
			System.out.println("Step Three");
		} catch (InappropriateURLException exp) {
			System.out.println("Step Four");
			System.out.println(exp.getMessage());
			System.out.println("Step Five");
		}
		
		System.out.println("Step Six");
		
	}
	
	//proper way to call finally
	private static void callMethodThatThrowsCheckedExcpetionFinally(){
		
		System.out.println("Step 1");
		//getURLHandle(); no problem 
		//show quick-fixes
		try {
			try {
				//code that may leave resources in a locked or open state
				//database connection
				//open file
				System.out.println("Step 2");
				getURLPropogate();
				System.out.println("Step 3");
			} finally  {
			   
				//what if your finally block throws an exception!!
				System.out.println("Step 4");
				System.out.println("close any resources and do any clean-up");
				System.out.println("Step 5");
				//throw new RuntimeException("can't find resource to close.");
				
			}

		//take advantage of polymorphism 
		//you can even catch a Throwable to include errors
		} catch (Exception exp) {
			if (exp instanceof InappropriateURLException){
				System.out.println("Step 6");
				System.out.println(exp.getClass().getName() + " " + exp.getMessage());
				System.out.println("Step 7");
			}
			else{
				
				System.out.println("Step 8");
				//do something
				System.out.println("Step 9");
				
			}
		}
		
		System.out.println("Step 10");
	}


    static class InappropriateURLException extends MalformedURLException {

        public InappropriateURLException() {
            super("This site is inappropriate.");
            // TODO Auto-generated constructor stub
        }

        public InappropriateURLException(String msg) {
            super("This site is inappropriate." + msg);
            // TODO Auto-generated constructor stub
        }

        //generate constructor from superclass


    }

}//end class


