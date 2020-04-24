package com.threadProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//1. skeleton
//2. add lock
public class MyOwnBlockingQueue_4Condition_added_onLock<E> {
	Queue<E> queue;
	int max = 16;//default size
	ReentrantLock reentrantLock = new ReentrantLock(true);
	private Condition condition1 = reentrantLock.newCondition();//condition on lock
	private Condition condition2 = reentrantLock.newCondition();

	public MyOwnBlockingQueue_4Condition_added_onLock(int newSize) {
		this.queue = new LinkedList();
		this.max = newSize;
	}

	public void put(E obj) throws InterruptedException {
		reentrantLock.lock();
		if (queue.size() == max) {//if Q full - block the thread
			condition1.await();//now waiting for someone to give signal and this waiting thread will start execution
		}
		queue.add(obj);
		reentrantLock.unlock();
	}


	public E take() {
		E removeItem = null;
		try {
			reentrantLock.lock();
			if(queue.size() == 0) {//if Q empty - block the thread
				condition2.await();
			}
			removeItem = queue.remove();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reentrantLock.unlock();
		}
		return removeItem;
	}
}
