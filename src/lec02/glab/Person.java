package lec02.glab;

import java.util.ArrayList;

public class Person {
	
	
	//fields of this class
	private String strFirstName;
	private String strLastName;
	private byte yAge; //-128 to 127
	private boolean bVeteran;
	private String strSocialSecurityNum;
	private ArrayList<Person> perDependents;
	
	
	public Person(String firstName, String lastName, byte age, boolean veteran,
			String socialSecurityNum, ArrayList<Person> arlDependents) {
		super();
		this.strFirstName = firstName;
		this.strLastName = lastName;
		this.yAge = age;
		this.bVeteran = veteran;
		this.strSocialSecurityNum = socialSecurityNum;
		this.perDependents = arlDependents;
	}
	


	public Person(String firstName, String lastName, byte age) {
		super();
		this.strFirstName = firstName;
		this.strLastName = lastName;
		this.yAge = age;
	}




	public String getFirstName() {
		return this.strFirstName;
	}


	public void setFirstName(String firstName) {
		this.strFirstName = firstName;
	}


	public String getLastName() {
		return this.strLastName;
	}


	public void setLastName(String lastName) {
		this.strLastName = lastName;
	}


	public byte getAge() {
		return this.yAge;
	}


	public void setAge(byte age) {
		this.yAge = age;
	}


	public boolean isVeteran() {
		return this.bVeteran;
	}


	public void setVeteran(boolean veteran) {
		this.bVeteran = veteran;
	}


	public String getSocialSecurityNum() {
		return this.strSocialSecurityNum;
	}


	public void setSocialSecurityNum(String socialSecurityNum) {
		this.strSocialSecurityNum = socialSecurityNum;
	}


	public ArrayList<Person> getArlDependents() {
		return this.perDependents;
	}


	public void setArlDependents(ArrayList<Person> arlDependents) {
		this.perDependents = arlDependents;
	}
	
	
	@Override
	public String toString(){
		
		StringBuilder stb = new StringBuilder();
		stb.append(getFirstName() + " " +  getLastName() + " "
				+ "Age: " + getAge() + " Veteran status: " + isVeteran() +
				" SSN: " + getSocialSecurityNum());
		
		if(perDependents != null && perDependents.size() != 0){
			
			stb.append("\n\tDependents: \n");
			for (Person p: perDependents) {
				stb.append("\t\t\t" + p.getFirstName() + " " + p.getLastName() + " Age: " + p.getAge());
				stb.append('\n');
			}
		}
		

		return stb.toString();	

		
	}

	
	
	
}
