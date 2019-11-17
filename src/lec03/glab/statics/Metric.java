package lec03.glab.statics;

 public final class Metric {

	
	// ===============================================
	// ==EVERYTHING IN THIS CLASS IS STATIC: FIELDS AND METHODS
	// ===============================================

	private Metric(){};
	
	// ===============================================
	// ==  CONSTANTS
	// ===============================================
	
	
	public final static int EARTH_CIRCUMFRENCE_KM = 40076;
	public final static int MOON_CIRCUMFRENC_KM = 10921;
	
	// ===============================================
	// ==  LENGTH
	// ===============================================
	
	public static double getMillimeters(double dInches){
		return dInches * 25.4;
	}
	
	public static double getMeters(double dFeet){
		return dFeet * 0.305;
	}
	
	public static double getKilometers(double dMiles){
		return dMiles * 1.61;
	}
	
	
	
	// ===============================================
	// ==  VOLUME
	// ===============================================
	
	
	
	public static double getLiters(double dGallons){
		return dGallons * 3.785;
	}
	
	public static double getCubicMeters(double dCubicFeet){
		return dCubicFeet * 0.028;
	}
	
	// ===============================================
	// ==  MASS
	// ===============================================
	
	public static double getKilograms(double dPounds){
		return dPounds * 0.454;
	}
	
	
	// ===============================================
	// ==  TEMPERATURE
	// ===============================================
	
	public static double getCelcius(double dFahrenheit){
		return (dFahrenheit - 32.0)/1.8;
	}
	
	
	//let's inspec the Math class
	//double dResult = Math.pow(2,8);
	
	
}
