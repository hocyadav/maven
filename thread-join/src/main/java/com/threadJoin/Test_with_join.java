package com.threadJoin;

public class Test_with_join {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread started..");
		Thread thread1 = new Thread(new TaskToPerform());
		thread1.start();
		thread1.join();//makes thread 1 to complete
		System.out.println("main thread end");
	}
}
