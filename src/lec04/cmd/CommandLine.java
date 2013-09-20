package lec04.cmd;

public class CommandLine {


	//commnand line to print a sentence backwards however many times
	//sample input> 5 this is my sentence
	
	//Run || Run Configurations... || Browse the project || Search the Class || 
	//put args[] in program arguments || Run
	

	public static void main(String[] args) {

		
		//the first arg is assumed to be an integer
		try {
			int nTimes = Integer.parseInt(args[0]);
			
			
			for(int nB = 0; nB < nTimes; nB++){
				
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
