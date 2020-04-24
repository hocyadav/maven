package com.threadJoin;

public class Reen_trant_Lock_TEST {
	public static void main(String[] args) {
		final Reen_trant_Lock lockTask = new Reen_trant_Lock();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				lockTask.funUpdate();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				lockTask.readValue();
			}
		});
		
		t1.start();
		t2.start();
		System.err.println("main end");
		
	}
}
