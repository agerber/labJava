package lec09.glab.simpledatastructs.tree;


public class SimpleTreeDriver {

	/**
	 * @param args
	 */
    public static void main(String[] args) {
		



    	SimpleTree comTeams = new SimpleTree();
    	comTeams.insert("Bears");
    	comTeams.insert("Vikings");
    	comTeams.insert("Browns");
    	comTeams.insert("Jets");
    	comTeams.insert("Cowboys");
    	comTeams.insert("Patriots");
    	comTeams.insert("Dolphins");
    	
    	//try to comment this out
    	//comTeams.insert("Browns");
    	
    	comTeams.printInOrder();
    	

    	
    	
    	
   	 
	}
}
