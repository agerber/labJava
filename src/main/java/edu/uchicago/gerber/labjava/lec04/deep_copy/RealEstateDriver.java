package edu.uchicago.gerber.labjava.lec04.deep_copy;


import java.util.ArrayList;

public class RealEstateDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		ArrayList<House> houParks = new ArrayList<House>();
		
		houParks.add(new House("5519 Dorchester Ave.",
                151_123.13,
                false));
		
		houParks.add(new House("5914 Ellis Ave.",
                800_150.35,
                true));

		houParks.add(new House("1513 53rd Street",
                520_300.85,
                false));
		

        //subprime-crash!
		for (House hou : houParks) {
			hou.setMarketValue(hou.getMarketValue() * 0.75);
			
		}
		
		
		
		for (House hou : houParks) {
			System.out.println(hou);
			
		}
		

		House houMostExpensive;
		House houTest;
		
	    houMostExpensive = houParks.get(0);
		
		for (int nC = 1; nC < houParks.size(); nC++) {
			houTest = houParks.get(nC);
			if(houTest.getMarketValue() > houMostExpensive.getMarketValue()) {
				houMostExpensive = houTest;
            }
		}
			
		System.out.println();
		System.out.println("The most expensive house in Hyde Park: ");
        System.out.println(houMostExpensive);





    }

}
