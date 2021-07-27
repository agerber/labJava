package edu.uchicago.gerber.labjava.lec02.glab;

import java.util.ArrayList;

public class PersonTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//create a new ArrayList of Persons
		ArrayList<Person> perVets = new ArrayList<Person>();
		
		ArrayList<Person> perChilds = new ArrayList<Person>();
		
		
		
//		perChilds.add(new Person("Johny", "Ryan", (byte)2));
//		perChilds.add(new Person("Katyln", "Ryan", (byte)5));
//
		perVets.add(new Person("Joe", "Ryan", (byte)28, true, "323-89-2871", null));
		
		//assing perChilds to a new ArrayList altogether
//		perChilds = new ArrayList<Person>();
//
//		perChilds.add(new Person("Jack", "Schmidt", (byte)1));
//		perChilds.add(new Person("Cindy", "Schmidt", (byte)4));
//		perChilds.add(new Person("Nancy", "Schmidt", (byte)8));
//
		perVets.add(new Person("Bud", "Schmidt", (byte)31, true, "323-12-1199", null));
		
	//	perChilds = new ArrayList<Person>();
		
		perVets.add(new Person("Gregg", "Cadet", (byte)18, true, "898-17-1590", null));
		
		
		
		
		for (Person per : perVets) {
			System.out.println(per.toString());
			System.out.println();
		}
		
		
		
		System.out.println("--------------------------------");
		
		Person perSenior = getMostSenior(perVets);
		System.out.println("The most senior vet is: " + perSenior);
		
		
				

	}//end main
	
	/**
	 * 
	 * @param perSoldiers ArrayList<String>
	 * @return Person object
	 * 

	 * <pre>
	 * Example:
	 *    perSenior = getMostSenior(perVets); //will return a reference to Person
	 * </pre>
	 */
	public static Person getMostSenior(ArrayList<Person> perSoldiers){
		
		
		if (perSoldiers == null)
			return null;
		
		
		if(perSoldiers.size() == 1)
			return perSoldiers.get(0);
		
		//assume the first person has the most seniority
		Person perSenior = perSoldiers.get(0);
		for (int nC = 1; nC < perSoldiers.size(); nC++) {
			
			if(perSoldiers.get(nC).getAge() > perSenior.getAge())
				perSenior = perSoldiers.get(nC);
			
		}
		
		return perSenior;
		
	}

}
