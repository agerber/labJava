package edu.uchicago.gerber.labjava.lec09.searchsort;



public class HashTable {

	
	private ListNode[] nodVals;

	public HashTable(int nBuckets) {
	
		
		nodVals = new ListNode[nBuckets];
				
		
	}
	//O(1) very fast
	public String contains(Object obj){
		
		String strR = "";
		int nCount = 0;
		
		int nHash = obj.hashCode();
		nHash = Math.abs(nHash);
		nHash = nHash % nodVals.length;
		
		ListNode nodCurrent = nodVals[nHash];
		//nCount++;
		while(nodCurrent != null){
			nCount++;
			if(nodCurrent.getValue().equals(obj)){
				strR += obj + " found at " + nHash + " : ";
				break;
			}
			
			nodCurrent = nodCurrent.getNext();
		}
		
		strR +=  nCount + " iterations.";
		return strR;
		
	}
	
	
	public void add(Object obj){

		int nHash = obj.hashCode();
		nHash = Math.abs(nHash);
		nHash = nHash % nodVals.length;
		
		ListNode nodCurrent = nodVals[nHash];

		if(nodCurrent == null){
			nodVals[nHash] = new ListNode(obj, null);
		}
		else {
			
			while(nodCurrent.getNext() != null)
				nodCurrent = nodCurrent.getNext();
	
			nodCurrent.setNext(new ListNode(obj, null));
		}

	}
	
	
	
	
}
