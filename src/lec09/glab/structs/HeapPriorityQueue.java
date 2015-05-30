package lec09.glab.structs;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the PriorityQueue interface using
 * a binary heap. For algorithmic and data structure
 * details see Mark Weiss' Data Structures
 * and Problem Solving with Java, Addison Wesley.
 *
 * <P>
 *
 * This class supports (n = # items stored in priority queue)
 * <P>
 * <TABLE style="border: 1pt solid black">
 * <th align="center" width=40%> operation
 * <th align="center" width=40%> worst case
 * <th align="center"> average case    <tr>
 * <td> put            <td> O(log n)         <td> O(1)            <tr>
 * <td> peekMin        <td> O(1)             <td> O(1)            <tr>
 * <td> removeMin      <td> O(log n)         <td> O(log n)        <tr>
 * </TABLE>
 * <P>
 * Implementation concepts borrowed from Mark Weiss;
 * the basic idea is that the <em>node</em> whose index is k
 * has children stored with indexes 2*k and 2*k+1 for left/right
 * children, respectively. The root of the binary heap has index 1.
 * <P>
 * @author Owen Astrachan
 */

public class HeapPriorityQueue implements PriorityQueue 
{
    /**
     * Constructs an empty priority queue.
     */
    
    public HeapPriorityQueue()
    {
        items = new ArrayList();
        items.add(null);            // first put should go at index 1
        mySize = 0;
    } 

    public void add(Object x)
    {
        items.add(x);
        mySize++;
        int k = mySize;
        while (k > 1 && ((Comparable) items.get(k/2)).compareTo(x) > 0) {
            items.set(k,items.get(k/2));
            k = k/2;
        }
        items.set(k,x);
    } 


    public Object removeMin() 
    {
        if (! isEmpty()) {
            Object min = peekMin();
            items.set(1,items.get(mySize));
            mySize--;
            if (mySize > 1) {
                heapify(1);
            }
            return min;
        }
        return null;
    }

    public Object peekMin() 
    {
        return items.get(1);
    }

    public boolean isEmpty()
    {
        return mySize == 0;
    }

    /**
     * preconditon: subheaps of vroot satisfy heap property (and shape)
     * postcondition: heap rooted at vroot satisfies heap property
     */
    
    private void heapify(int vroot)
    {
        Comparable last = (Comparable) items.get(vroot);
        int child,k=vroot;

        while (2*k <= mySize) {

            // find minimal child, start with left, then check right
            child = 2*k;
            if (child < mySize &&    // right child exists
                ((Comparable)        // check if right < left
                 items.get(child+1)).compareTo(items.get(child)) < 0) {
                child++;
            }

            // if item to be added <= child, stop and put the item
            
            if (last.compareTo(items.get(child)) <= 0) {
                break;
            }
            else {
                items.set(k,items.get(child));
                k = child;
            }
        }
        items.set(k,last);
    }

    private List items;
    private int  mySize;
} 
