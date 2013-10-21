package lec04.glab.employee;



//student is slighlty more complex and it's concrete
public class Student extends Person {

	
	private String mMajor;


    //the no-arg constructor (provided for you, which sets members to default values)
    //    public Student(){
    //        super(null);
    //        mMajor = null;
    //    }

    //constucrtor is OVERLOADED to take zero, one, and two params
    public Student(String name){
        super(name);
        mMajor = "CompSci";
    }

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
