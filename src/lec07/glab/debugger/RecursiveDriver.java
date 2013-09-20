package lec07.glab.debugger;

public class RecursiveDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//macdonalds translator
		String str = "mmm mmmm good, I love mocha during my morning commute.";
		String strAd = replaceRec(str, 'm', ' ');
		System.out.println(strAd);
	 

	}
	
	
	// ===============================================
	// ==a char replace function using recursion
	// ===============================================
	public static String replaceRec(String str, char cOld, char cNew) {
		if (str.length() == 0)
			return "";
		else if (str.charAt(0) == cOld)
			return cNew + replaceRec(str.substring(1), cOld, cNew);
		else
			return str.charAt(0) + replaceRec(str.substring(1), cOld, cNew);
	}

}
