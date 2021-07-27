package edu.uchicago.gerber.labjava.lec04.glab.cmd;

public class CommandLine {


	//commnand line to print a sentence backwards however many times
	//sample input> 5 this is my sentence
	
	//Run || Edit Configurations...
	//put args in program arguments || Run
	//10 Hello there my name is Adam

	public static void main(String[] args) {
		//the first arg is assumed to be an integer
		try {
			int nNum = Integer.parseInt(args[0]);

            //print nB times
			for(int nB = 0; nB < nNum; nB++){
                //iterate backwards over the args to 1
				for (int nC =  args.length - 1; nC > 0; nC--) {
					System.out.print(args[nC] + " ");
				}
				System.out.println();
			}

		} catch (NumberFormatException nfe) {
			System.out.println("Error: " + nfe.getMessage());
			return;
		}

	}

}
