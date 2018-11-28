package lec09.glab.simpledatastructs.tree;


import java.util.Date;

public class SimpleTreeDriver {

	/**
	 * @param args
	 */
    public static void main(String[] args) {
		

       int nHash1 =  "Adam".hashCode();
       int nHash2 =   new Date("1/1/2018").hashCode();



        System.out.println("has1 is " + nHash1);
        System.out.println("hash2 is " + nHash2);

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
