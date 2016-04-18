package lec04.glab.employee;



//student is slighlty more complex and it's concrete
public class Student extends Person {

	
	//private String mMajor;
	private String mSchool;


    //the no-arg constructor (provided for you, which sets members to default values)
    //    public Student(){
    //        super(null);
    //        mMajor = null;
    //    }

    //constucrtor is OVERLOADED to take zero, one, and two params
    public Student(String name){
        super(name);
        mSchool = "CompSci";

    }

    public Student(String name, String school) {
		super(name);
		mSchool = school;
	}

	public String getSchool() {
		return mSchool;
	}

	public void setSchool(String school) {
		mSchool = school;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "a Student from " + mSchool;
	}

}
