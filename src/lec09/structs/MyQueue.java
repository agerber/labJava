package lec09.structs;



public class MyQueue 
{
  ListNode nodHead;

  public MyQueue ()
  {
    nodHead = null;

  }


  public void enqueue ( Object objValue )
  {
    addFirst( objValue );
  }


  public Object dequeue ()
  {
    return removeLast();
  }


  public boolean isEmpty ()
  {
    return nodHead == null;

  }

  //this is a bit of a misnomer,
  //you're peeking at the last node, but not removing it
  public Object peekFront ()
  {
    if ( nodHead == null )
    {
      return null;
    }
    //only one node
    else if ( nodHead.getNext() == null )
    {
      Object objR = nodHead.getValue();
      return objR;
    }
    //2 or more nodes
    else
    {

      ListNode nodBefore, nodCurrent;

      nodBefore = null;
      nodCurrent = nodHead;
      while ( nodCurrent.getNext() != null )
      {
        nodBefore = nodCurrent;
        nodCurrent = nodCurrent.getNext();
      }
      Object objR = nodCurrent.getValue();

      return objR;

    }

  }


  private void addFirst ( Object objValue )
  {
    //there are no nodes
    if ( nodHead == null )
    {
      ListNode nodNew = new ListNode( objValue, null );
      nodHead = nodNew;

    }
    //there's only one
    else
    {
      ListNode nodNew = new ListNode( objValue, nodHead );
      nodHead = nodNew;

    }

  }


  private Object removeLast ()
  {
    //no nodes
    if ( nodHead == null )
    {
      return null;
    }
    //only one node
    else if ( nodHead.getNext() == null )
    {
      Object objR = nodHead.getValue();
      nodHead = null;
      return objR;
    }
    //2 or more nodes
    else
    {

      ListNode nodBefore, nodCurrent;

      nodBefore = null;
      nodCurrent = nodHead;
      while ( nodCurrent.getNext() != null )
      {
        nodBefore = nodCurrent;
        nodCurrent = nodCurrent.getNext();
      }
      Object objR = nodCurrent.getValue();
      nodBefore.setNext( null );
      return objR;

    }

  }




}
