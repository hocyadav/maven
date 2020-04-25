package com.threadProducerConsumer.MyBQImpl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//1. skeleton
//2. add lock
public class MyOwnBlockingQueue_using_Lock_and_Condition<E> {
	Queue<E> queue;
	int max = 16;//default size
	ReentrantLock reentrantLock = new ReentrantLock(true);
	private Condition condition1 = reentrantLock.newCondition();//condition on lock
	private Condition condition2 = reentrantLock.newCondition();

	public MyOwnBlockingQueue_using_Lock_and_Condition(int newSize) {
		this.queue = new LinkedList();
		this.max = newSize;
	}

	public void put(E obj) throws InterruptedException {
		reentrantLock.lock();
		if (queue.size() == max) {//if Q full - block the thread
			condition1.await();//make current thread to wait
		}
		queue.add(obj);
		condition2.signalAll();
		reentrantLock.unlock();
	}


	public E take() {
		E removeItem = null;
		try {
			reentrantLock.lock();
			while(queue.size() == 0) {//if Q empty - block the thread
				condition2.await();
			}
			//replace if with while - to check for infinite thread
			removeItem = queue.remove();
			condition1.signalAll();//signal other methods conditionObj that now u can start execution(i.e. move from waiting to runnable state)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reentrantLock.unlock();
		}
		return removeItem;
	}
}
