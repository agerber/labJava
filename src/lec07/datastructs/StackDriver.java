package lec07.datastructs;

public class StackDriver {

	 public static void main(String[] args) {
			
		 Stack<String> strTeams  = new Stack<String>();
		 strTeams.push("Vikings");
		 strTeams.push("Browns");
		 strTeams.push("Jets");
		 strTeams.push("Cowboys");
		 strTeams.push("Patriots");
		 strTeams.push("Dolphins");
		 strTeams.push("Bears");
		 
		 

		 
		 while(!strTeams.isEmpty())
			 System.out.println(strTeams.pop());
			 

		 
	}
		

}
