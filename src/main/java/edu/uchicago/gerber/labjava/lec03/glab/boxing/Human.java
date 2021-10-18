package edu.uchicago.gerber.labjava.lec03.glab.boxing;

import edu.uchicago.gerber.labjava.lec03.glab.race.Raceable;


public class Human extends Animal implements Boxable  {




	//constructor
	public Human(String name) {
		super(name);

	}


	@Override
	public String getAscii() {
		return  "          /\\/\\/\\/\\\n" +
				"         /       /\n" +
				"        (. (.  )\n" +
				"         (      ]\n" +
				"        /____  /\n" +
				"         \\     |\n" +
				"         /-----\\\n" +
				"       / /     /  \\\n" +
				"     / \\/       \\/  \\\n" +
				"   / / /           \\  \\\n" +
				" ((()  /__________\\ (/\\)))\n" +
				"        /         \\\n" +
				"        |    /\\    \\\n" +
				"        ----| |----\n" +
				"        |__ |  \\__ \\\n" +
				"       {____|   {___}\n" +
				"=======================/\n" +
				"   (o)           (o)";
	}
}
