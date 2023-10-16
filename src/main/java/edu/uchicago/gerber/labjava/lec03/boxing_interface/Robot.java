package edu.uchicago.gerber.labjava.lec03.boxing_interface;

public class Robot implements Boxable {

	private String model;
	private int electricity;


	public Robot(String model) {
		this.model = model;
		this.electricity = 10_000;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getElectricity() {
		return electricity;
	}

	public void setElectricity(int electricity) {
		this.electricity = electricity;
	}

	@Override
	public  String getAscii() {
		return 			"        /             /|\n" +
				"       /             / |\n" +
				"      /____________ /  |\n" +
				"     | ___________ |   |\n" +
				"     ||           ||   |\n" +
				"     ||           ||   |\n" +
				"     ||           ||   |\n" +
				"     ||___________||   |\n" +
				"     |   _______   |  /\n" +
				"    /|  (_______)  | /\n" +
				"   ( |_____________|/\n" +
				"    \\\n" +
				".=======================.\n" +
				"| ::::::::::::::::  ::: |\n" +
				"| ::::::::::::::[]  ::: |\n" +
				"|   -----------     ::: |\n" +
				"`-----------------------'";
	}

	@Override
	public int getHealth() {
		return getElectricity();
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

	@Override
	public void ouch(int points) {
		setElectricity(getElectricity() - points);
	}


	@Override
	public String toString() {
		return this.getModel() + ":Robot";
	}
}
