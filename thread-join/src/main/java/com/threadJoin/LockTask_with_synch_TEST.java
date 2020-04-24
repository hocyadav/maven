package com.threadJoin;

public class LockTask_with_synch_TEST {
	public static void main(String[] args) {
		final LockTask_with_synch syntask = new LockTask_with_synch();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				syntask.funUpdate();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				syntask.readValue();
			}
		});
		
		t1.start();
		t2.start();
		
		
	}
}
