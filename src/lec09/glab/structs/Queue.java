package lec09.glab.structs;

/**
 * The interface for queues as they will be used on the
 * Advanced Placement Computer Science exam. Exam questions
 * may use the <code>Queue</code> interface as the type for
 * parameters, variables, and fields.  Consider
 * the question below which asks to reverse
 * the elements stored in a queue and the code for the answer.
 * The question can be answered using just the <code>Queue</code>
 * interface.
 * <P>
 * <em>Write the function <code>reverseQueue</code> that reverses
 * the order of the items in parameter <code>q</code>. If <code>q</code>
 * stores <code>(q<sub>0</sub>, q<sub>1</sub>, ...,
 * q<sub>n-1</sub>)</code> before the function is called with
 * <code>q<sub>0</sub></code> as the first element of <code>q</code>,
 * then <code>q</code> stores <code>(q<sub>n-1</sub>,
 * ... q<sub>1</sub>, q<sub>0</sub>)</code> after the function
 * executes, where <code>q<sub>0</sub></code> is now the last element
 * of <code>q</code>.</em>
 * <P>
 * <PRE>
 * // Reverses the order of the items stored in parameter q
 
 * public static void reverseQueue(Queue q)
 * {
 *     ArrayList list = new ArrayList();
 *     while (! q.isEmpty()) {
 *         list.add(q.dequeue());
 *     }
 *     for(int k=list.size()-1; k >= 0; k--) {
 *         q.enqueue(list.get(k));
 *     }
 * }
 * </PRE>
 * <P>
 * Note: there is no method <code>size</code> to return the number
 * of elements stored in a queue, the AP subset/interface doesn't
 * include such a method.
 * <P>
 * @version 1.0
 */

public interface Queue 
{
    /**
     * Returns true if this queue is empty, otherwise returns false.
     * @return true if this queue is empty, otherwise return false.
     */
  boolean isEmpty(); 

    /**
     * Enqueue an element onto the back of this queue.
     * @param x is the object enqueued onto this queue.
     */
  void enqueue(Object x); 

    /**
     * Dequeues and returns the first element of the queue.
     * @see ap.Queue#peekFront
     * @return the just-dequeued element of the queue
     * @throws RuntimeException if this queue is empty (unchecked)
     */

  Object dequeue(); 

    /**
     * Returns the first element of the queue without dequeuing it.
     * @see ap.Queue#dequeue
     * @return the first element of the queue
     * @throws RuntimeException if this queue is empty (unchecked)
     */
  Object peekFront(); 
} 
