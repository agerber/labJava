package edu.uchicago.gerber.labjava.lec09.glab.structs;

/**
 * The interface for priority queues as they will be used on the
 * Advanced Placement Computer Science exam. Exam questions
 * may use the <code>PriorityQueue</code> interface as the type for
 * parameters, variables, and fields.  Consider
 * the question below which asks to remove all items
 * from a priority queue that are smaller than a specified
 * limit and the code for the answer.
 * The question can be answered using just the <code>PriorityQueue</code>
 * interface.
 * <P>
 * <em>Write the function <code>removeLessThan</code> that removes
 * all items in parameter <code>pq</code> that are strictly less than
 * parameter <code>limit</code>.  Assume all items stored in
 * <code>pq</code> implement the <code>Comparable</code> interface.</em>
 * <P>
 * <PRE>
 * // Removes all items less than limit from pq

 * public static void removeLessThan(PriorityQueue q, Comparable limit)
 * {
 *     while (! pq.isEmpty() && limit.compareTo(pq.peekMin()) > 0) {
 *         pq.removeMin();
 *     }
 * }
 * </PRE> 
 <P>
 * Note: there is no method <code>size</code> to return the number
 * of elements stored in a priority queue, the AP subset/interface doesn't
 * include such a method.
 * <P>
 * @version 1.0
 */

public interface PriorityQueue 
{
    /**
     * Returns true if this stack is empty, otherwise returns false.
     * @return true if this stack is empty, otherwise return false.
     */    
  boolean isEmpty(); 

    /**
     * Adds an item to this priority queue.
     * @param x is the object added to this priority queue
     */

  void add(Object x); 

    /**
     * Removes and returns the smallest item stored in this priority
     * queue.
     * @return the smallest item stored in this priority queue
     * @throws RuntimeException if the priority queue is empty
     * (unchecked)
     */

  Object removeMin(); 

    /**
     * Returns the smallest item stored in this priority
     * queue without removing it.
     * @return the smallest item stored in this priority queue
     * @throws RuntimeException if the priority queue is empty (unchecked)
     */
    
  Object peekMin(); 
} 
