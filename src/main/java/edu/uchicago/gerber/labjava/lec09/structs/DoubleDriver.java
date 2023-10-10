package edu.uchicago.gerber.labjava.lec09.structs;


public class DoubleDriver
{
  public static void main ( String[] args )
  {

    DoubleLinkedList nodDubs = new DoubleLinkedList();
    nodDubs.add( "Abbee" );
    nodDubs.add( "Brian" );
    nodDubs.add( "Charlie" );
    nodDubs.add( "Matt" );
    nodDubs.add( "Zoe" );

  

  
   DoubleNode dbnCurr = nodDubs.getHead();
    
    while ( dbnCurr != null )
    {
      System.out.println( dbnCurr.getValue() );
      dbnCurr = dbnCurr.getNext();
    }
    nodDubs.remove( "Matt" );
    System.out.println( "******************" );
    
    dbnCurr = nodDubs.getTail();
    
    while ( dbnCurr != null )
    {
      System.out.println( dbnCurr.getValue() );
      dbnCurr = dbnCurr.getPrev();
    }



  }
}
