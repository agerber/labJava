package edu.uchicago.gerber.labjava.lec10.thread.generic;

public class PrimeDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		PrimeNumber one = new PrimeNumber("1");
		PrimeNumber two = new PrimeNumber("2");
		PrimeNumber three = new PrimeNumber("3");
		PrimeNumber four = new PrimeNumber("4");
		PrimeNumber five= new PrimeNumber("5");
		PrimeNumber six= new PrimeNumber("6");
		PrimeNumber seven = new PrimeNumber("7");
		PrimeNumber eight = new PrimeNumber("8");
		PrimeNumber nine = new PrimeNumber("9");
		PrimeNumber line = new PrimeNumber("#####################");

			new Thread(one).start();
			new Thread(two).start();
			new Thread(three).start();
			new Thread(four).start();
			new Thread(five).start();
			new Thread(six).start();
			new Thread(seven).start();
			new Thread(eight).start();
			new Thread(nine).start();
			new Thread(line).start();






		
		

	}

}
