package lec09.glab.simpledatastructs.linkedlist;

import java.util.Iterator;


//this class is generic
public class SimpleLinkedList<T> {

	private Node<T> nodFirst;
	private Node<T> nodLast;
	private int nSize;

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================
	public SimpleLinkedList() {

		nodFirst = null;
		nodLast = null;
		//nSize will default to zero
		nSize=0;
	}
	
	public void clear(){
		nodFirst = null;
		nodLast = null;
		nSize = 0;

	}

	
	
	// ===============================================
	// ==ADD-FIRST O(1)
	// ===============================================
	public void addFirst(T typ) {

		Node<T> nodNew = new Node<T>(typ, null);

		//O(1)
		if (nodFirst == null) {
			nodFirst = nodNew;
			nodLast = nodNew;

		}
		//O(1)
		else {

			nodNew.setNext(nodFirst);
			nodFirst = nodNew;
		}
		nSize++;
	}
	
	// ===============================================
	// ==ADD-LAST O(1)
	// ===============================================
	public void addLast(T typ) {

		Node<T> nodNew = new Node<T>(typ, null);

		//O(1)
		if (nodLast == null) { //we can assume that if nodLast is null, then nodFirst is null
			nodFirst = nodNew;
			nodLast = nodNew;

		}
		//O(1)
		else {

			nodLast.setNext(nodNew);
			nodLast = nodNew;
		}

		nSize++;
		

	}
	
	
	
	// ===============================================
	// =REMOVE-FIRST O(1)
	// ===============================================
	public T removeFirst() {


		//O(1)  
		if (nodFirst == null) {
			throw new NullPointerException("doesn't exist");

		}
		//O(1)  
		//there is only one node 
		else if (nodLast == nodFirst) {

			T typ = nodFirst.getValue();
			nodLast = null;
			nodFirst = null;
			nSize--;
			return typ;

		}
		//O(1)
		else {

			T typ = nodFirst.getValue();
			nodFirst = nodFirst.getNext();
			nSize--;
			return typ;
		}

	}

	// ===============================================
	// =REMOVE-LAST O(n) - test thoroughly
	// ===============================================
	public T removeLast() {


		//O(1)
		if (nodLast == null) {
			throw new NullPointerException("doesn't exist");

		}
		//O(1)  
		//there is only one node 
		else if (nodLast == nodFirst) {

			
			T typ = nodLast.getValue();
			nodLast = null;
			nodFirst = null;
			nSize--;
			return typ;

		}
		//O(n)
		else {

			Node<T> nodCurrent = nodFirst;
			for (int nC = 0; nC < nSize - 2; nC++) {
				nodCurrent = nodCurrent.getNext();
			}

			Node<T> nodReturn = nodLast;
			nodLast = nodCurrent;
			nodLast.setNext(null);
			nSize--;
			return nodReturn.getValue();

		}

	}

	// ===============================================
	// =ADD AT INDEX O(n)
	// ===============================================
	public void addAtIndex(T typ, int nIndex) {

		Node<T> nodNew = new Node<T>(typ, null);

		if (nIndex > nSize || nIndex < 0)
			throw new IndexOutOfBoundsException(
					"index is beyond the range of this linked list.");

		//O(1)
		//no elements 
		if (nodFirst == null) { //we can assume both first and last are null here
			nodFirst = nodNew;
			nodLast = nodNew;

		}
		//O(1)
		//at beginning
		else if (nIndex == 0) {

			nodNew.setNext(nodFirst);
			nodFirst = nodNew;

		}
		//O(1)
		//at end
		else if (nIndex == nSize) {
			nodLast.setNext(nodNew);
			nodLast = nodNew;

		}
		//O(n) ouch
		else {

			Node<T> nodCurrent = nodFirst;

			for (int nC = 0; nC < nIndex - 1; nC++) {
				nodCurrent = nodCurrent.getNext();
			}

			nodNew.setNext(nodCurrent.getNext());
			nodCurrent.setNext(nodNew);

		}

		nSize++;

	}
	
	
	
	
	// ===============================================
	// =GET AT INDEX O(n)
	// ===============================================
	public T getAtIndex(int nIndex) {

		//Node<T> nodNew = new Node<T>(typ, null);

		if (nIndex > nSize-1 || nIndex < 0)
			throw new IndexOutOfBoundsException(
					"index is beyond the range of this linked list.");

		//O(1)
		//no elements 
		else if (nodFirst == null) { //we can assume both first and last are null here
			throw new NullPointerException("there is nothing to get");

		}
		//O(1)
		//at beginning
		else if (nIndex == 0) {

			return nodFirst.getValue();


		}
		//O(1)
		//at end
		else if (nIndex == nSize-1) {
			
			return nodLast.getValue();

		}
		//O(n) ouch
		else {

			Node<T> nodCurrent = nodFirst;

			for (int nC = 0; nC < nIndex; nC++) {
				nodCurrent = nodCurrent.getNext();
			}

			return nodCurrent.getValue();

		}

	}
	
	
	// ===============================================
	// =REMOVE AT INDEX O(n)
	// ===============================================
	public T removeAtIndex(int nIndex)
			throws IndexOutOfBoundsException, NullPointerException {

		//Node<T> nodNew = new Node<T>(typ, null);

		if (nIndex > nSize-1 || nIndex < 0)
			throw new IndexOutOfBoundsException(
					"index is beyond the range of this linked list.");

		//O(1)
		//no elements 
		else if (nodFirst == null) { //we can assume both first and last are null here
			throw new NullPointerException("there is nothing to remove");

		}
		//O(1)
		//one element only
		else if (nodFirst == nodLast) {
			T typ = nodFirst.getValue();
			nodFirst = null;
			nodLast = null;
			nSize--;
			return typ;
			
			
			
		}
		else if (nIndex == 0) {

			T typ = nodFirst.getValue();
			
			nodFirst = nodFirst.getNext();
			nSize--;
			return typ;
			

		}

		//O(n) ouch
		else {

			Node<T> nodCurrent = nodFirst;

			for (int nC = 0; nC < nIndex - 1; nC++) {
				nodCurrent = nodCurrent.getNext();
			}
			
			T typReturn = nodCurrent.getNext().getValue();
			nodCurrent.setNext(nodCurrent.getNext().getNext());
			nSize--;
			return typReturn;


		}

	

	}

	//used to print to screen
	public void printIterate(){
		Iterator<T> itr =  this.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
			
		}
	}


	
	public int size() {
		return nSize;
	}

	public T getFirstValue() {

		return nodFirst.getValue();
	}

	public T getLastValue() {

		return nodLast.getValue();
	}

	public Node<T> getFirstNode() {

		return nodFirst;
	}

	public Node<T> getLastNode() {

		return nodLast;
	}
	
	
	//get the iterator
	public LinkedListIterator iterator() {
		return new  LinkedListIterator();
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
	
	
	//inner class
	class LinkedListIterator implements Iterator<T> {

		private Node<T> nodCurr; // Current position

		 LinkedListIterator() {
			nodCurr = nodFirst;
		}

		 @Override
		public boolean hasNext() {

			return (nodCurr != null);
		}
		 
		 @Override
		public T next() {
			T typ = nodCurr.getValue();
			nodCurr = nodCurr.getNext();
			return typ;
		}

		@Override
		public void remove() {
			//we already have remove methods. not implemented.  
		}

	}//end iterator







}






