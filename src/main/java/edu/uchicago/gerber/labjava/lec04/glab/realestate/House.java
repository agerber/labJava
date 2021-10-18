package edu.uchicago.gerber.labjava.lec04.glab.realestate;
import java.text.DecimalFormat;
import java.util.Date;


//cntrl-H  and cntrl-shift-alt-U
public class House implements Cloneable {

	// ===============================================
	// ==INSTANCE VARIABLES
	// ===============================================	
	private String address;
	private double marketValue;
	private boolean foreclosed;
	//this gets added later
	private Date timestamp;

    //I want this instance to be available to all classes to instantiate it in the static context
    private static DecimalFormat formatter;
    static {
        formatter = new DecimalFormat("$#,###.00");
    }
	
	
	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================	
	public House(String address, double marketValue,
			 boolean foreclosed) {
		this.address = address;
		this.marketValue = marketValue;
		this.foreclosed = foreclosed;
		timestamp = new Date();
	}

	// ===============================================
	// ==GETTERS AND SETTERS
	// ===============================================

	public String getAddress() {
		return this.address;

	}

	public void setAddress(String address) {
		this.address = address;
	}



	public double getMarketValue() {
		return this.marketValue;
	}

	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}


	public boolean isForeclosed() {
		return this.foreclosed;
	}

	public void setForeclosed(boolean foreclosed) {
		this.foreclosed = foreclosed;
	}
	
	
	
	//these get added later
	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setDatInstantiated(Date datInstantiated) {
		this.timestamp = datInstantiated;
	}

    @Override
	public String toString(){

		return getTimestamp() + " : "
                + getTimestamp().getTime()
                + " : " + getAddress()
                + " : " + formatter.format(getMarketValue())
                + (foreclosed ? " >FORECLOSED" : ""
                + "\n");

	}

	//satisfies the Clonable interface
    @Override
	 public House clone() throws CloneNotSupportedException {
		 	
		     House houClone =  (House) super.clone();
		     
		     //no need to clone string because it is immutable
		     
		    // comment out below line and see if clone works.
		     houClone.setDatInstantiated((Date) getTimestamp().clone());





		return houClone;

		  }


	
	
	
}
