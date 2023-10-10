package edu.uchicago.gerber.labjava.lec09.simpledatastructs.stack;


public class SimpleStackDriver {

public static void main(String[] args) {
		
		SimpleStack<String> strTeams = new SimpleStack<String>();

        System.out.println("First-In-Last-Out");
		//addFirst and addLast are working
		System.out.println("push Colts");
		strTeams.push("Colts");
		System.out.println("push Bears");
		strTeams.push("Bears");
		System.out.println("push Vikings");
		strTeams.push("Vikings");
		System.out.println("push Patriots");
		strTeams.push("Patriots");

		System.out.println("####################");

		//iterate over it
		strTeams.printIterate();
		System.out.println("The size of this stack is " + strTeams.size());

		System.out.println("####################");
		int nSize = strTeams.size();
		for (int nC = 0; nC < nSize; nC++) {
			System.out.println("pop " + strTeams.pop());
		}
		
		System.out.println("The size of this stack is " + strTeams.size());
		System.out.println("####################");
		
		

		
		

	}
	

}
