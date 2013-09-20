package lec09.glab.structs;

/**
 * The class for linked list nodes that will be used
 * and tested on the
 * Advanced Placement Computer Science exam.
 * For example, the two questions below, similar to
 * Questions 15 and 33 on the 1992 released AB exam, show
 * some of the <code>ListNode</code> methods in use. These
 * are shown here as two questions emerging from common code. On
 * the released exam these questions were not related.
 * <P>
 * <em>(Question 15)
 * Consider the static methods <code>print</code> and <code>create</code>
 * in the class <code>List</code> below. What is printed
 * by the call <code>List.print(List.create(5))</code> ?</em>
 * <P>
 * <OL type="A">
 * <LI> <code>5 4 3 2 1</code>
 * <LI> <code>1 2 3 4 5</code>
 * <LI> <code>5 1</code>
 * <LI> <code>5</code>
 * <LI> <code>1</code> 
 * </OL>
 * </em>
 * <P>
 * <em>(Question 33) Consider the static method <code>process</code>
 * in the class <code>List</code> below.
 * Suppose <code>p<code> represents
 * the list <code>(1,2,3,4)</code>; what is
 * returned by the call <code>List.process(p,null)</code>?</em>
 * <P>
 *
 * <OL type="A">
 * <LI> <code>null</code>
 * <LI> <code>(1)</code>
 * <LI> <code>(1,1,1,1)</code>
 * <LI> <code>(4,3,2,1)</code>
 * <LI> <code>(1,2,3,4)</code>
 * </OL>
 * <P> 
 * 
 * <PRE>
 * public class List
 * {
 *     // return a linked list based on parameters list and soFar
 *
 *     public static ListNode process(ListNode list, ListNode soFar)
 *     {
 *         if (list == null) {
 *             return soFar;
 *         }
 *         else {
 *             ListNode temp = list.getNext();
 *             list.setNext(soFar);
 *             return process(temp,list);
 *         }
 *      }
 *
 *      // return a new linked list based on parameter n
 *
 *      public static ListNode create(int n)
 *      {
 *	    ListNode list = null;
 *	    for(int k=1; k <= n; k++) {
 *	        list = new ListNode(new String(""+k), list);
 *	    }
 *  	    return list;
 *      }
 *
 *      // print a linked list
 *
 *      public static void print(ListNode list)
 *      {
 *	    while (list != null) {
 *	        System.out.print(list.getValue()+" ");
 *	        list = list.getNext();
 *	    }
 *	    System.out.println();
 *      }
 * }
 * </PRE> 
 *
 */

public class ListNode
{
	
    private Object value;
    private ListNode next;
	
	
    /**
     * Construct a list node with specified value and next node.
     * @param initValue is the value in the constructed node
     * @param initNext is the value of the next node (returned by
     * <code>getNext()</code>)
     */
    
    public ListNode(Object initValue, ListNode initNext)
    {
        value = initValue;
        next = initNext;
    }

    /**
     * Returns the value stored in this node.
     * @return this node's value
     */
    
    public Object getValue()
    {
        return value;
    }

    /**
     * Returns the next node after this node.
     * @return the node after this node
     */
    public ListNode getNext()
    {
        return next;
    }

    /**
     * Sets the value stored in this node.
     * @param theNewValue is the (new) value of this node
     */
    public void setValue(Object theNewValue)
    {
        value = theNewValue;
    }

    /**
     * Sets the next node after this node
     * @param theNewNext is the (new) next node after this node
     */
    public void setNext(ListNode theNewNext)
    {
        next = theNewNext;
    }


}
