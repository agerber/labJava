package edu.uchicago.gerber.labjava.lec03.glab.boxing;

import edu.uchicago.gerber.labjava.lec03.glab.race.Raceable;


public class Kangaroo extends Animal implements Boxable {


	public static final String ascii =
			        "     .\n" +
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


	//constructor for racing
	public Kangaroo(String name) {
		super(name);

	}


	@Override
	public void punch(Boxable other) {

	}



}
