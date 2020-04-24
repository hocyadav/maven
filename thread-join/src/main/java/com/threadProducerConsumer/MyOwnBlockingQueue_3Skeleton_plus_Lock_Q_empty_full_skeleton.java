package com.threadProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

//1. skeleton
//2. add lock
public class MyOwnBlockingQueue_3Skeleton_plus_Lock_Q_empty_full_skeleton<E> {
	Queue<E> queue;
	int max = 16;//default size
	ReentrantLock reentrantLock = new ReentrantLock(true);

	public MyOwnBlockingQueue_3Skeleton_plus_Lock_Q_empty_full_skeleton(int newSize) {
		this.queue = new LinkedList();
		this.max = newSize;
	}

	public void put(E obj) {
		reentrantLock.lock();
		if (queue.size() == max) {//if Q full
			//block the thread
		}
		queue.add(obj);
		reentrantLock.unlock();
	}


	public E take() {
		E removeItem = null;
		try {
			reentrantLock.lock();
			if(queue.size() == 0) {//if Q empty
				//block the thread
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
