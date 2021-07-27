package edu.uchicago.gerber.labjava.lec04.glab.hw1examples;

public class MyDate implements Comparable<MyDate> {

	public static final int[] MONTHS = {31, 29, 31, 30, 31, 30, 31, 31,30,31,30,31}; //days in each month notwithstanding leapyear
	
	//begin date
	private int nDay;
	private int nMon;
	private int nYear;
	

	
	public MyDate(int day, int mon, int year) {
		super();
		this.nDay = day;
		this.nMon = mon;
		this.nYear = year;
	}

	public int getDay() {
		return this.nDay;
	}

	public void setDay(int day) {
		this.nDay = day;
	}

	public int getMon() {
		return this.nMon;
	}

	public void setMon(int mon) {
		this.nMon = mon;
	}

	public int getYear() {
		return this.nYear;
	}

	public void setYear(int year) {
		this.nYear = year;
	}
	
	
	

	public void addDay(){
		
		
		//first discrete set
		if(getDay() <28){
			setDay(getDay() + 1);
			return;
		}
		
		//second discrete set of inclusive
		//specific to generic
		//last day of the year
		if(getDay() == 31 && getMon() == 11){
			setYear(getYear() + 1);
			setMon(0);
			setDay(1);
		}
		//last day of the month
		else if (isLeapYear(getYear()) && getMon() == 1 && getDay() == MONTHS[getMon()] ){
			//feb and leap year
			 setMon(2);
			 
			 setDay(1);
				
			
		}
		else if (!isLeapYear(getYear()) && getMon() == 1 && getDay() == MONTHS[getMon()]-1 ){
		
			 setMon(2);
			 setDay(1);
		}
		else if (getDay() == MONTHS[getMon()]){
			setMon(getMon() + 1);
			setDay(1);
		}
		else {
			setDay(getDay() + 1);
		}
	}

	
   
	public static boolean isLeapYear(int nYear){
        

        
        return ( ((nYear % 400) == 0) || 
        		( ((nYear % 4) == 0) && ((nYear % 100) != 0) ) );
	}
	
	public String toString(){
		
		
		return getMon() + 1 + "/" + getDay() + "/"  + getYear();
	}
	
	
	// ===============================================
	// ==METHOD THAT SATISFIES THE COMPARABLE INTERFACE
	// ===============================================
	
	public int compareTo(MyDate mdt) {
	
		
		//this algorithm lends itself to ; generic grouping to specific grouping
		//most generic
		if (this.getYear() > mdt.getYear())
			return 1;

		if (this.getYear() < mdt.getYear())
			return -1;
		
		
		//same year different month
		//somewhat generic
		if (this.getMon() > mdt.getMon())
			return 1;
		
		if (this.getMon() < mdt.getMon())
			return -1;

		
		//same year, same month
		//different day
		//specific	
		
		if (this.getDay() < mdt.getDay())
			return -1;
		
		if (this.getDay() > mdt.getDay())
			return 1;
	  //most specific (the dates are the same)
		else
			return 0;
			

		
	}
	
	
}
