package lec09.glab.simpledatastructs.tree;


public class SimpleTreeDriver {

	/**
	 * @param args
	 */
    public static void main(String[] args) {
		

    	SimpleTree comTeams = new SimpleTree();
        //imbalanced
//    	comTeams.insert("Bears");
//    	comTeams.insert("Vikings");
//    	comTeams.insert("Browns");
//    	comTeams.insert("Jets");
//    	comTeams.insert("Cowboys");
//    	comTeams.insert("Patriots");
//    	comTeams.insert("Dolphins");

        //more-balanced
        //tier1
        comTeams.insert("Dolphins");
        //tier2
        comTeams.insert("Cowboys");
        comTeams.insert("Patriots");
        //tier3
        comTeams.insert("Bears");
        comTeams.insert("Vikings");
        comTeams.insert("Devils"); //ok not an NFL team, but makes a balanced tree anyway
        comTeams.insert("Jets");





    	
    	comTeams.printInOrder();
    	

    	
    	
    	
   	 
	}
}
