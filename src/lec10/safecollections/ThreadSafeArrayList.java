package lec10.safecollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//this is a wrapper class
public class ThreadSafeArrayList {

	private  List<String> strVals;


	
	public ThreadSafeArrayList() {

		this.strVals =  Collections.synchronizedList(new ArrayList<String>());
	}
	
	
	
	public void add(String str){
		synchronized (strVals) {
			
			strVals.add(str);
		}
		
	}
	
	public boolean remove(String str){
		synchronized (strVals) {
			
			return strVals.remove(str);
		}
		
	}
	

	
	
}
