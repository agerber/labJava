package lec03.glab.employee;

public final class Executive extends Manager {



	private double mStockValue;

	public Executive(String name, double salary, int nYear, int nMonth,
					 int nDay, double bonus, double stockValue) {
		super(name, salary, nYear, nMonth, nDay, bonus);
		mStockValue = stockValue;
	}

	public double getStockValue() {
		return mStockValue;
	}

	public void setStockValue(double stockValue) {
		mStockValue = stockValue;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return String.format("an exec with a salary of " +  getSalary()+ " and a bonus of " + getBonus() +
				" and a stock comp of " + getStockValue()) +

				Executive.getAlphaOrder(this);
	}

	public static String getAlphaOrder(Executive executive){
		return  "MMMMMMMMMMMM".compareTo(executive.getName()) < 1 ? executive.getName() + ": exec's name greater than M" : executive.getName() +  ": exec's name less than M";
	}

}
