package edu.uchicago.gerber.labjava.lec04.glab.veterans;

import java.util.ArrayList;

public class Person {
	
	
	//fields of this class
	private String mFirstName;
	private String mLastName;
	private byte mAge; //-128 to 127
	private boolean mVeteran;
	private String mSocialNum;
	private ArrayList<Person> mDependants;
	
	
	public Person(String firstName, String lastName, byte age, boolean veteran,
			String socialSecurityNum, ArrayList<Person> perDependents) {
		super();
		this.mFirstName = firstName;
		this.mLastName = lastName;
		this.mAge = age;
		this.mVeteran = veteran;
		this.mSocialNum = socialSecurityNum;
		this.mDependants = perDependents;
	}
	


	public Person(String firstName, String lastName, byte age) {
		super();
		this.mFirstName = firstName;
		this.mLastName = lastName;
		this.mAge = age;
	}




	public String getFirstName() {
		return this.mFirstName;
	}


	public void setFirstName(String firstName) {
		this.mFirstName = firstName;
	}


	public String getLastName() {
		return this.mLastName;
	}


	public void setLastName(String lastName) {
		this.mLastName = lastName;
	}


	public byte getAge() {
		return this.mAge;
	}


	public void setAge(byte age) {
		this.mAge = age;
	}


	public boolean isVeteran() {
		return this.mVeteran;
	}


	public void setVeteran(boolean veteran) {
		this.mVeteran = veteran;
	}


	public String getSocialSecurityNum() {
		return this.mSocialNum;
	}


	public void setSocialSecurityNum(String socialSecurityNum) {
		this.mSocialNum = socialSecurityNum;
	}


	public ArrayList<Person> getArlDependents() {
		return this.mDependants;
	}


	public void setArlDependents(ArrayList<Person> arlDependents) {
		this.mDependants = arlDependents;
	}
	
	
	@Override
	public String toString(){
		
		StringBuilder stb = new StringBuilder();
		stb.append(getFirstName() + " " +  getLastName() + " "
				+ "Age: " + getAge() + " Veteran status: " + isVeteran() +
				" SSN: " + getSocialSecurityNum());
		
		if(mDependants != null && mDependants.size() != 0){
			
			stb.append("\n\tDependents: \n");
			for (Person p: mDependants) {
				stb.append("\t\t\t" + p.getFirstName() + " " + p.getLastName() + " Age: " + p.getAge());
				stb.append('\n');
			}
		}
		

		return stb.toString();	

		
	}

	
	
	
}
