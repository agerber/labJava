package edu.uchicago.gerber.labjava.lec09.glab.simpledatastructs.tree;


public class SimpleTreeDriver {

	/**
	 * @param args
	 */
    public static void main(String[] args) {
		


        Integer integer;

    	SimpleTree<String> nflTeams = new SimpleTree<>();

        //more-balanced
        //tier1
        nflTeams.insert("Dolphins");
        //tier2
        nflTeams.insert("Cowboys");
        nflTeams.insert("Patriots");
        //tier3
        nflTeams.insert("Bears");
        nflTeams.insert("Vikings");
        nflTeams.insert("Devils"); //NHL team, but makes a balanced tree anyway
        nflTeams.insert("Jets");

        System.out.println("###################");

        nflTeams.printInOrder();
    	

    	
    	
    	
   	 
	}
}
