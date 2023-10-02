package edu.uchicago.gerber.labjava.lec01.glab;

import java.util.ArrayList;

public class TypeConversion {

	public static void main(String[] args) {


		ArrayList<Integer> ages = new ArrayList<>();


		final int TWELVE = 12;

		ages.add(TWELVE);
		ages.add(19);
		ages.add(6);

		for (Integer age : ages) {
			System.out.println(age.intValue() + " : " + age.getClass().getName());
		}

		int nNumber =	Integer.parseInt("5");

		double dNumber = Double.parseDouble("8.18");


		byte yNumber = Byte.parseByte("127");



		boolean bFlag = Boolean.parseBoolean("TruE");


		System.out.println(nNumber);
		System.out.println(dNumber);
		System.out.println(yNumber);
		System.out.println(bFlag);
		System.out.println(ages);

	

	}

}
