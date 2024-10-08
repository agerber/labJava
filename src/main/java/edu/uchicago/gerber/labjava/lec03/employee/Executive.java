package edu.uchicago.gerber.labjava.lec03.employee;

import java.util.Date;

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

	}

	public String greetOther(Employee employee){

		if (employee instanceof  Executive){
			return greetOther("On " + new Date(), (Executive) employee);
		} else {
			String strType = employee.getClass().getSimpleName();
			return "You are just a " + strType + ", leave me alone";
		}

	}

	private String greetOther(String preamble, Executive other ){

		double myMojo = this.getSalary() + this.getBonus() + this.getStockValue();
		double otherMojo = other.getSalary() + other.getBonus() + other.getStockValue();

		if (myMojo > otherMojo){
			return preamble + "; bow to me, you peasant, " + other.getName();
		} else if (myMojo < otherMojo){
			return preamble + "; I bet you think you are a hot shot, don't you?";
		} else {
			return  preamble + "; let's play golf";
		}

	}


	public Executive doubleSalary(){
		this.setSalary(this.getSalary() * 2);
		return  this;
	}







}
