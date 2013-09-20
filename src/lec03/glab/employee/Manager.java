package lec03.glab.employee;

public class Manager extends Employee {
	
	private double dBonus;

	public Manager(String name, double salary, int nYear, int nMonth, int nDay,
			double bonus) {
		super(name, salary, nYear, nMonth, nDay);
		dBonus = bonus;
	}

	public double getBonus() {
		return dBonus;
	}

	public void setBonus(double bonus) {
		dBonus = bonus;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return String.format("a Manager with a salary of" +  getSalary()+ " and a bonus of " + getBonus() );
	}
	
	
	

}
