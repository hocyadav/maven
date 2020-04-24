package com.thread_Runnable_Collable_Future;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TEST_Task_Callable2{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		List<Future<Integer>> allFutureObj = new LinkedList<Future<Integer>>();
		
		for (int i = 0; i < 10; i++) {
			Future<Integer> future = executorService.submit(new Task_Callable());
			allFutureObj.add(future);
		}
		//perform some other operation
		
		for (int i = 0; i < 10; i++) {
			Thread.sleep(2000);
			
			Future<Integer> future = allFutureObj.get(i);//get future obj
			Integer value = future.get();//get value from future obj - this is blocking operation, if value is not present then it will not store and print
			
			System.out.println(value);
		}
	}
}
