package lec03.glab.employee;

public abstract class Person {

	
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




