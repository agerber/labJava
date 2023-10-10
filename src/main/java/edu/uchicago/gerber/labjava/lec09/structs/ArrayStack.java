package edu.uchicago.gerber.labjava.lec09.structs;

import java.util.ArrayList;

/**
 * A simple yet completely functional implementation
 * of the <code>Stack</code> interface. The interface
 * is part of the AP subset and is testable. This implementation
 * is <b>not</b> part of the subset, but is useful in
 * a classroom setting.
 * <P>
 * All stack functions execute in <em>O(1)</em> or constant time
 * amortized over several stack operations. This is because the
 * underlying storage is <code>java.util.ArrayList</code> which
 * supports constant time access, put (to end), and remove
 * (from end).
 * <P>
 * This implementation is provided
 * at <a href="http://apcentral.collegeboard.com">apcentral</a>.
 */

public class ArrayStack implements Stack 
{
    /**
     * Construct an initially empty stack.
     */
    public ArrayStack()
    {
        array = new ArrayList();
    }

    public void push(Object x)
    {
        array.add(x);
    }

    public Object pop()
    {
        return array.remove(array.size() - 1);
    }
    
    public Object peekTop()
    {
        return array.get(array.size() - 1);
    } 
    public boolean isEmpty()
    {
        return array.size() == 0;
    } 

    private ArrayList array; 
} 
