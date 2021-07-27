package edu.uchicago.gerber.labjava.lec09.glab.simpledatastructs.queue;


public class SimpleQueueDriver {

public static void main(String[] args) {

       System.out.println("First-In-First-Out");  //this is "fair"
		
		SimpleQueue<String> strTeams = new SimpleQueue<String>();
	
		//addFirst and addLast are working
		System.out.println("enqueue Colts");
		strTeams.enqueue("Colts");
		System.out.println("enqueue Bears");
		strTeams.enqueue("Bears");
		System.out.println("enqueue Vikings");
		strTeams.enqueue("Vikings");
		System.out.println("enqueue Patriots");
		strTeams.enqueue("Patriots");

		System.out.println("####################");

		//iterate over it
		strTeams.printIterate();
		
		
		System.out.println("The size of this queue is " + strTeams.size());
		System.out.println("####################");
		int nSize = strTeams.size();
		for (int nC = 0; nC < nSize; nC++) {
			System.out.println("dequeue " + strTeams.dequeue());
            System.out.println("$$$$$$$$$$$$$result$$$$$$$$$$$$$$$");
            strTeams.printIterate();
            System.out.println("$$$$$$$$$$$$$result$$$$$$$$$$$$$$$");
		}
		
		System.out.println("The size of this queue is " + strTeams.size());
		System.out.println("####################");
		
		

		
		

	}
	

}
