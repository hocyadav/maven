package com.threadProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//1. skeleton
//2. add lock
public class MyOwnBlockingQueue_6HandleEdgeCase_for2thread<E> {
	Queue<E> queue;
	int max = 16;//default size
	ReentrantLock reentrantLock = new ReentrantLock(true);
	private Condition condition1 = reentrantLock.newCondition();//condition on lock
	private Condition condition2 = reentrantLock.newCondition();

	public MyOwnBlockingQueue_6HandleEdgeCase_for2thread(int newSize) {
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
			if(queue.size() == 0) {//if Q empty - block the thread
				condition2.await();//in this state let 2 thread went for waiting state
			}//when then both 2 thread get signal to execute then they come here..same time : solution : again check if queueis empty or not
			
			if(queue.size() == 0) {//here 2nd waiting thread can check again for queue size
				condition2.await();
			}
			
			removeItem = queue.remove();//here only 1 thread can come (other is waiting for lock to release)
			condition1.signalAll();//signal other methods contion that now u can start execution
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reentrantLock.unlock();
		}
		return removeItem;
	}
}
