package edu.uchicago.gerber.labjava.lec03.employee;

public class Student extends Person {

	
	private String mMajor;
	
	
	public Student(String name, String major) {
		super(name);
		mMajor = major;
	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "a Student majoring in " + mMajor;
	}

}
