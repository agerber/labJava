package edu.uchicago.gerber.labjava.lec04.employee;

public abstract class Person {

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
	
	
	
}




