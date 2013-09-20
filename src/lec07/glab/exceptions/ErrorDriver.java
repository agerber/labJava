package lec07.glab.exceptions;

import javax.swing.*;
import java.io.IOError;
import java.util.ArrayList;

public class ErrorDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//this Exception (Error) is unchecked
		//its probably source is the VM
		//it is outside of your control 
	
	
		
		findPrinterBurryError();
		findPrinterHandleError();
		doSomeMemoryIntensiveOperations3();
		
	}
	
	
	//case 1: do nothing
	//since, Errors are unchecked, contractually, you don't have to handle anything
	//let the VM deal with it and notify the user. 
	//if you were to try to handle this? What will happen to the application if the 
	//Error is not propogated to the VM
	
	//best solution here: increase the allocated heap memory
	
	
	private static void doSomeMemoryIntensiveOperations1(){
		
		//runtime configs; you can set the heap size. 
		//-Xms32m -Xmx128m

        System.out.println("Heap Size = " + Runtime.getRuntime().totalMemory());
		
		ArrayList<Integer> intNums = new ArrayList<Integer>();
		while (true){
			intNums.add(new Integer(58));
		}
	}
	
	
	private static void doSomeMemoryIntensiveOperations2(){
		

    	
		ArrayList<Integer> intNums = new ArrayList<Integer>();
		while (true){
			intNums.add(new Integer(58));
		}
	}
	

	
	private static void doSomeMemoryIntensiveOperations3(){
		
		try {
			recString("hello");
		} catch (Error err) {
			System.out.println("handled");
			for (StackTraceElement ste:	err.getStackTrace())
				System.out.println(ste);
			
		}
	}
	
	
	private static String recString(String str){
		
		//base case never met
		if (str.length() == 0)
			return str;
		//recursive case
		else
			return recString(str);
			
		
	}
	
	
	//case 2: burry it -- not a good option
	//since, Errors are unchecked, contractually, you don't have to handle anything
	private static void findPrinterBurryError(){
	
		try {
			throw new IOError( new Throwable("couldn't find the printer; please make sure it's connected and on."));
		} catch (IOError err) {
			//do nothing
		}
	}//end meth
	
	
	
	//case 3: handle it
	//since, Errors are unchecked, contractually, you don't have to handle anything
	private static void findPrinterHandleError(){
	
		try {
			throw new IOError( new Throwable("couldn't find the printer; please make sure it's connected and on."));
		} catch (IOError err) {
			JOptionPane.showMessageDialog(null, err.getMessage());
		}
	}//end meth
	
	
	
	


}
