package edu.uchicago.gerber.labjava.lec06.junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/4/13
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class RecursionDriverTest {
    /**
     * @verifies return some factorial recrusively
     * @see RecursionDriver#myFactorialRec(int)
     */
    @Test
    public void myFactorialRec_shouldReturnSomeFactorialRecrusively() throws Exception {
        //TODO auto-generated
       // Assert.fail("Not yet implemented");
    }

    /**
     * @verifies create factorial iteratively
     * @see RecursionDriver#myFactorialIter(int)
     */
    @Test
    public void myFactorialIter_shouldCreateFactorialIteratively() throws Exception {
        //TODO auto-generated
       // Assert.fail("Not yet implemented");
    }

    /**
     * @verifies replace a char in a string recursively
     * @see RecursionDriver#replaceRec(String, char, char)
     */
    @Test
    public void replaceRec_shouldReplaceACharInAStringRecursively() throws Exception {
        //TODO auto-generated
       // Assert.fail("Not yet implemented");
    }

    /**
     * @verifies replace some char in a string iteratively
     * @see RecursionDriver#replaceIter(String, char, char)
     */
    @Test
    public void replaceIter_shouldReplaceSomeCharInAStringIteratively() throws Exception {
        //TODO auto-generated
       // Assert.fail("Not yet implemented");
    }

    /**
     * @verifies reverse the chars
     * @see RecursionDriver#reverseCharsRec(String)
     */
    @Test
    public void reverseCharsRec_shouldReverseTheChars() throws Exception {
        //TODO auto-generated
       // Assert.fail("Not yet implemented");
    }

    /**
     * @verifies reverse the chars iteratively
     * @see RecursionDriver#reverseCharsIter(String)
     */
    @Test
    public void reverseCharsIter_shouldReverseTheCharsIteratively() throws Exception {
        assertEquals("Result", "sraeB", RecursionDriver.reverseCharsIter("Bears"));
    }

    /**
     * @verifies append a char to the end
     * @see RecursionDriver#appendChar(String, char)
     */
    @Test
    public void appendChar_shouldAppendACharToTheEnd() throws Exception {
        //TODO auto-generated
       // Assert.fail("Not yet implemented");
    }
}
