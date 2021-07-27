package edu.uchicago.gerber.labjava.lec04.glab.hw1examples;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Reorder {

	/*6. Write a program that reorders an integer array arr in-place according
   to a vector of indices perm. For example,

   arr = {0,4, -1, 1000)
   perm= {3,0,1,2}

   after a call to reorder such as,
   reorder(arr,perm) 

   arr upon return has the values {1000, 0, 4, -1}

   That is, arr is reshuffled such that, after reorder is called,
   arr_new[i] = arr_old[perm[i]]. Note that arr should be overwritten
   in memory, so arr_new and arr_old are are the same storage.

   For simplicity, your program should be testable from the command line as:

>> java Reorder 0 4 -1 1000 & 3 0 1 2   

Note: You may _not_ allocate a separate memory buffer of size
arr. Imagine that memory is at a premium when you write your
algorithm. Also, your program must internally use arrays in the manner
specified above. You can not simply print the output to the screen on
the fly.

	 */
	
	//NOT A COMMAND LINE; SYSTEM.IN ONLY
	public static void main(String[] args) {

		//the input params should be odd  and the middle input must be ampersand
		//the outer params must all be numbers 

		String strInput;

		StringTokenizer sto;
		Scanner scnIn = new Scanner(System.in);

		//String[] strInputs;

		int[] nVals; // = new int[nSize];
		int[] nOrders;// = new int[nSize];

		do {
			System.out
					.println("Type an array and a reorder sequence; for example:  "
							+ "0 4 -1 1000 & 3 0 1 2  will result in {4, -1, 1000, 0 } "
							+ "(or type exit to quit):");

			strInput = scnIn.nextLine();

			if (strInput.toUpperCase().equals("EXIT"))
				break;

			sto = new StringTokenizer(strInput);

			//check to see that the number of args are odd
			if (sto.countTokens() % 2 == 0) {
				System.out
						.println("Bad input or even number of arguments, try again ");
				continue;
			}

			//do some integer division to determine the size of the array
			int nSize = sto.countTokens() / 2; //if 7 then 3, if 9 then 4, if 11 then 5 etc. 

			//init our arrays to the proper size
			nVals = new int[nSize];
			nOrders = new int[nSize];

			int nCount = 0;
			try {

				while (sto.hasMoreTokens()) {

					if (nCount == nSize)
						break;

					nVals[nCount] = Integer.parseInt(sto.nextToken());
					nCount++;
				}

				//skip the middle character
				sto.nextToken();
				nCount++;

				//keep going and load in the orders
				while (sto.hasMoreTokens()) {

					if (nCount == nSize * 2 + 1)
						break;

					nOrders[nCount - (nSize + 1)] = Integer.parseInt(sto
							.nextToken());

					nCount++;
				}

			} catch (NumberFormatException nfe) {
				System.out.println("Some of your parameters are not integers. "
						+ nfe.getMessage());
				continue;
			}

			int nSwapVal;
			for (int nB = 0; nB < nOrders.length; nB++) {
				//iterate over both arrays
				for (int nC = 0; nC < nOrders.length; nC++) {

					if (nOrders[nC] == nB) {
						//swap vals
						nSwapVal = nVals[nC]; //store the temp of nVals 
						nVals[nC] = nVals[nB];
						nVals[nB] = nSwapVal;

						//swap ords
						nSwapVal = nOrders[nC]; //store the temp of nOrds
						nOrders[nC] = nOrders[nB];
						nOrders[nB] = nSwapVal;
						
					    break;
					}

				}

			}

			System.out.println("Results: ");
			for (int nC = 0; nC < nVals.length; nC++) {
				System.out.print(nVals[nC] + " ");
			}
			System.out.println();

		} while (true); //infinite loop -- must meet break condition exit

		System.out.println("Thanks for playing.");

	}

}
