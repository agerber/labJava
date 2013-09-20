
package lec09.glab.structs;
public class DoubleNode
{

  private DoubleNode dndPrev;
  private DoubleNode dndNext;
  private Comparable comValue;

  public DoubleNode ( DoubleNode dndPrev, Comparable comValue,
                      DoubleNode dndNext )
  {

    this.dndPrev = dndPrev;
    this.dndNext = dndNext;
    this.comValue = comValue;

  }


  public void setNext ( DoubleNode dndNext )
  {
    this.dndNext = dndNext;
  }


  public void setPrev ( DoubleNode dndPrev )
  {
    this.dndPrev = dndPrev;
  }


  public DoubleNode getPrev ()
  {
    return dndPrev;
  }


  public DoubleNode getNext ()
  {
    return dndNext;
  }


  public Comparable getValue ()
  {
    return comValue;
  }


  public void setValue ( Comparable comValue )
  {
    this.comValue = comValue;
  }

}
