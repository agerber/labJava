package lec09.searchsort;




public class Sequential
{

  //O(n) , doesn't require a sorted data set.
//return the index of the searchKey, otherwise returns -1 if not found
  public static int search ( int[] nNums, int nKey )
  {
    for ( int nC = 0; nC < nNums.length; nC++ )
    {
      //System.out.println( nNums[nC] );
      if ( nNums[nC] == nKey )
      {
        return nC;
      }
    }
    return -1;
  } //end seqSearchIter ints


  //overloaded to take Comparables (strings and Wrapper classes)
  //return the index of the searchKey, otherwise returns -1 if not found
  //O(n) , doesn't require a sorted data set.
  public static int search ( Comparable[] cNums, Comparable cKey )
  {
    for ( int nC = 0; nC < cNums.length; nC++ )
    {
      //System.out.println( cNums[nC] );
      if ( cNums[nC].compareTo( cKey ) == 0 )
      {
        return nC;
      }
    }
    return -1;
  }


  public static int searchRec ( int[] nNums, int nKey, int nIndex )
  {
    if ( nIndex == nNums.length )
    {
      return -1;
    }
    if ( nNums[nIndex] == nKey )
    {
      System.out.println( nNums[nIndex] );
      return nIndex;
    }
    System.out.println( nNums[nIndex] );
    return searchRec( nNums, nKey, nIndex + 1 );
  } //end searchRec ints


  //overloaded to take Comparables
  public static int searchRec ( Comparable[] cVals, Comparable cKey, int nIndex )
  {
    if ( nIndex == cVals.length )
    {
      return -1;
    }
    if ( cVals[nIndex].compareTo( cKey ) == 0 )
    {
      System.out.println( cVals[nIndex] );
      return nIndex;
    }
    System.out.println( cVals[nIndex] );
    return searchRec( cVals, cKey, nIndex + 1 );
  }

} //end class
