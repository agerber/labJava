package lec08.glab.simpledatastructs.linkedlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
		//the data-structure is not mutated
	}

	@Test
	public void testAddLast() {
		strNames.addLast("Thomas");
		assertEquals(strNames.getLastValue(),"Thomas");
		assertEquals(3,strNames.size());
		//the data-structure is not mutated
	}

	@Test
	public void testRemoveFirst() {
		strNames.addFirst("Adam");
		String strAdam = strNames.removeFirst();
		assertEquals(2, strNames.size());
		assertEquals(strAdam,"Adam");
		//the data-structure is not mutated
	
	}

	@Test
	public void testRemoveLast() {
		strNames.addLast("Thomas");

		String strThomas = strNames.removeLast();
		assertEquals(2,strNames.size());
		assertEquals(strThomas,"Thomas");
		//the data-structure is not mutated

	}
	
	@Test
	public void testGetAtIndex(){
		String strBob = strNames.getAtIndex(0); //expect Bob
		assertEquals(strBob, "Bob");
		assertEquals(2,strNames.size());
		//the data-structure is not mutated
		
	}
	@Test
	public void testRemoveAtIndex(){
		String strBob = strNames.removeAtIndex(0); //expect Bob
		assertEquals(strBob, "Bob");
		assertEquals(1,strNames.size());
		//the data-structure is not mutated

		
	}
	

	@Test
	public void testAddAtIndex() {
		strNames.addAtIndex("Aaron",0); 
		assertEquals(strNames.getFirstValue(), "Aaron");
		assertEquals(3,strNames.size());
		//the data-structure is not mutated
	}

}
