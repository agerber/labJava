package lec08.glab.datastructs;


public class TreeDriver {

	/**
	 * @param args
	 */
    public static void main(String[] args) {
		

    	MyTree comTeams = new MyTree();
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
