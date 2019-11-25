package lec09.glab.simpledatastructs.stack;

import java.util.Iterator;


//this class is generic
public class SimpleStack<T> {

	private Node<T> nodTop;
	//private Node<T> nodLast;
	private int nSize;

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================
	public SimpleStack() {

		nodTop = null;
		//nodLast = null;
		//nSize will default to zero
		nSize=0;
	}
	
	public void clear(){
		nodTop = null; //was nodFirst
		//nodLast = null;
		nSize = 0;

	}

	//First-in, last-out, FILO. Imagine a stack of weights at the gym.
	
	// ===============================================
	// ==ADD-FIRST O(1)
	// ===============================================
	public void push(T typ) {

		Node<T> nodNew = new Node<T>(typ, null);

		//O(1)
		if (nodTop == null) {
			nodTop = nodNew;
			//nodLast = nodNew;

		}
		//O(1)
		else {

			nodNew.setNext(nodTop);
			nodTop = nodNew;
		}
		nSize++;
	}
	
	
	// ===============================================
	// =REMOVE-FIRST O(1)
	// ===============================================
	public T pop() {


		//O(1)  
		if (nodTop == null) {
			throw new NullPointerException("doesn't exist");

		}
		//O(1)
		else {

			T typ = nodTop.getValue();
			nodTop = nodTop.getNext();
			nSize--;
			return typ;
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

	public T peek() {
		if (nodTop == null) {
			throw new NullPointerException("doesn't exist");

		}
		return nodTop.getValue();
	}

//	public T getLastValue() {
//
//		return nodLast.getValue();
//	}

//	public Node<T> getFirstNode() {
//
//		return nodTop;
//	}

//	public Node<T> getLastNode() {
//
//		return nodLast;
//	}
//	
	
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
			nodCurr = nodTop;
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
            throw new UnsupportedOperationException("Not supported");
			//we already have remove methods. not implemented.  
		}

	}//end iterator







}






