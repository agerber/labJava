package lec04.exceptions;

import java.awt.*;

public class TestExceptions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//doesn't throw an exception
		//check it (F1) in the API
		int nSize = "Hello".length();

		int nNum;
		Robot robRobot;

		//sometimes it doesn't complain,
		//but you should still check it and surround with try/catch
		nNum = Integer.parseInt("18");

		//will complain
		//Robot robRobot = new Robot();

		//surrounding with try/catch
		//		try {
		//			 robRobot = new Robot();
		//		} catch (AWTException awe) {
		//			// TODO Auto-generated catch block
		//			awe.printStackTrace();
		//		}
		//		

		//let's put both statements (which throw possible exceptions)
		//in the same try block
		try {
			robRobot = new Robot();
			// Scanner scn = new Scanner(System.in);
			// robRobot.keyPress(KeyEvent.VK_5);
			// robRobot.keyPress(KeyEvent.VK_ENTER);

			nNum = Integer.parseInt("hello");
			//nNum = Integer.parseInt(scn.nextLine());
			System.out.println("you pressed: " + nNum);

			//throw new ActivationException("my activation exception.");

		} catch (Exception e) {

			if (e instanceof AWTException)
				System.out.println("this system doesn't allow low level access"
						+ e.getMessage());
			else if (e instanceof NumberFormatException)
				System.out.println("that's not an integer!" + e.getMessage());
			else
				System.out.println(e.getMessage());
		}

		//finally define another method that throws and then catch it

		try {
			printNumberToConsole("this is my text");
		} catch (Exception e) {

			//e.printStackTrace();

			System.out.println("caught it! " + e.getMessage());

		}
		

		//what if the called
		//method throws an exception but it isn't caught;
		//then it's thrown up the call stack until it is. 
		
		
		//let's just instantiate an excepton and throw it for grins
		//this won't be caught and it'll terminate our program
	//	throw new NumberFormatException("just kidding.");
	
		
		

	}

	private static void printNumberToConsole(String strParam)
			throws NumberFormatException {

		try {
			int nVal = Integer.parseInt(strParam);
			System.out.println("your value is: " + nVal);
		} catch (NumberFormatException nfe) {
			// TODO Auto-generated catch block
			throw nfe;
		}

	}

}
