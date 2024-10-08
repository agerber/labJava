package edu.uchicago.gerber.labjava.lec04.employee;



public class Manager extends Employee {
	
	private double mBonus;

	public Manager(String name, double salary, int nYear, int nMonth, int nDay,
			double bonus) {
		super(name, salary, nYear, nMonth, nDay);
		mBonus = bonus;
	}

	public double getBonus() {
		return mBonus;
	}

	public void setBonus(double bonus) {
		mBonus = bonus;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return String.format("a Manager with a salary of " +  getSalary()+ " and a bonus of " + getBonus() );
	}


    @Override
    public String toString(){
        return "MANAGER> " + super.toString();
    }
	
	
	

}
