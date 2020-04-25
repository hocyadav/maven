package com.thread_Runnable_Collable_Future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TEST_Task_Callable{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		//executorService.execute(new Task_Callable()); //execute will take only Runnable obj : solu : use submit
		
		executorService.submit(new Task_Callable());//it will only execute body
		
		//Future = Place holder
		Future<Integer> future = executorService.submit(new Task_Callable());//to store return type int value
		//Future is place holder .. after thread will complete exec then return value from call will store in this furure obj
		
		Integer integer = future.get();//get actual return value from future obj
		//this future.get is blocking operation , it will only save value to int variable when operation is complere,
		//else main thread will block this line
		
		System.out.println(integer);
		
	}
}
