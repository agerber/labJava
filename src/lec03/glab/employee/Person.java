package lec03.glab.employee;

public abstract class Person {

    //cntrl-H to see object hierachy
    //ctrl-alt-shift-u to see class UML diagram
	
	private String strName;

	public Person(String name) {
		super();
		strName = name;
	}

	public abstract String getDescription();
	
	
	public String getName() {
		return strName;
	}

	public void setName(String name) {
		strName = name;
	}
	
	
	
}




