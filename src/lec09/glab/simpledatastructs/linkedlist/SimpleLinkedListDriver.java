package lec09.glab.simpledatastructs.linkedlist;


import java.util.Iterator;

public class SimpleLinkedListDriver {

public static void main(String[] args) {
		
		SimpleLinkedList<String> strNames = new SimpleLinkedList<String>();
	
		//addFirst and addLast are working
		strNames.addFirst("Charlie");
		strNames.addLast("Thomas");
		strNames.addFirst("Bob");
		strNames.addFirst("Adam");



		
		strNames.printIterate();

		System.out.println("####################");

		//get at index is working
		System.out.println(strNames.getAtIndex(1)); //expect Bob
		System.out.println("####################");
		
		
		strNames.addAtIndex("ZZTop",4);
		
		strNames.printIterate();
		System.out.println("####################");
		
		//removeAtIndex working
		System.out.println(strNames.removeAtIndex(3)); //expect Thomas



		//getAtIndexWorking nSize working
		System.out.println("########traverse the list using indices############");
		System.out.println("########O(n^2)############");

		for (int nC = 0; nC < strNames.size(); nC++) {
			System.out.println(strNames.getAtIndex(nC));
		}
        System.out.println("#########use iterator to traverse list###########");
        System.out.println("#########O(n)###########");
        Iterator itrIterator = strNames.iterator();
        while( itrIterator.hasNext()){
            System.out.println(itrIterator.next());
        }



}
	

}
