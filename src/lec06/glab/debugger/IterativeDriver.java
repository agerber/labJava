package lec06.glab.debugger;

public class IterativeDriver {


	/**
	 * @param args
	 */
	public static void main(String[] args) {


		//first day of class march 28th
		MyDate mdt = new MyDate(28,2,2016);

		//last day of class June 6th
		MyDate mdtEndQtr = new MyDate(6,5,2016);

		while(mdt.compareTo(mdtEndQtr) <= 0){

            System.out.println(mdt);
			advancedDays(7, mdt);

		
		}


	}

    /**
     *
     * @param nAdd
     * @param mdt
     * @should add days to MyDate
     */
	private static void advancedDays(int nAdd, MyDate mdt){
		for (int nD = 0; nD < nAdd; nD++) {
			mdt.addDay();
		}
	}
	




}
