package edu.uchicago.gerber.labjava.lec09.simpledatastructs.linkedlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleLinkedListTest {
	SimpleLinkedList<String> strNames;
	@Before
	public void setUp() throws Exception {
		
		strNames = new SimpleLinkedList<String>();
		strNames.addFirst("Charlie");
		strNames.addFirst("Bob");
		
		
	}

	@After
	public void tearDown() throws Exception {
		strNames.clear();
		strNames = null;
	}

	
	@Test
	public void testAddFirst() {
		
		strNames.addFirst("Adam");
		assertEquals(strNames.getFirstValue(),"Adam");
		assertEquals(3,strNames.size());
		
	}

	@Test
	public void testAddLast() {
		strNames.addLast("Thomas");
		assertEquals(strNames.getLastValue(),"Thomas");
		assertEquals(3,strNames.size());
		
	}

	@Test
	public void testRemoveFirst() {
		strNames.addFirst("Adam");
		String strAdam = strNames.removeFirst();
		assertEquals(2, strNames.size());
		assertEquals(strAdam,"Adam");
		
	
	}

	@Test
	public void testRemoveLast() {
		strNames.addLast("Thomas");

		String strThomas = strNames.removeLast();
		assertEquals(2,strNames.size());
		assertEquals(strThomas,"Thomas");
		

	}
	
	@Test
	public void testGetAtIndex(){
		String strBob = strNames.getAtIndex(0); //expect Bob
		assertEquals(strBob, "Bob");
		assertEquals(2,strNames.size());
		
		
	}
	@Test
	public void testRemoveAtIndex(){
		String strBob = strNames.removeAtIndex(0); //expect Bob
		assertEquals(strBob, "Bob");
		assertEquals(1,strNames.size());
		

		
	}
	

	@Test
	public void testAddAtIndex() {
		strNames.addAtIndex("Aaron",0); 
		assertEquals(strNames.getFirstValue(), "Aaron");
		assertEquals(3,strNames.size());
		
	}

	@Test
	public void testSeekAndGet(){

		boolean result = strNames.seek("Charlie");
		assertTrue(result);

		boolean result2 = strNames.seek("Bob");
		assertTrue(result2);


	}

}
