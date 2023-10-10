package edu.uchicago.gerber.labjava.lec10.thread.generic;

public class HelloDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SayHello one = new SayHello("1");
		SayHello two = new SayHello("2");
		SayHello three = new SayHello("3");
		SayHello four = new SayHello("4");
		SayHello five= new SayHello("5");
		SayHello six= new SayHello("6");
		SayHello seven = new SayHello("7");
		SayHello eight = new SayHello("8");
		SayHello nine = new SayHello("9");
		SayHello line = new SayHello("#####################");




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
