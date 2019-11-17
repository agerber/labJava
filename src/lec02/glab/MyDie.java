package lec02.glab;

public class MyDie {

	private double length;
	private double width;
	private double height;
	private String[] facets;



	public MyDie(double length, double width, double height, String[] facets) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
		this.facets = facets;
	}
	



	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String[] getFacets() {
		return facets;
	}
	public void setFacets(String[] facets) {
		this.facets = facets;
	}



	@Override
	public String toString(){
		
		String strBuild = "";
		
		strBuild = "Area: " + calcArea() + "\n";
		for(int nC = 0; nC < facets.length; nC++){
			strBuild = strBuild + " " + facets[nC];
		}
		
		return strBuild;
		
	}
	
	private double calcArea(){
		return width * height * length;
	}
	
	
	
	
}
