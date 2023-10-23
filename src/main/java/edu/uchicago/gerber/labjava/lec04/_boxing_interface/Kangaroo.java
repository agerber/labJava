package edu.uchicago.gerber.labjava.lec04._boxing_interface;



public class Kangaroo extends Animal implements Boxable {



	public Kangaroo() {
		super("Roo");

	}

	@Override
	public String getAscii() {
		return 	        "     .\n" +
				"          /\\ /l\n" +
				"         ((.Y(!\n" +
				"          \\ |/\n" +
				"          /  6~6,\n" +
				"          \\ _    +-.\n" +
				"           \\`-=--^-'\n" +
				"            \\ \\\n" +
				"           _/  \\\n" +
				"          (  .  Y\n" +
				"         /\"\\ `--^--v--.\n" +
				"        / _ `--\"T~\\/~\\/\n" +
				"       / \" ~\\.  !\n" +
				" _    Y      Y./'\n" +
				"Y^|   |      |~~7\n" +
				"| l   |     / ./'\n" +
				"| `L  | Y .^/~T\n" +
				"|  l  ! | |/| |\n" +
				"| .`\\/' | Y | !   .\n" +
				"l  \"~   j l j_L______\n" +
				" \\,____{ __\"~ __ ,\\_,\\_";
	}





}
