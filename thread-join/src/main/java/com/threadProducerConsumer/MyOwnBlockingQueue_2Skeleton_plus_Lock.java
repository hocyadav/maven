package com.threadProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

//1. skeleton
//2. add lock
public class MyOwnBlockingQueue_2Skeleton_plus_Lock<E> {
	Queue<E> queue;
	int size = 16;//default size
	ReentrantLock reentrantLock = new ReentrantLock(true);

	public MyOwnBlockingQueue_2Skeleton_plus_Lock(int newSize) {
		this.queue = new LinkedList();
		this.size = newSize;
	}

	public void put(E obj) {
		reentrantLock.lock();
		queue.add(obj);
		reentrantLock.unlock();
	}


	public E take() {
		E removeItem = null;
		try {
			reentrantLock.lock();
			removeItem = queue.remove();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reentrantLock.unlock();
		}
		return removeItem;
	}
}
