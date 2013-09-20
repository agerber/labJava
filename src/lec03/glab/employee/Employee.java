package lec03.glab.employee;


import java.util.Date;
import java.util.GregorianCalendar;


public class Employee extends Person {

	
	private double dSalary;
	private Date datHireDay;
	
	
	
	
	
	public Employee(String name, double salary, int nYear, int nMonth, int nDay) {
		super(name);
		dSalary = salary;
		GregorianCalendar greHire = new GregorianCalendar(nYear, nMonth -1, nDay);
		this.datHireDay = greHire.getTime();
		
	}
	
	
	





	public double getSalary() {
		return dSalary;
	}








	public void setSalary(double salary) {
		dSalary = salary;
	}








	public Date getDatHireDay() {
		return datHireDay;
	}








	public void setDatHireDay(Date datHireDay) {
		this.datHireDay = datHireDay;
	}





	public void raiseSalary(double dPercent){
		double dRaise = dSalary * dPercent / 100;
		dSalary += dRaise;
	}



	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return String.format("an Employee with a salary of $%.2f", dSalary);
	}

}
