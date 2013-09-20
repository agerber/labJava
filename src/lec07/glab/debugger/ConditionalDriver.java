package lec07.glab.debugger;

public class ConditionalDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] strTeams = {"Bears", "Browns", "Vikings", "Colts", "Jets"};
		
		printTeams(strTeams);

	}
	
	
	private static void printTeams(String[] strParams){
		
		//conditional breakpoints

		for (int nC = 0; nC < strParams.length; nC++) {
			System.out.println(strParams[nC]);
		}
		

		System.out.println("goodbye");
		
		
	}
	
	

}
