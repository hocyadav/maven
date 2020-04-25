package com.threadJoin;

public class TaskToPerform implements Runnable{
	public void run() {
		try {
			System.out.println("task thread start");
			Thread.sleep(2000);
			System.out.println("Task thread end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
