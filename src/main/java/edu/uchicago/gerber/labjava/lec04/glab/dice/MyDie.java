package edu.uchicago.gerber.labjava.lec04.glab.dice;

public class MyDie {

	private double mLength;
	private double mWidth;
	private double mHeight;
	private String[] mFacets;
	
	
	
	
	public MyDie(double dLength, double dWidth, double dHeight, String[] strFacets) {
		super();
		this.mLength = dLength;
		this.mWidth = dWidth;
		this.mHeight = dHeight;
		this.mFacets = strFacets;
	}
	



	public double getLength() {
		return mLength;
	}
	public void setLength(double length) {
		this.mLength = length;
	}
	public double getWidth() {
		return mWidth;
	}
	public void setWidth(double width) {
		this.mWidth = width;
	}
	public double getHeight() {
		return mHeight;
	}
	public void setHeight(double height) {
		this.mHeight = height;
	}
	public String[] getFacets() {
		return mFacets;
	}
	public void setFacets(String[] facets) {
		this.mFacets = facets;
	}
	
	
	
	@Override
	public String toString(){
		
		String strBuild = "";
		
		strBuild = "Area: " + calcArea() + "\n";
		for(int nC = 0; nC < mFacets.length; nC++){
			strBuild = strBuild + " " + mFacets[nC];
		}
		
		return strBuild;
		
	}
	
	private double calcArea(){
		return mWidth * mHeight * mLength;
	}
	
	
	
	
}
