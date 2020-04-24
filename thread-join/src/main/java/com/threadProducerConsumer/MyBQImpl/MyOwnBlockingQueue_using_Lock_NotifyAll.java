package com.threadProducerConsumer.MyBQImpl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
//impl same as lock and contion
//1. replace lock and unlock with synchronize keyword
//2. replace Condition with Object (coz Object class have wait and notifyAll methods)
//3. replace await --> wait, signalALL --> notifyAll
public class MyOwnBlockingQueue_using_Lock_NotifyAll<E> {
	Queue<E> queue;
	int max = 16;//default size
	private Object condition1 = new Object();//2
	private Object condition2 = new Object();//2

	public MyOwnBlockingQueue_using_Lock_NotifyAll(int newSize) {
		this.queue = new LinkedList();
		this.max = newSize;
	}

	public synchronized void put(E obj) throws InterruptedException {//1
		if (queue.size() == max) {
			condition1.wait();//3
		}
		queue.add(obj);
		condition2.notifyAll();//3
	}


	public synchronized E take() {//1
		E removeItem = null;
		try {
			while(queue.size() == 0) {
				condition2.wait();//3
			}
			removeItem = queue.remove();
			condition1.notifyAll();//3
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return removeItem;
	}
}
