/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lec10.glab.javafx;

import java.util.concurrent.*;

public class CallableExample {
   public static void main(String[] args) throws InterruptedException, ExecutionException {
	   ExecutorService service =  Executors.newSingleThreadExecutor();
	   SumTask sumTask = new SumTask(10);
	   Future<Integer> future = service.submit(sumTask);
           
         //  new Thread((Runnable) sumTask).start();
	   try {
		   sumTask.call();
	   } catch (Exception e) {
		   e.printStackTrace();
	   }

	   Integer result = future.get();
	   System.out.println(result);
   }
}

class SumTask implements Callable<Integer> {
	private int num = 0;
   public SumTask(int num){
   	this.num = num;
   }
	@Override
	public Integer call() throws Exception {
		int result = 2;

		for (int nC = 0; nC < num ; nC++) {
			result *=2;
		}

		return result;
	}
}