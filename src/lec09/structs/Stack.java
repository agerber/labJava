package lec09.structs;

/**
 * The interface for stacks as they will be used on the
 * Advanced Placement Computer Science exam. Exam questions
 * may use the <code>Stack</code> interface as the type for
 * parameters, variables, and fields.  Consider
 * the question below which asks for a function
 * that destructively counts and returns the
 * number of items in a stack and the code for the answer.
 * The question can be answered using just the <code>Stack</code>
 * interface.
 * <P>
 * <em>Write the function <code>stackSize</code> that returns
 * the number of items in parameter <code>s</code>. Note that
 * <code>s</code> is empty after <code>stackSize</code> executes.</em>
 * <P>
 * <PRE>
 * // Returns the number of items in s; s is empty after the function executes.

 * public static int stackSize(Stack s)
 * {
 *     int size = 0;
 *     while (! s.isEmpty()) {
 *         size++;
 *         s.pop();
 *     }
 *     return size;
 * }
 * </PRE>
 * <P>
 *
 * Note: there is no method <code>size</code> to return the number
 * of elements stored in a stack, the AP subset/interface doesn't
 * include such a method.
 * <P>
 * @version 1.0
 */

public interface Stack 
{ 
    /**
     * Returns true if this stack is empty, otherwise returns false.
     * @return true if this stack is empty, otherwise return false.
     */
  boolean isEmpty(); 

    /**
     * Push an element onto the top of this stack.
     * @param x is the object pushed onto this stack.
     */

  void push(Object x); 

    /**
     * Pops and returns the top element of the stack.
     * @see ap.Stack#peekTop
     * @return the just-popped element of the stack
     * @throws RuntimeException if this stack is empty (unchecked)
     */

  Object pop(); 

    /**
     * Returns the top element of the stack without popping it.
     * @see ap.Stack#pop
     * @return the top element of the stack
     * @throws RuntimeException if this stack is empty (unchecked)
     */

  Object peekTop(); 
} 
