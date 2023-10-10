package edu.uchicago.gerber.labjava.lec01;

import java.util.Date;

public class Player  {

    private String name;
    private double money;
    private Date inception;

    public Player(String name, double money) {
        this.name = name;
        this.money = money;
        this.inception = new Date();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getInception() {
        return inception;
    }

    public void setInception(Date inception) {
        this.inception = inception;
    }


}
