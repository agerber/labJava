package lec09.glab.simpledatastructs.hashmap;

import java.util.HashMap;
import java.util.Map;

public class SimpleHashMapDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//try small numbers like 2, or 11
		SimpleHashMap<Integer,String> strCities = new SimpleHashMap<Integer,String>(15);
		Map<Integer, String> map= new HashMap<>();


		System.out.println("hashcode() for 60001: " + new Integer(60001).hashCode());
		System.out.println("hashcode() for 60001: " + new Integer(60001).hashCode());


		//will not allow dups
		strCities.put(60001, "Chicago");
		strCities.put(60001, "Evanston");
		strCities.put(20001, "New York");
		strCities.put(90001, "Los Angeles");
		strCities.put(99998, "Shanghai");
		strCities.put(99999, "Moscow");
		strCities.put(99999, "Moscow");

		//will not allow dups
		map.put(60001, "Chicago");
		map.put(60001, "Evanston");
		map.put(20001, "New York");
		map.put(90001, "Los Angeles");
		map.put(99998, "Shanghai");
		map.put(99999, "Moscow");
		map.put(99999,"Moscow");
		
		
		
		strCities.printIterate();
		System.out.println();
		System.out.println(strCities.contains(99998));

		System.out.println("#####################################");

		//iter (using templates)
		for (Integer integer : map.keySet()) {
			System.out.println("Key: " + integer + " : Value: " + map.get(integer));
		}

		System.out.println(map.containsKey(99998));
		
		
		

	}

}
