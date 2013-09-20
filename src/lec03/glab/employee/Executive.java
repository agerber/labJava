package lec03.glab.employee;

public final class Executive extends Manager {

	
	
	private double dStockValue;

	public Executive(String name, double salary, int nYear, int nMonth,
			int nDay, double bonus, double stockValue) {
		super(name, salary, nYear, nMonth, nDay, bonus);
		dStockValue = stockValue;
	}

	public double getStockValue() {
		return dStockValue;
	}

	public void setStockValue(double stockValue) {
		dStockValue = stockValue;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return String.format("an exec with a salary of" +  getSalary()+ " and a bonus of " + getBonus() + " and a stock comp of " + getStockValue());
	}
	
}
