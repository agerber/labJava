package edu.uchicago.gerber.labjava.lec03.glab.employee;

public final class Executive extends Manager{



	private double stockValue;

	public Executive(String name, double salary, double bonus, double stockValue) {
		super(name, salary, bonus);
		this.stockValue = stockValue;
	}

	public double getStockValue() {
		return stockValue;
	}

	public void setStockValue(double m) {
		stockValue = m;
	}

	@Override
	public String getDescription() {
		return super.getName();
//		return String.format("an exec with a salary of " +  getSalary()+ " and a bonus of " + getBonus() +
//				" and a stock comp of " + getStockValue()) ;

	}

	public String greetOther(Employee employee){

		if (employee instanceof  Executive){
			return greetOther((Executive) employee);
		} else {
			String strType = employee.getClass().getSimpleName();
			return "You are just a " + strType + ", leave me alone";
		}

	}

	private String greetOther(Executive other){

		double myMojo = this.getSalary() + this.getBonus() + this.getStockValue();
		double otherMojo = other.getSalary() + other.getBonus() + other.getStockValue();

		if (myMojo > otherMojo){
			return "Bow to me, you peasant, " + other.getName();
		} else if (myMojo < otherMojo){
			return "I bet you think you are a hot shot, don't you?";
		} else {
			return "Let's play golf";
		}

	}

	public String demote(){
		return "you've been demoted: " + super.getDescription();
	}

	public Executive promote(){
		this.setSalary(this.getSalary() * 2);
		return  this;
	}







}