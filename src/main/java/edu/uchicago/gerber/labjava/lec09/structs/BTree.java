package edu.uchicago.gerber.labjava.lec09.structs;

//import ap.java.util.*;

public class BTree
{
  //root
  private BNode nodRoot;


  public BTree()
  {

    nodRoot = null;

  } //end BTree

  public void add(Comparable c)
  {
    BNode nodNew = new BNode(c);

    if (nodRoot == null)
    {
      nodRoot = nodNew;
    }
    else
    {
      addNode(nodRoot, nodNew);
    }
  } //end put

  private void addNode(BNode nodCur, BNode nodNew)
  {
    if ( ( (Comparable) (nodNew.getValue())).compareTo(nodCur.getValue()) < 0)
    {
      if (nodCur.getLeft() == null)
      {
        nodCur.setLeft(nodNew);

      }
      else
      {
        addNode( (BNode) nodCur.getLeft(), nodNew);
      }

    }
    //greater
    else
    {
      if (nodCur.getRight() == null)
      {
        nodCur.setRight(nodNew);

      }
      else
      {
        addNode( (BNode) nodCur.getRight(), nodNew);
      }

    }
  } //end addNode

  //cooperative method
  public String toString()
  {
    return toString(nodRoot);
  } //end toString()

  public String toString(BNode nodMe)
  {

    //in order traversal

    String sR = "";
    if (nodMe.getLeft() != null)
    {
      sR += toString( (BNode) nodMe.getLeft()) + "\n";
    }

    sR += nodMe.getValue();

    if (nodMe.getRight() != null)
    {
      sR += "\n" + toString( (BNode) nodMe.getRight());
    }

    return sR;
  } //end toString()





  public BNode getRoot()
  {
     return nodRoot;
  }







} //end class
