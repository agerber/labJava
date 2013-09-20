package lec08.glab.simpledatastructs.hashtable;



// this class is generic
public class SimpleHashTable<T> {

	private Node<T>[] nodHashes;

	private int nSize;

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================
	public SimpleHashTable() {
		nodHashes = new Node[1999];
		nSize = 0;

	}

	//overlaoded
	public SimpleHashTable(int nHashTableSize) {
		nodHashes = new Node[nHashTableSize];
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
	public void add(T typ) {

		int nHash = typ.hashCode();
		nHash = Math.abs(nHash);
		nHash = nHash % nodHashes.length;

		Node<T> nodCurrent = nodHashes[nHash];

		if (nodCurrent == null) {
			nodHashes[nHash] = new Node<T>(typ, null);
		} else {
	
		//add it to the beginning
			nodHashes[nHash] = new Node<T>(typ, nodHashes[nHash]);
			
	
		}
		
		nSize++;

	}

	// ===============================================
	// ==CONTAINS
	// ===============================================
	//O(1) very fast
	public String contains(T typ) {

		String strR = "";
		int nCount = 0;

		int nHash = typ.hashCode();
		nHash = Math.abs(nHash);
		nHash = nHash % nodHashes.length;

		Node<T> nodCurrent = nodHashes[nHash];
		while (nodCurrent != null) {
			nCount++;
			if (nodCurrent.getValue().equals(typ)) {
				strR += typ + " found at index " + nHash + " : ";
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
				Node<T> nodCurrent = nodHashes[nC];
				while (nodCurrent != null){
					System.out.print( " : " + nodCurrent.getValue());
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
	class Node<T> {

		private T typValue;
		private Node<T> nodNext;

		Node(T typInit, Node<T> nodInit) {
			typValue = typInit;
			nodNext = nodInit;
		}

		T getValue() {
			return typValue;
		}

		Node<T> getNext() {
			return nodNext;
		}

		void setValue(T typValue) {
			this.typValue = typValue;
		}

		void setNext(Node<T> nodNext) {
			this.nodNext = nodNext;
		}

	}

}
