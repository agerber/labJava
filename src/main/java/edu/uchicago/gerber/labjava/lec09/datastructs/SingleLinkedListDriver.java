package edu.uchicago.gerber.labjava.lec09.datastructs;

import java.util.Iterator;

public class SingleLinkedListDriver {

	/**
	 * @param args
	 */
public static void main(String[] args) {
		
		MySingleLinkedList<String> strTeams = new MySingleLinkedList<String>();
	
		
		strTeams.add("Vikings");
		strTeams.add("Browns");
		strTeams.add("Jets");
		strTeams.add("Cowboys");
		strTeams.add("Patriots");
		strTeams.add("Dolphins");
		strTeams.add("Bears", 3);

	
		Iterator<String> itr =  strTeams.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
			
		}
		

		
		
		

	}
	

}
