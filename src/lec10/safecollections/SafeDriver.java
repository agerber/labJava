package lec10.safecollections;

import java.util.concurrent.CopyOnWriteArrayList;




public class SafeDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

//		ThreadSafeArrayList tsa = new ThreadSafeArrayList();
//		Thread thr1 = new Thread(new SafeRunner(tsa));
//		Thread thr2 = new Thread(new SafeRunner(tsa));
//		Thread thr3 = new Thread(new SafeRunner(tsa));
//		
//		thr1.start();
//		thr2.start();
//		thr3.start();
		
		 CopyOnWriteArrayList<String> strVals  = new CopyOnWriteArrayList<String>();
		 Thread thr1 = new Thread(new SafeRunnerEasy(strVals));
		 Thread thr2 = new Thread(new SafeRunnerEasy(strVals));
		 Thread thr3 = new Thread(new SafeRunnerEasy(strVals));
		 
		thr1.start();
		thr2.start();
		thr3.start();
		


	}

}
