package edu.uchicago.gerber.labjava.lec09.simpledatastructs.hashmap;



// this class is generic
public class SimpleHashMap<K,V> {

	private HashMapNode<K,V>[] nodHashes;

	private int nSize;

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================
	public SimpleHashMap() {
		nodHashes = new HashMapNode[7];
		nSize = 0;

	}

	//overlaoded
	public SimpleHashMap(int nHashTableSize) {
		nodHashes = new HashMapNode[nHashTableSize];
		nSize = 0;

	}

	public void clear() {

		for (int nC = 0; nC < nodHashes.length; nC++)
			nodHashes[nC] = null;

		nSize = 0;

	}

	// ===============================================
	// ==ADD
	// ===============================================
	//O(1) very fast
	public void add(K typKey, V typValue) {

		int nHash = typKey.hashCode();
		nHash = Math.abs(nHash);
		nHash = nHash % nodHashes.length;

		HashMapNode<K,V> nodCurrent = nodHashes[nHash];

		if (nodCurrent == null) {
			nodHashes[nHash] = new HashMapNode<K,V>(typKey,typValue, null);
			nSize++;
		} else {

			boolean bFound = false;
			while (nodCurrent != null){
				
				if (nodCurrent.getKey().equals(typKey)){
					bFound = true;
					break;
				}
				
				nodCurrent = nodCurrent.getNext();
			}
			if (!bFound){
				nodHashes[nHash] = new HashMapNode<K,V>(typKey,typValue, nodHashes[nHash]);
				nSize++;
			}
				
			
		}

	}

	// ===============================================
	// ==CONTAINS
	// ===============================================
	//O(1) very fast
	public String contains(K typKey) {

		String strR = "";
		int nCount = 0;

		int nHash = typKey.hashCode();
		nHash = Math.abs(nHash);
		nHash = nHash % nodHashes.length;

		HashMapNode<K,V> nodCurrent = nodHashes[nHash];
		while (nodCurrent != null) {
			nCount++;
			if (nodCurrent.getKey().equals(typKey)) {
				strR += nodCurrent.getValue() + " found at index " + nHash + " : ";
				break;
			}

			nodCurrent = nodCurrent.getNext();
		}

		strR += nCount + " iterations.";
		return strR;

	}

	//used to print to screen
	public void printIterate(){
		//@formatter:off
		//write this method TODO
		//for each element in array
			//if the array is not null
				//nodCurrent = nodAtKey
				//while nodCurrent != null
					//sysout (nodCurrent.value)
					//nodCurrent = nodCurrent.getNext()
		//@formatter:on
		
		//nodHashes.length
		for (int nC = 0; nC < nodHashes.length; nC++) {
			System.out.print(nC);
			if (nodHashes[nC] == null){
				System.out.println(" : NULL");
			} 
			else {
				HashMapNode<K,V> nodCurrent = nodHashes[nC];
				while (nodCurrent != null){
					System.out.print( " : " + nodCurrent.getKey() + "-"+ nodCurrent.getValue());
					nodCurrent = nodCurrent.getNext();
				}
				System.out.println();
			}
		}
		
		
		
	}

	public int size() {
		return nSize;
	}

	//inner class
	class HashMapNode<K,V> {

		private K typKey;
		private V typValue;
		private HashMapNode<K,V> nodNext;

		HashMapNode(K typKey, V typValue, HashMapNode<K,V> nodNext) {
			this.typValue = typValue;
			this.typKey = typKey;
			this.nodNext = nodNext;
		}

		V getValue() {
			return typValue;
		}
		

		public K getKey() {
			return this.typKey;
		}

		public void setKey(K typKey) {
			this.typKey = typKey;
		}

		HashMapNode<K,V> getNext() {
			return nodNext;
		}

		void setValue(V typValue) {
			this.typValue = typValue;
		}

		void setNext(HashMapNode<K,V> nodNext) {
			this.nodNext = nodNext;
		}

	}

}
