package lec09.glab.simpledatastructs.hashmap;

public class SimpleHashMapDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//try small numbers like 2, or 11
		SimpleHashMap<Integer,String> strCities = new SimpleHashMap<Integer,String>(7);
		
		//will not allow dups
		strCities.add(60001,"Chicago");
		strCities.add(60001,"Evanston");
		strCities.add(20001,"New York");
		strCities.add(90001,"Los Angeles");
		strCities.add(99998,"Shanghai");
		strCities.add(99999,"Moscow");
		strCities.add(99999,"Moscow");
		
		
		
		strCities.printIterate();
		System.out.println();
		System.out.println(strCities.contains(99998));
	
		
		
		

	}

}
