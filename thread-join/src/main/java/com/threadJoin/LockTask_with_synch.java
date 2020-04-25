package com.threadJoin;


public class LockTask_with_synch {
	//golobal variable
	int a = 0;
	int b = 0;
	int x = 0;
	
	public void funUpdate() {
		synchronized (this) {
			//updating value
			a = 1;
			b = 1;
			x = 1;
		}
	}
	
	public void readValue() {
		synchronized (this) {
			System.out.println(a);
			System.out.println(b);
			System.out.println(x);
		}
		//reading updated value here
	}
	
}
