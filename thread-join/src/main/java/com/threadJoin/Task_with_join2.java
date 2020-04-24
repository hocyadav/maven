package com.threadJoin;

import java.util.concurrent.atomic.AtomicInteger;

public class Task_with_join2 {
	public static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				for(int i = 0; i<100; i++) {
					count.getAndIncrement();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				for(int i = 0; i<100; i++) {
					count.getAndIncrement();
				}
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("main class end "+count);

	}
}
