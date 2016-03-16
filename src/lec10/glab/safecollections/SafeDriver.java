package lec10.glab.safecollections;

import java.util.concurrent.CopyOnWriteArrayList;




public class SafeDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

        //relatively more safe than regular arraylist.
		
		 CopyOnWriteArrayList<String> strVals  = new CopyOnWriteArrayList<String>();
		 Thread thr1 = new Thread(new SafeRunnerEasy(strVals));
		 Thread thr2 = new Thread(new SafeRunnerEasy(strVals));


		thr1.start();
		thr2.start();




	}

}
