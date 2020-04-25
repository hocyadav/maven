package com.threadJoin;

public class Test {
	public static void main(String[] args) {
		System.out.println("Main thread started..");
		Thread thread1 = new Thread(new TaskToPerform());
		thread1.start();
		System.out.println("main thread end");
	}
}
