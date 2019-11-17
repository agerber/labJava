package lec05.glab.real;
import java.text.DecimalFormat;
import java.util.Date;


//cntrl-H  and cntrl-shift-alt-U
public class House implements Cloneable {

	// ===============================================
	// ==INSTANCE VARIABLES
	// ===============================================	
	private String mAddress;
	private double mMarketValue;
	private boolean mForeclosed;
	//this gets added later
	private Date mDatInstantiated;

    //I want this instance to be available to all classes to instantiate it in the static context
    private static DecimalFormat sFormatter;
    static {
        sFormatter = new DecimalFormat("$#,###.00");
    }
	
	
	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================	
	public House(String address, double marketValue,
                 boolean foreclosed) {
		this.mAddress = address;
		this.mMarketValue = marketValue;
		this.mForeclosed = foreclosed;
		mDatInstantiated = new Date();
	}

	// ===============================================
	// ==GETTERS AND SETTERS
	// ===============================================

	public String getAddress() {
		return this.mAddress;

	}

	public void setAddress(String address) {
		this.mAddress = address;
	}



	public double getMarketValue() {
		return this.mMarketValue;
	}

	public void setMarketValue(double marketValue) {
		this.mMarketValue = marketValue;
	}


	public boolean isForeclosed() {
		return this.mForeclosed;
	}

	public void setForeclosed(boolean foreclosed) {
		this.mForeclosed = foreclosed;
	}
	
	
	
	//these get added later
	public Date getDatInstantiated() {
		return this.mDatInstantiated;
	}

	public void setDatInstantiated(Date datInstantiated) {
		this.mDatInstantiated = datInstantiated;
	}

    @Override
	public String toString(){

		return getDatInstantiated() + " : "
                + getDatInstantiated().getTime()
                + " : " + getAddress()
                + " : " + sFormatter.format(getMarketValue())
                + (mForeclosed ? " >FORECLOSED" : ""
                + "\n");

	}

	//satisfies the Clonable interface
    @Override
	 public House clone() throws CloneNotSupportedException {
		 	
		     House houClone =  (House) super.clone();
		     
		     //no need to clone string because it is immutable
		     
		    // comment out below line and see if clone works.
		    // houClone.setDatInstantiated((Date)getDatInstantiated().clone());




		return houClone;

		  }


	
	
	
}
