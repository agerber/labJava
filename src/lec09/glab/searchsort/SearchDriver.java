package lec09.glab.searchsort;

import java.util.Arrays;
import java.util.Random;

public class SearchDriver {


	private static int[] nVals;
	private static Random ran; 
	
	public static void main(String[] args) {
		
		nVals = new int[512];
		ran = new Random();
		//assign some numbers to the array
		for (int nC = 0; nC < nVals.length; nC++) 
			nVals[nC] = ran.nextInt(1000);
		
	System.out.println("#####################linear search#################");	
	  for (int nC = 0; nC < 30; nC++) 
		  System.out.println(findValueLinear(ran.nextInt(100), nVals));
	
	  System.out.println("#####################binary search#################");
	  
	   Arrays.sort(nVals);
   
     for (int nC = 0; nC < 30; nC++) 
    	 System.out.println(findValueBinary(ran.nextInt(100), nVals));
	   
	   

	}
	
	//very slow O(n)
	private static String findValueLinear(int nFind, int[] nVals){
		int nCount = 0;
		String strR = "";
		
		for (int nC = 0; nC < nVals.length; nC++){
			nCount++;
			if(nVals[nC] == nFind){
				strR += nFind +" found at " + nC;
				break;
			}
		}
		strR+= " : " + nCount + " iterations.";
		return strR;
	}
	
	//fast O(log2 n)  takes sorted data only
	private static String findValueBinary(int nFind, int[] nVals){
		int nCount = 0;
		String strR = "";
		
		int nStart, nEnd, nMid;
		nStart = 0;
		nEnd = nVals.length - 1;

		while(nStart <= nEnd){
			nCount++;
			nMid = (nStart + nEnd)/2;
			if(nVals[nMid] == nFind){
				strR += nFind +" found at " + nMid;
				break;
			}
			else if(nVals[nMid] < nFind)
				nStart = nMid + 1;
			else
				nEnd = nMid -1;
		}
		strR+= " : " + nCount + " iterations.";
		return strR;

	}
	
	
	
	
	
	
	
	
	
	

}
