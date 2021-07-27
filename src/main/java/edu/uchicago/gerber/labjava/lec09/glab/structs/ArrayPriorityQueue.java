package edu.uchicago.gerber.labjava.lec09.glab.structs;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple yet completely functional implementation
 * of the <code>PriorityQueue</code> interface. The interface
 * is part of the AP subset and is testable. This implementation
 * is <b>not</b> part of the subset, but is useful in
 * a classroom setting.
 * <P>
 * This class supports (n = # items stored in priority queue)
 * <code>PriorityQueue</code> operations with the following
 * complexities.
 * <P>
 * <TABLE>
 * <th> operation      <th> worst case       <th> average case    <tr>
 * <td> put            <td> O(1)             <td> O(1)            <tr>
 * <td> peekMin        <td> O(n)             <td> O(n)            <tr>
 * <td> removeMin      <td> O(n)             <td> O(n)            <tr>
 * </TABLE>
 * <P> 
 * The underlying storage is <code>java.util.ArrayList</code> which
 * supports constant time put (to end), but which requires linear
 * search to find the smallest element.
 * <P>
 * This implementation is provided
 * at <a href="http://apcentral.collegeboard.com">apcentral</a>.
 */


public class ArrayPriorityQueue implements PriorityQueue 
{
    /**
     * Constructs an initially empty priority queue.
     */
    
    public ArrayPriorityQueue()
    {
        items = new ArrayList();
    } 

    public void add(Object x)
    {
        items.add(x);
    } 

    public Object removeMin() 
    {
        Object min = peekMin();
	items.remove(min);
	return min;
    }

    public Object peekMin() 
    { 
        int minIndex = 0; 
        for (int i = 1; i < items.size(); i++) {
	    Comparable c = (Comparable) items.get(i);
            if (c.compareTo(items.get(minIndex)) < 0) { 
                minIndex = i; 
            } 
        } 
        return items.get(minIndex); 
    } 

    public boolean isEmpty()
    {
        return items.size() == 0;
    } 

    private List items; 
} 
