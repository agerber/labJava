package lec10.glab.safecollections;

import java.util.concurrent.CopyOnWriteArrayList;

public class SynchCollectionEasy {

	
	private static CopyOnWriteArrayList<Integer> intNums = new  CopyOnWriteArrayList<Integer>();
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//the easy way to do it
	

		//populate the ArrayList with anonymous thread
		new Thread(new Runnable(){
			public void run(){
				
				  for (int nC = 0; nC < 1000; nC++) {
					intNums.add(new Integer(nC));
					System.out.println("adding " + nC);
				}

				
			}
		}).start();
		
		

		
		//remove any element that is divisisble by 3 
		new Thread(new Runnable(){
			public void run(){
				
				  for (int nC = 0; nC < 1000; nC++){ 
					  if(nC % 3 == 0){
					         intNums.remove(new Integer(nC));
					         System.out.println("try to remove " + nC);
					  }
				  }
			  
			}
		}).start();
		
		
		
	}

}
