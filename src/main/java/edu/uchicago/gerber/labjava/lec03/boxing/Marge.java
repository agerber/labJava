package edu.uchicago.gerber.labjava.lec03.boxing;



public class Marge extends Animal implements Boxable  {


	public Marge() {
		super("Marge");
	}


	@Override
	public String getAscii() {
		return  "  OOOO\n" +
				" OOOOOOOOO\n" +
				"OOOOOOOOOOOO\n" +
				"OOOOOOOOOOOOO\n" +
				"OOOOOOOOOOOOOO\n" +
				"OOOOOOOOOOOOOO\n" +
				" OOOOOOOOOOOOOO\n" +
				" OOOOOOOOOOOOOO\n" +
				" OOOOOOOOOOOOOO\n" +
				"  OOOOOOOOOOOOOO\n" +
				"  OOOOOOOOOOOOOO\n" +
				"  OOOOOOOOOOOOOO\n" +
				"  OOOOOOOOOOOOOO\n" +
				"   OOOOOOOOOOOOOO\n" +
				"   OOOOOOOOOOOOOO\n" +
				"   OOOOO \\_| \\_|O\n" +
				"   OOOO \\/  \\/  \\\n" +
				"   OOOO (o   )o  )\n" +
				"   O/c   \\__/ --.\n" +
				"   O\\_   ,     -'\n" +
				"    O|  '\\_______)\n" +
				"     |       _)\n" +
				"     |      |\n" +
				"     oooooooo\n" +
				"    /        \\";
	}
}
