package edu.uchicago.gerber.labjava.lec03.glab.boxing;

import edu.uchicago.gerber.labjava.lec03.glab.ascii.Asciify;
import edu.uchicago.gerber.labjava.lec03.glab.dogfight.Dog;


public abstract class Animal {


	private String name;
	private int health;

	public Animal(String name) {
		this.name = name;
		this.health = 10000;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}



	@Override
	public String toString() {
		return this.name + ":" + this.getClass().getSimpleName();
	}

	public String toStringHealth() {
		return toString() + ":" + getHealth();
	}
		
		

	
}