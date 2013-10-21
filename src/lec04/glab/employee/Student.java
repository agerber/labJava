package lec04.glab.employee;



//student is slighlty more complex and it's concrete
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
