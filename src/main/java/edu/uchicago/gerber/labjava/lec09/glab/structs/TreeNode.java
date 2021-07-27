package edu.uchicago.gerber.labjava.lec09.glab.structs;

/**
 * The class for nodes in a binary tree that will be
 * used and tested on the 
 * Advanced Placement Computer Science exam. 
 * For example, the question below, similar to
 * Question 14 on the 1992 released AB exam, shows
 * many of the <code>TreeNode</code> methods in use.
 * <P>
 * <em>Consider methods <code>m</code> and <code>f</code>
 * below. If the precondition for <code>f</code> is satisfied,
 * which of the following is the best postcondition?</em>
 * <P>
 * <OL type="A">
 * <LI> Returns the greatest value stored in the tree
 * <LI> Returns the least value stored in the tree
 * <LI> Returns the value at the root of the tree
 * <LI> Returns the last value visited during execution of <code>f</code>
 * <LI> Returns the first duplicated value encountered during
 * execution of <code>f</code>.
 * </OL>
 * <P>
 * <PRE>
 * public class T
 * {
 *     public static Object m(Object a, Object b)
 *     {
 *        if ( ( (Comparable) a).compareTo(b) >= 0) {
 *            return a;
 *        }
 *        else {
 *            return b;
 *        }
 *      }
 *
 * 
 *  // precondition: t != null, that is t is not an empty tree
 *  // postcondition:
 *
 *    public static Object f(TreeNode t)
 *    {
 *       if (t.getLeft() == null && t.getRight() == null) {
 *           return t.getValue();
 *       }
 *       else if (t.getLeft() == null) {
 *           return m(t.getValue(), f(t.getRight()));
 *       }
 *       else if (t.getRight() == null) {
 *           return m(t.getValue(), f(t.getLeft()));
 *       }
 *       else {
 *           return m(m(t.getValue(), f(t.getLeft())), f(t.getRight()));
 *       }
 *    }
 * }
 * </PRE>
 * <P>
 * Note: this class has nothing to do
 * with the standard Java interface <code>javax.swing.tree.TreeNode</code>.
 * <P>
 * This implementation is provided
 * at <a href="http://apcentral.collegeboard.com">apcentral</a>.
 * @version 1.0
 */

public class TreeNode
{
    /**
     * Construct a tree node with specified value, left, and right
     * subtrees.
     * @param initValue is the value stored in the node
     * @param initLeft is the left subtree of the node
     * @param initRight is the right subtree of the node
     */
    
    public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
    {
        value = initValue; left = initLeft; right = initRight;
    }

    /**
     * Returns the value stored in this tree node.
     * @return this tree node's value
     */
    
    public Object getValue()
    {
        return value;
    }

    /**
     * Returns the left subtree of this node.
     * @return a reference to the left subtree of this node
     */
    
    public TreeNode getLeft()
    {
        return left;
    }

    /**
     * Returns the right subtree of this node.
     * @return a reference to the right subtree of this node
     */
    
    public TreeNode getRight()
    {
        return right;
    }

    /**
     * Sets the value of this tree node.
     * @param theNewValue is the (new) value stored in this node
     */
    
    public void setValue(Object theNewValue)
    {
        value = theNewValue;
    }

    /**
     * Sets the value of the left subtree of this node.
     * @param theNewLeft is the (new) left subtree of this node
     */
    
    public void setLeft(TreeNode theNewLeft)
    {
        left = theNewLeft;
    }

    /**
     * Sets the value of the right subtree of this node.
     * @param theNewRight is the (new) right subtree of this node
     */
    
    public void setRight(TreeNode theNewRight)
    {
        right = theNewRight;
    }

    private Object value;
    private TreeNode left;
    private TreeNode right;
} 

