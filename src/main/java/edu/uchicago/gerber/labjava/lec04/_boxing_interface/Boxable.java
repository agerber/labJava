package edu.uchicago.gerber.labjava.lec04._boxing_interface;

public interface Boxable {

	//by default all members of interfaces are public, static and final by default
	 String HELLO = "The Boxable Interface";

	//by default, all contract methods are public and abstract by default
	 String punch(Boxable other);
	 void ouch(int points);
	 String getAscii();
	 int getHealth();
}
