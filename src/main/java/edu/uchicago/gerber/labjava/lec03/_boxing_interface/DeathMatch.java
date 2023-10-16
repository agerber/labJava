package edu.uchicago.gerber.labjava.lec03._boxing_interface;


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

		for (Boxable boxable : boxables) {
			System.out.println(boxable.getAscii());

		}

//		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//
//		Boxable boxPuncher = new Homer();
//		Boxable boxPunchee = new Robot("Mac2e");
//		Boxable boxSwap; //null
//
//
//
//		while(boxPunchee.getHealth() > 0){
//
//			//swap
//			boxSwap = boxPunchee;
//			boxPunchee = boxPuncher;
//			boxPuncher = boxSwap;
//
//			//punch
//			System.out.println(boxPuncher.punch(boxPunchee));
//			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//		}
//
//		System.out.println(boxPuncher + ":wins with " + boxPuncher.getHealth() + "   " + boxPunchee +": is dead with " +  +
//			boxPunchee.getHealth());
//
//

	}

}
