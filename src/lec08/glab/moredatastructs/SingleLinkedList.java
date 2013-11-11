package lec08.glab.moredatastructs;

import java.util.Iterator;

public class SingleLinkedList<T> {

	private Node<T> nodFirst;
	private Node<T> nodLast;
	private int nSize;

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================

	public SingleLinkedList() {

		nodFirst = null;
		nodLast = null;
	}

	// ===============================================
	// ==ADD AT THE END
	// ===============================================

	//get the iterator
	public LinkedListIterator iterator() {
		return new  LinkedListIterator();
	}

	public void add(T typ) {

		Node<T> nodNew = new Node<T>(typ, null);

		//O(1)
		if (nodFirst == null) {
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
	// =REMOVE AT THE END
	// ===============================================
	public T remove() {

		//	Node<T> nodNew = new Node<T>(typ, null);

		//O(1)
		if (nodLast == null) {
			return null;

		}
		//O(1)  
		//there is only one node 
		else if (nodLast == nodFirst) {

			Node<T> nodReturn = nodLast;
			nodLast = null;
			nodFirst = null;
			nSize--;
			return nodReturn.getValue();

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

	public void add(T typ, int nIndex)
			throws ArrayIndexOutOfBoundsException {

		Node<T> nodNew = new Node<T>(typ, null);

		if (nIndex > nSize || nIndex < 0)
			throw new ArrayIndexOutOfBoundsException(
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

	//package scope
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
			//do nothing, not implemented. 

		}

	}



}

//package scope
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
