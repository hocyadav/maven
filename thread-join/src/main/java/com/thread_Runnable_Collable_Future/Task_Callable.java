package com.thread_Runnable_Collable_Future;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task_Callable implements Callable<Integer>{

	public Integer call() throws Exception {
		int nextInt = new Random().nextInt(100);
		System.out.println("call body # "+nextInt);
		return nextInt;
	}

}
