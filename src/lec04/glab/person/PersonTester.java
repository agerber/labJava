package lec04.glab.person;

import lec03.glab.person.*;

import java.util.ArrayList;

public class PersonTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//create a new ArrayList of Persons
		ArrayList<lec03.glab.person.Person> perVets = new ArrayList<lec03.glab.person.Person>();
		
		ArrayList<lec03.glab.person.Person> perChilds = new ArrayList<lec03.glab.person.Person>();
		
		
		
		perChilds.add(new lec03.glab.person.Person("Johny", "Ryan", (byte)2));
		perChilds.add(new lec03.glab.person.Person("Katyln", "Ryan", (byte)5));
		
		perVets.add(new lec03.glab.person.Person("Joe", "Ryan", (byte)28, true, "323-89-2871", perChilds));
		
		//assing perChilds to a new ArrayList altogether
		perChilds = new ArrayList<lec03.glab.person.Person>();
		
		perChilds.add(new lec03.glab.person.Person("Jack", "Schmidt", (byte)1));
		perChilds.add(new lec03.glab.person.Person("Cindy", "Schmidt", (byte)4));
		perChilds.add(new lec03.glab.person.Person("Nancy", "Schmidt", (byte)8));
		
		perVets.add(new lec03.glab.person.Person("Bud", "Schmidt", (byte)31, true, "323-12-1199", perChilds));
		
		perChilds = new ArrayList<lec03.glab.person.Person>();
		
		perVets.add(new lec03.glab.person.Person("Gregg", "Cadet", (byte)18, true, "898-17-1590", perChilds));
		
		
		
		
		for (lec03.glab.person.Person per : perVets) {
			System.out.println(per.toString());
			System.out.println();
		}
		
		
		
		System.out.println("--------------------------------");
		
		lec03.glab.person.Person perSenior = getMostSenior(perVets);
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
	public static lec03.glab.person.Person getMostSenior(ArrayList<lec03.glab.person.Person> perSoldiers){
		
		
		if (perSoldiers == null)
			return null;
		
		
		if(perSoldiers.size() == 1)
			return perSoldiers.get(0);
		
		//assume the first person has the most seniority
		lec03.glab.person.Person perSenior = perSoldiers.get(0);
		for (int nC = 1; nC < perSoldiers.size(); nC++) {
			
			if(perSoldiers.get(nC).getAge() > perSenior.getAge())
				perSenior = perSoldiers.get(nC);
			
		}
		
		return perSenior;
		
	}

}
