package lec01;


import java.util.Scanner;

public class EnterSomething {


	public static void main(String[] args) {

		
		//declare a string to hold input
	    //while input != exit
			//ask for input and give instructions
			//print Echo + input
			
        Scanner in = new Scanner(System.in);
		String strInput;
		do
		{
             System.out.println("Enter something: (or exit to quit)");
             strInput = in.next();

             System.out.println("Echo:" + strInput );
		         
		} while(!strInput.equals("exit"));
		


	}


}

