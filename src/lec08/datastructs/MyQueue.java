package lec08.datastructs;

import java.util.AbstractQueue;
import java.util.Iterator;

public class MyQueue<T> extends AbstractQueue<T> {

	private Node<T> nodFirst;
	private Node<T> nodLast;
	private int nSize;
	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================

	public MyQueue() {

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
	
	
	//a queue only adds at the end, ok
	public void enqueue(T typ) {

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
	// =REMOVE AT THE end
	// ===============================================
	public T dequeue() {

		//	Node<T> nodNew = new Node<T>(typ, null);

		//O(1)
		if (nodFirst == null) {
			return null;

		}
		//O(1)  
		//there is only one node 
		else if (nodLast == nodFirst) {

			Node<T> nodReturn = nodFirst;
			nodLast = null;
			nodFirst = null;
			nSize--;
			return nodReturn.getValue();

		}
		
		//O(1)  you need the second the last reference, so 
		//you need to traverse the entire linkedList
		else {

			
			Node<T> nodRemove = nodFirst;
			nodFirst = nodRemove.getNext();
			T typReturn = nodRemove.getValue();
			nodRemove = null;
			return typReturn;

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

	//package scope
	//inner class (defined within enclosing brackets of class) 
	//can access fields of this class
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

	}//end iterator
	//class
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
	//this is like add but safer. 
	@Override
	public boolean offer(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	//peek
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	//remove
	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

//package scope

//inner class




