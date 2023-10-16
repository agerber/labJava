package edu.uchicago.gerber.labjava.lec03._boxing_interface;

public interface Boxable {
	 String punch(Boxable other);
	 void ouch(int points);
	 String getAscii();
	 int getHealth();
}
