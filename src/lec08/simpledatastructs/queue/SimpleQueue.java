package lec08.simpledatastructs.queue;

import java.util.Iterator;


//this class is generic
public class SimpleQueue<T> {

	private Node<T> nodHead; //was nodFirst
	private Node<T> nodTail; //was nodLast
	private int nSize;

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================
	public SimpleQueue() {

		nodHead = null;
		nodTail = null;
		//nSize will default to zero
	}
	
	public void clear(){
		nodHead = null;
		nodTail = null;
		nSize = 0;

	}

	

	// ===============================================
	// ==ADD-LAST O(1)
	// ===============================================
	public void enqueue(T typ) {

		Node<T> nodNew = new Node<T>(typ, null);

		//O(1)
		if (nodHead == null) {
			nodHead = nodNew;
			nodTail = nodNew;

		}
		//O(1)
		else {

			nodTail.setNext(nodNew);
			nodTail = nodNew;
		}

		nSize++;
		

	}
	
	
	
	// ===============================================
	// =REMOVE-FIRST O(1)
	// ===============================================
	public T dequeue() {


		//O(1)  
		if (nodHead == null) {
			throw new NullPointerException("doesn't exist");

		}
		//O(1)  
		//there is only one node 
		else if (nodTail == nodHead) {

			T typ  = nodHead.getValue();
			nodTail = null;
			nodHead = null;
			nSize--;
			return typ;

		}
		//O(1)
		else {

			T typ  = nodHead.getValue();
			nodHead = nodHead.getNext();
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

	public T getFirstValue() {

		return nodHead.getValue();
	}

	public T getLastValue() {

		return nodTail.getValue();
	}

	public Node<T> getFirstNode() {

		return nodHead;
	}

	public Node<T> getLastNode() {

		return nodTail;
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
			nodCurr = nodHead;
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






