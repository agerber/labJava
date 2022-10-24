package edu.uchicago.gerber.labjava.lec04.glab.varargs;



public class VarArgsDriver {


	public static void main(String[] args) {


		int[] ints = { 8,2,5,7, 6, 8, 101, -9};
		//int[] myints = new int[10];

		sum("The sum of var-args",8,2,5,7, 6, 8, 101, -9, 6,788, 344, 6777, 42423, 243);
		sum("The sum raw array", ints);
		//sumArray("The sum of",ints);

	}


//	private static void sumArray(String strSum, int[] ints){
//
//		sum(strSum, ints[0], ints[1], ints[2]);
//
//	}
	
	//varargs, introduced in Java5
    //notice how the varargs argument is last!
    //once inside the method, the param Type... is treated as Type[]
    //so, int... becomes int[]
	private static void sum(String strSum, int... nParams){
		int nResult = 0;
		System.out.print(strSum + " ");

		//notice that the int... is converted to int[] inside the method
		for (int nC = 0; nC < nParams.length; nC++) {
            //just output to the command-line
			if (nC == nParams.length - 1){
				System.out.print("and " + nParams[nC]);
            }
			else {
			     System.out.print(nParams[nC] + ", ");
            }

            //do the summing
			nResult += nParams[nC]; 
		}
		
		System.out.println(" is: " + nResult);
		
	}

}
