package edu.uchicago.gerber.labjava.lec03.statics;

import java.util.Scanner;

public class MetricConverter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner scnIn = new Scanner(System.in);
		
		System.out.println("How much do you weigh in lbs?");
		double dPounds = Double.parseDouble(scnIn.nextLine());
		
		System.out.println("Haaa! You mean you weigh: " + Metric.getKilograms(dPounds) + " Kilograms.");
		
		

	}

}
