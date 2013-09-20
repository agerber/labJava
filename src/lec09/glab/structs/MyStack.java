package lec09.glab.structs;



public class MyStack

{
  ListNode nodHead;

  public MyStack()
  {
    nodHead = null;

  }

  public void push(Object objValue)
  {
    addFirst(objValue);
  }

  public Object pop()
  {
    return removeFirst();
  }

  public boolean isEmpty()
  {
    return nodHead == null;
  }

  public Object peekTop()
  {
    if (nodHead == null)
    {
      return null;
    }
    else
    {
      return nodHead.getValue();
    }
  }

  private void addFirst(Object objValue)
  {
    ListNode nodNew = new ListNode(objValue, nodHead);
    nodHead = nodNew;

  }

  private Object removeFirst()
  {
    if (nodHead == null)
    {
      return null;
    }
    else
    {
      Object objReturn = nodHead.getValue();
      nodHead = nodHead.getNext();
      return objReturn;
    }

  }



}
