package edu.uchicago.gerber.labjava.lec09.glab.simpledatastructs.hashtable;

public class SimpleHashTableDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//try small numbers like 2, or 11, 50 and 51
		SimpleHashTable<String> strCities = new SimpleHashTable<String>(133);
		
		//will allow duplicates -- watch-out
		strCities.add("Chicago");
		strCities.add("New York");
		strCities.add("Los Angeles");
		strCities.add("Shanghai");
		strCities.add("Moscow");
		
		
		strCities.printIterate();
		System.out.println();
		System.out.println(strCities.contains("Los Angeles"));

		System.out.println(strCities.contains("Mumbai"));
	
		
		
		

	}

}
