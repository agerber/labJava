package lec09.glab.structs;



public class DoubleLinkedList
{
  DoubleNode dndHead, dndTail;

  public DoubleLinkedList ()
  {
    dndHead = null;
    dndTail = null;

  }

  
  public DoubleNode getHead(){
	  return dndHead;
  }
  
  public DoubleNode getTail(){
	  return dndTail;
  }

  //this method will always insert in sorted order
  public void add ( Comparable comVal )
  {
    DoubleNode dndBefore, dndAfter, dndNew;
    dndBefore = null;
    dndAfter = dndHead;

    //move through the list until its proper place is found or end of list
    while ( ( dndAfter != null ) && comVal.compareTo( dndAfter.getValue() ) > 0 )
    {
      dndBefore = dndAfter;
      dndAfter = dndAfter.getNext();
    }

    //instantiate the new node and assign its next to dndAfter
    //and before to dndBefore
    dndNew = new DoubleNode( dndBefore, comVal, dndAfter );

    //if dndBefore is null then the dndNew belongs in front
    if ( dndBefore == null )
    {
      //at this point, it belongs in front of an occupied list or the list is empty
      //either way, we set the head.
      dndHead = dndNew;
      //if we're dealing with an empty LL then we need to assign the tail to the same
      //node
      if ( dndAfter == null )
      {
        dndTail = dndNew;
      }
      //otherwise, leave the tail alone
      //and get a reference back
      else
      {
        dndAfter.setPrev( dndNew );
      }

    }
    //at the end of the list
    //the empty LL case is already dealt with above
    else if ( dndAfter == null )
    {
      dndTail = dndNew;
      dndBefore.setNext( dndNew );

    }
    //works in all other cases
    else
    {
      dndBefore.setNext( dndNew );
      dndAfter.setPrev( dndNew );
    }
  } //end insert


  public void remove ( Comparable comVal )
  {
    DoubleNode dndBefore, dndCurrent;
    dndBefore = null;
    dndCurrent = dndHead;

    while ( ( dndCurrent != null ) && ( !comVal.equals( dndCurrent.getValue() ) ) )
    {
      dndBefore = dndCurrent;
      dndCurrent = dndCurrent.getNext();
    }

    //reached the end of the list, terminate mehtod now
    if ( dndCurrent == null )
    {
      return;
    }

    //remove is at the beginning
    if ( dndCurrent == dndHead )
    {

      dndHead = dndCurrent.getNext();
      dndHead.setPrev(null);
    }
     //remove is at the end
    else if ( dndCurrent == dndTail )
    {
      dndTail = dndBefore;
      dndTail.setNext(null);

    }
    //remove in the middle and therefore do not disturb head
    //or tail
    else
    {

      dndBefore.setNext( dndCurrent.getNext() );
      dndCurrent.getNext().setPrev(dndBefore);
    }

  } //end remove


//  //getIterator method
//  public MyDoubleIterator getIterator ()
//  {
//    return new MyDoubleIterator( dndHead, dndTail );
//  }

}
