package edu.uchicago.gerber.labjava.lec08.glab.blackjack;

import java.text.DecimalFormat;

public class Player   {

    private static DecimalFormat sDecimalFormat = new DecimalFormat("$0.00");

	private double dMoney;


    public Player(double dMoney) {
        this.dMoney = dMoney;

    }



    public double getMoney() {
		return this.dMoney;
	}

	public void setMoney(double dMoney) {
		this.dMoney = dMoney;
	}


    public String getStringMoney(){
       return sDecimalFormat.format(getMoney());
    }
	
	
	
	
	
}
