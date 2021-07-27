

 structs - from A/P computer science
 searchsort - demos of searc and sort algorithms created by yours truly
 simpledatastrcuts - implementation of most basic data structs - hand-rolled - using list-nodes and tree-nodes that we created.


 recreate the datastructs from scratch using the listNode and treeNode.

 start with Queue:

 What is a Node<T>

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


What is an Iterator


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