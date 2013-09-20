package lec03.employee;

public class Student extends Person {

	
	private String strMajor;
	
	
	public Student(String name, String major) {
		super(name);
		strMajor = major;
	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "a Student majoring in " + strMajor;
	}

}
