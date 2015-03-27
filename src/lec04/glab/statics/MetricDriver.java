package lec04.glab.statics;

import java.util.Scanner;

public class MetricDriver {

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
