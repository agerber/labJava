package lec07.glab.debugger;

public class IterativeDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	
		final int READING_WEEK = 9;

		
		//sept 26 2011
		
		//first day of class
		MyDate mdt = new MyDate(26,8,2011);
		//begin and end quarter
		MyDate mdtBeginQrt = new MyDate(26,8,2011);
		MyDate mdtEndQtr = new MyDate(10,11,2011);
		
		//begin and end read-week
		MyDate mdtBeginReadWeek = mdtBeginQrt.clone();
		addDays(7 * READING_WEEK, mdtBeginReadWeek);
	
		MyDate mdtEndReadWeek = mdtBeginQrt.clone();
		addDays(7 * (READING_WEEK + 1) - 1, mdtEndReadWeek );
	
		
		
		while(mdt.compareTo(mdtEndQtr) <= 0){
			
			
			if(mdt.compareTo(mdtBeginReadWeek) < 0 || mdt.compareTo(mdtEndReadWeek) > 0){
				System.out.println(mdt);
			}
			
			addDays(7, mdt);

		
		}


	}
	
    
	private static void addDays(int nAdd, MyDate mdt){
		for (int nD = 0; nD < nAdd; nD++) {
			mdt.addDay();
		}
	}
	



}
