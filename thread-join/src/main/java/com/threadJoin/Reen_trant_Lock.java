package com.threadJoin;

import java.util.concurrent.locks.ReentrantLock;

public class Reen_trant_Lock {
	ReentrantLock reentrantLock = new ReentrantLock();
	//golobal variable
	int a = 0;
	int b = 0;
	int x = 0;
	public void funUpdate() {
		reentrantLock.lock();
		//updating value
		a = 1;
		b = 1;
		x = 1;
		reentrantLock.unlock();
	}
	
	public void readValue() {
		reentrantLock.lock();
		//reading updated value here
		System.out.println(a);
		System.out.println(b);
		System.out.println(x);
		reentrantLock.unlock();
	}
	
}
