package lec09.glab.simpledatastructs.stack_as_array;

import java.util.Arrays;

public class Stack <T>
{ 

private int nSize;
private static final int CAP = 50;
private Object[] objEs;

	


	public Stack(){
		
		nSize = 0;
		objEs = new Object[CAP];
		
	}
	
	
  public boolean isEmpty(){
	  
	  
	return (nSize == 0);
	  
  }



  public void push(T typ){
	  
	 if(nSize == objEs.length-1)
		 ensureCapa();

	 objEs[nSize++] = typ;
	 
	 
	  
  }
  
  
	private void ensureCapa() {
		int nNewSize = objEs.length + CAP;
		objEs = Arrays.copyOf(objEs, nNewSize);
	}



	@SuppressWarnings("unchecked")
	public T pop() {
		
		if(isEmpty())
			return null;
		
		//get the top one
		T typ = (T) objEs[nSize - 1];
		
		//set the top element to null
		objEs[nSize - 1] = null;
		
		//decrement the size by one
		nSize--;
		return typ;
	}


	
	 @SuppressWarnings("unchecked")
	 public T peek(){
		  
		 return (T) objEs[nSize - 1];
		 
	  }
  
  
  

  
} 





