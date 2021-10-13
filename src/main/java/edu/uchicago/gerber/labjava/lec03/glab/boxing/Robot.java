package edu.uchicago.gerber.labjava.lec03.glab.boxing;

import edu.uchicago.gerber.labjava.lec03.glab.ascii.Asciify;
import edu.uchicago.gerber.labjava.lec03.glab.race.Raceable;

public class Robot implements Boxable {

	public static final String ascii =
			"        /             /|\n" +
			"       /             / |\n" +
			"      /____________ /  |\n" +
			"     | ___________ |   |\n" +
			"     ||           ||   |\n" +
			"     ||           ||   |\n" +
			"     ||           ||   |\n" +
			"     ||___________||   |\n" +
			"     |   _______   |  /\n" +
			"    /|  (_______)  | /\n" +
			"   ( |_____________|/\n" +
			"    \\\n" +
			".=======================.\n" +
			"| ::::::::::::::::  ::: |\n" +
			"| ::::::::::::::[]  ::: |\n" +
			"|   -----------     ::: |\n" +
			"`-----------------------'";

	@Override
	public void punch(Boxable other) {

	}
}
