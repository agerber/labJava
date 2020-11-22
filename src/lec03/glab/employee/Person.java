package lec03.glab.employee;

public abstract class Person extends Object  {

    //cntrl-H to see object hierachy
    //ctrl-alt-shift-u to see class UML diagram
	
	private String mName;

	public Person(String name) {
		super();
		mName = name;
	}


	public abstract String getDescription();
	
	
	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}


	 String healthPlan(){
		StringBuilder stringBuilder = new StringBuilder();

		if (this instanceof Executive){
			stringBuilder.append("Executive Plantinum Plus");
		} else if (this instanceof Student){
			stringBuilder.append("Ha ha. Out of pocket.");
		} else {
			stringBuilder.append("Bronze HMO");
		}
		return stringBuilder.toString();
	}



}




