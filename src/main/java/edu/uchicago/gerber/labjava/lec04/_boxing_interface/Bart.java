package edu.uchicago.gerber.labjava.lec04._boxing_interface;



public class Bart extends Animal implements Boxable  {


	public Bart() {
		super("Bart");

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
