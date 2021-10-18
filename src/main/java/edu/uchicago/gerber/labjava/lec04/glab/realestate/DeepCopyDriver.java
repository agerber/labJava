package edu.uchicago.gerber.labjava.lec04.glab.realestate;

import java.util.*;


public class DeepCopyDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//
//		List<Double> dubs = new ArrayList<>();
//		dubs.add(212.13);
//		dubs.add(212.12);
//
//		dubs.add(212.14);
//
//		//Object[] array =  dubs.toArray();
//
//		//Arrays.sort(array);
//
//		Collections.sort(dubs, new Comparator<Double>() {
//			@Override
//			public int compare(Double o1, Double o2) {
//				if (o1.doubleValue() > o2.doubleValue()) return 1;
//				if (o1.doubleValue() < o2.doubleValue()) return -1;
//				return 0;
//			}
//		});
//
//		for (Double dub : dubs) {
//
//			System.out.println(dub);
//		}
//
//
//
//		House houOrig = new House(
//				"5519 Dorchester Ave.",
//				601_526.50,
//			    false);
//
//		House houAssigned = houOrig;
//		System.out.println("houOrig and houAssigned point the same instantiated object in memory space? " + (houOrig == houAssigned));
//        System.out.println("houOrig: " + houOrig );
//        System.out.println("houAssigned: " + houAssigned );
//
//
//        System.out.println("setting market value of houAssigned to 21.00");
//        houAssigned.setMarketValue(21.00);
//        System.out.println("houOrig: " + houOrig );
//        System.out.println("houAssigned: " + houAssigned );
//
//		System.out.println("##############################");
//

		House houOrig = new House(
				"5519 Dorchester Ave.",
				601_526.50,
			    false);

		House houCloned = null;
		try {
			houCloned = houOrig.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("dates point to same object " + (houCloned.getTimestamp() == houOrig.getTimestamp()));
		houCloned.setAddress("123 Kenwood Drive");
		houCloned.setDatInstantiated(new Date());
		System.out.println("address point to same object " +  (houCloned.getAddress() == houOrig.getAddress()));

		System.out.println(houOrig.getTimestamp().equals(houCloned.getTimestamp()));

//		System.out.println("houOrig and houCloned point the same instantiated object in memory space? " + (houOrig == houCloned));
//
//        System.out.println("setting market value of houCloned to 57.00");
//
//		houCloned.setMarketValue(57.00);
//
//        System.out.println("houOrig: " + houOrig );
//        System.out.println("houCloned: " + houCloned );
//
//
//		//deep copy or not; depends if House deep copies the mutable fields of House or not.
//		System.out.println("houOrig.getDatInstantiated() and houCloned.getDatInstantiated() point the same instantiated object in memory space? " + (houOrig.getDatInstantiated() == houCloned.getDatInstantiated()));
//
//        System.out.println("setting date of houCloned to Dec 31 1969");
//
//        houCloned.getDatInstantiated().setTime(1L);
//
//        System.out.println("houOrig: " + houOrig );
//        System.out.println("houCloned: " + houCloned );


	}

}
