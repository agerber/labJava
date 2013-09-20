package lec07.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionDriverTest {

	
//	System.out.println(myFactorialRec(5));
//	System.out.println(myFactorialIter(5));
//
//	System.out.println(replaceRec("Java", 'a', 'o'));
//	System.out.println(replaceIter("Java", 'a', 'o'));
//
//	//http://www.cs.arizona.edu/icon/oddsends/palinsen.htm
//	System.out.println( reverseCharsRec("Marge let a moody baby doom a telegram."));
//	System.out.println( reverseCharsIter("Marge let a moody baby doom a telegram."));
	
	
	@Test
	public void testMyFactorialRec() {
		assertEquals("Result", 120, RecursionDriver.myFactorialRec(5));
	}

	@Test
	public void testMyFactorialIter() {
		assertEquals("Result", 120, RecursionDriver.myFactorialIter(5));
	}

	@Test
	public void testReplaceRec() {
		assertEquals("Result", "Jovo", RecursionDriver.replaceRec("Java", 'a', 'o'));
	}

	@Test
	public void testReplaceIter() {
		assertEquals("Result", "Jovo", RecursionDriver.replaceIter("Java", 'a', 'o'));
	}

	@Test
	public void testReverseCharsRec() {
		assertEquals("Result", "sraeB", RecursionDriver.reverseCharsRec("Bears"));
	}

	@Test
	public void testReverseCharsIter() {
		assertEquals("Result", "sraeB", RecursionDriver.reverseCharsIter("Bears"));
	}

}
