package edu.uchicago.gerber.labjava.lec03.employee;


import java.util.Date;
import java.util.GregorianCalendar;


public class Employee extends Person {

	
	private double mSalary;
	private Date mHireDate;
	
	
	
	
	
	public Employee(String strName, double dSalary, int nYear, int nMonth, int nDay) {
		super(strName);
		this.mSalary = dSalary;
		GregorianCalendar greHire = new GregorianCalendar(nYear, nMonth -1, nDay);
		this.mHireDate = greHire.getTime();
		
	}
	
	
	





	public double getSalary() {
		return mSalary;
	}








	public void setSalary(double salary) {
		mSalary = salary;
	}








	public Date getHireDate() {
		return mHireDate;
	}








	public void setHireDate(Date hireDate) {
		this.mHireDate = hireDate;
	}





	public void raiseSalary(double dPercent){
		double dRaise = mSalary * dPercent / 100;
		mSalary += dRaise;
	}



	@Override
	public String getDescription() {
		return "Employee{" +
				"mSalary=" + mSalary +
				", mHireDate=" + mHireDate +
				'}';
	}




}
