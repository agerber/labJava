package lec10.safecollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



//http://www.avajava.com/tutorials/lessons/how-do-i-synchronize-a-list-or-other-collection-in-java.html
public class SynchCollection {

	
	private static List<Integer> intNums = Collections.synchronizedList(new ArrayList<Integer>());

	
	public static void main(String[] args) {


		//populate the ArrayList with anonymous thread
		new Thread(new Runnable(){
			public void run(){
				synchronized (intNums) {
				  for (int nC = 0; nC < 1000; nC++) {
					intNums.add(new Integer(nC));
					System.out.println("adding " + nC);
				}

				}
			}
		}).start();
		
		

		
		//remove any element that is divisisble by 3 
		new Thread(new Runnable(){
			public void run(){
				synchronized (intNums) {
				  for (int nC = 0; nC < 1000; nC++){ 
					  if(nC % 3 == 0){
					         intNums.remove(new Integer(nC));
					         System.out.println("try to remove " + nC);
					  }
				  }
			  }
			}
		}).start();
		
	
		
		//print the elements
		new Thread(new Runnable(){
			public void run(){
				synchronized (intNums) {
			
					for (Integer intMe : intNums) {
						System.out.println(intMe);
					}
			  }
			}
		}).start();

		

	}

}