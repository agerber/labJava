package edu.uchicago.gerber.labjava.lec03.boxing;



public abstract class Animal implements Boxable {


	private String name;
	private int health;

	public Animal(String name) {
		this.name = name;
		this.health = 10_000;
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



	@Override
	public void ouch(int points) {
		setHealth(getHealth() - points);
	}

	@Override
	public String punch(Boxable other) {
		int hits = (int) (Math.random() * 100);
		other.ouch(hits);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n" + this.getAscii());
		stringBuilder.append("\nPUNCHES");
		stringBuilder.append("\n" + other.getAscii());
		return stringBuilder.toString();

	}



}
