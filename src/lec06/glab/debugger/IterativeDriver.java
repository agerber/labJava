package lec06.glab.debugger;

public class IterativeDriver {


	/**
	 * @param args
	 */
	public static void main(String[] args) {


		//first day of class
		MyDate mdt = new MyDate(29,8,2014);

		MyDate mdtEndQtr = new MyDate(8,11,2014);

		while(mdt.compareTo(mdtEndQtr) <= 0){

            System.out.println(mdt);
			addDays(7, mdt);

		
		}


	}

    /**
     *
     * @param nAdd
     * @param mdt
     * @should add days to MyDate
     */
	private static void addDays(int nAdd, MyDate mdt){
		for (int nD = 0; nD < nAdd; nD++) {
			mdt.addDay();
		}
	}
	




}
