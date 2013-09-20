package lec09.searchsort;


public class Quick
{

  //public one arg version that calls 3 arg version
  public static void sort(Comparable[] cList)
  {
    sort(cList, 0, cList.length - 1);
  }

 //private 3 arg recursive
  private static void sort(Comparable[] cList, int nL, int nR)
  {

    int nPivot;

    swap (nL, (nL + nR) / 2, cList);
    int nLastSmall = nL;
    for (int nC = nL + 1; nC <= nR; nC++)
    {
      if (cList[nC].compareTo(cList[nL]) <= 0)
      {
        nLastSmall++;
        swap(nLastSmall, nC, cList);
      }
    }

     swap(nL, nLastSmall, cList);
     nPivot = nLastSmall;

     if (nL < nPivot - 1)
     {
       sort(cList, nL, nPivot - 1);
     }


     if (nPivot + 1 < nR)
     {
       sort(cList, nPivot + 1, nR);
     }



  }//end sort




  private static void swap(int nI, int nJ, Comparable[] cArray)
  {

   Comparable cTemp =  cArray[nI];
   cArray[nI] = cArray[nJ];
   cArray[nJ] = cTemp;


  }


  //integer version
  //above is overloaded to take int[]
  //public one arg version that calls 3 arg version
  public static void sort(int[] nList)
  {
    sort(nList, 0, nList.length - 1);
  }

 //private 3 arg recursive
  private static void sort(int[] nList, int nL, int nR)
  {

    int nPivot;

    swap (nL, (nL + nR) / 2, nList);
    int nLastSmall = nL;
    for (int nC = nL + 1; nC <= nR; nC++)
    {
      if (nList[nC] <= nList[nL])
      {
        nLastSmall++;
        swap(nLastSmall, nC, nList);
      }
    }

     swap(nL, nLastSmall, nList);
     nPivot = nLastSmall;

     if (nL < nPivot - 1)
     {
       sort(nList, nL, nPivot - 1);
     }


     if (nPivot + 1 < nR)
     {
       sort(nList, nPivot + 1, nR);
     }



  }//end sort




  private static void swap(int nI, int nJ, int[] nArray)
  {

   int cTemp =  nArray[nI];
   nArray[nI] = nArray[nJ];
   nArray[nJ] = cTemp;


  }





}

