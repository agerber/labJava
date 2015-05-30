package lec09.glab.simpledatastructs.hashtable;

import java.util.Date;

public class SimpleHashTableDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//try small numbers like 2, or 11
		SimpleHashTable<String> strCities = new SimpleHashTable<String>(11);



		System.out.println("hashcode() for Chicago: " + "Chicago".hashCode());
		System.out.println("hashcode() for Chicago: " + "Chicago".hashCode());


		System.out.println("hashcode() for Date(12,15,2010): " + new Date(12,15,2010).hashCode());
		System.out.println("hashcode() for Date(12,15,2010): " + new Date(12,15,2010).hashCode());

		//hashcode() method of Date
//		public int hashCode() {
//			long ht = this.getTime();
//			return (int) ht ^ (int) (ht >> 32);
//		}


		//will allow duplicates -- watch-out
		strCities.add("Chicago");
		strCities.add("New York");
		strCities.add("Los Angeles");
		strCities.add("Shanghai");
		strCities.add("Moscow");
		
		
		strCities.printIterate();
		System.out.println();
		System.out.println(strCities.contains("Shanghai"));
	
		
		
		

	}

}
