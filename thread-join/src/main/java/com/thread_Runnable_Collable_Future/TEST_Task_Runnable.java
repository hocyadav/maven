package com.thread_Runnable_Collable_Future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TEST_Task_Runnable{
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		executorService.execute(new Task_Runnable());
		executorService.submit(new Task_Runnable());//this method take obj as Runnable and Callable also
		
	}
}
