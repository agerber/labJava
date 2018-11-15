package lec01.glab;

import java.util.ArrayList;
import java.util.List;

public class TypeConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


	List<String> strNames = new ArrayList<>();
		strNames.add("Adam");
		strNames.add("Bob");
		strNames.add("Charlie");

		for (String strName : strNames) {

		}

		
	int nNumber =	Integer.parseInt("5");
	
	double dNumber = Double.parseDouble("8.18");
	
	
	byte yNumber = Byte.parseByte("127");
	
	
	boolean bFlag = Boolean.parseBoolean("TruE");
	
	
	System.out.println(nNumber);
	System.out.println(dNumber);
	System.out.println(yNumber);
	System.out.println(bFlag);
	
	

	}

}
