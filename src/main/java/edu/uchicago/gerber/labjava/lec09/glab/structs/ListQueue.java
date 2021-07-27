package edu.uchicago.gerber.labjava.lec09.glab.structs;

import java.util.LinkedList;

/**
 * A simple yet completely functional implementation
 * of the <code>Queue</code> interface. The interface
 * is part of the AP subset and is testable. This implementation
 * is <b>not</b> part of the subset, but is useful in
 * a classroom setting.
 * <P>
 * All queue functions execute in <em>O(1)</em> or constant time
 * amortized over several queue operations. This is because the
 * underlying storage is <code>java.util.LinkedList</code> which
 * supports constant time access, put (to end and front), and remove
 * (from end and front).
 * <P>
 * This implementation is provided
 * at <a href="http://apcentral.collegeboard.com">apcentral</a>.
 */


public class ListQueue implements Queue 
{
    /**
     * Constructs an initially empty queue.
     */
    
    public ListQueue()
    {
        list = new LinkedList();
    } 

    public void enqueue(Object x)
    {
        list.addLast(x);
    }
    
    public Object dequeue()
    {
        return list.removeFirst();
    }
    
    public Object peekFront()
    {
        return list.getFirst();
    }
    
    public boolean isEmpty()
    {
        return list.size() == 0;
    } 

    private LinkedList list; 
} 
