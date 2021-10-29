package edu.uchicago.gerber.labjava.lec03.glab.boxing;


public class DeathMatch {

	public static void main(String[] args) {

		//heterogeneous data structure, Robot does not share hierarchy with
		//Human and Kangaroo
		Boxable[] boxables = {
				new Bart(),
				new Lucy(),
				new Marge(),
				new Homer(),
				new Kangaroo(),
				new Robot("Mac2e")};

		Boxable boxPuncher = boxables[(int) (Math.random() * boxables.length)];
		Boxable boxPunchee;
		Boxable boxSwap; //null




		//assign punchee
		while (true){
			 boxPunchee = boxables[(int) (Math.random() * boxables.length)];
			 if (boxPunchee != boxPuncher) break;
		}

		while(boxPunchee.getHealth() > 0){

			//swap
			boxSwap = boxPunchee;
			boxPunchee = boxPuncher;
			boxPuncher = boxSwap;

			//punch
			System.out.println(boxPuncher.punch(boxPunchee));
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		}

		System.out.println(boxPuncher + ":wins with " + boxPuncher.getHealth() + "   " + boxPunchee +": is dead with " +  +
			boxPunchee.getHealth());

		

	}

}
