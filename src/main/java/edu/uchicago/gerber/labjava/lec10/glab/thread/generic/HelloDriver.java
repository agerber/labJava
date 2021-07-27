package edu.uchicago.gerber.labjava.lec10.glab.thread.generic;

public class HelloDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		SayHello sayHello = new SayHello("Hello World");
		SayHello sayBye= new SayHello("Goodbye World");
		
//		sayHello.run();
//		sayBye.run();
		
	
		
		Thread thr1 = new Thread(sayHello);
		Thread thr2 = new Thread(sayBye);
		
		thr1.start();
		thr2.start();
		
		
		

	}

}
