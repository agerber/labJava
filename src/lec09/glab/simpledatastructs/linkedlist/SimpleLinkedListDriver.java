package lec09.glab.simpledatastructs.linkedlist;


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
		System.out.println("####################");
		
		strNames.printIterate();
		//getAtIndexWorking nSize working
		System.out.println("####################");
		for (int nC = 0; nC < strNames.size(); nC++) {
			System.out.println(strNames.getAtIndex(nC));
		}
		
		
		

	}
	

}
